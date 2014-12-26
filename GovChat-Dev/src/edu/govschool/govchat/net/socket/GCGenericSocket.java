package edu.govschool.govchat.net.socket;

// For input/output streams
import java.io.*;
// For built-in sockets
import java.net.*;
// For Platform.runLater()
import javafx.application.Platform;

/**
 * Generic socket to extend for use in GovChat.
 * Based on Oracle documentation.
 * Abstract classes must have their abstract methods implemented in a subclass,
 * which will happen in <code>GCClientSocket</code> and 
 * <code>GCServerSocket</code>. We define this 'generic' socket, however, 
 * because both the client and server sockets share a lot of the same code.
 * @author Mr. Davis
 */
public abstract class GCGenericSocket implements GCSocketListener
{
    // For testing purposes, we'll use a default port of 2000.
    // It is defined here in the superclass because both the
    // client and server need to agree on the port.
    public static final int DEFAULT_PORT = 2000;
    
    // The port we'll be using
    public int port;
    // The Socket connection we'll be using
    // `protected` means that we and our subclasses can access this property, 
    // no classes outside us.
    protected Socket socketConnection = null;
    // Streams to perform I/O
    private BufferedWriter output = null;
    private BufferedReader input = null;
    // Flag to see if our setup has completed
    private boolean ready = false;
    // Thread to setup our connection
    private Thread setupThread;
    // Thread to read message from our connection
    private Thread readerThread;
    
    /**
     * Empty constructor.
     * Creates a new <code>GCGenericSocket</code> on port 2000.
     */
    public GCGenericSocket()
    {
        this(DEFAULT_PORT);
    }
    
    /**
     * Default constructor.
     * Creates a new <code>GCGenericSocket</code> on the given port.
     * @param port the port to bind to
     */
    public GCGenericSocket(int port)
    {
        this.port = port;
    }
    
    /**
     * Setup a connection in the background.
     * Later, <code>onCloseUpdate(boolean)</code> will be called if this method
     * successfully completes.
     */
    public void connect()
    {
        try {
            // Open the socket connection in the background and setup our I/O 
            // streams
            setupThread = new SocketSetupThread();
            setupThread.start();
            // Start the thread that will listen for message on the input stream
            // in the background
            readerThread = new SocketReaderThread();
            readerThread.start();
        } catch (Exception e) {} // You dun goofed!
    }
    
    /**
     * Shut down the socket from further use.
     * The socket can no longer accept connections after this method.
     */
    public void shutdown()
    {
        close();
    }
    
    /**
     * Closes down the socket.
     * <code>close()</code> is private so the implementation can be hidden and 
     * updated without changing things for the user.
     */
    private void close()
    {
        try {
            if (socketConnection != null && !socketConnection.isClosed()) {
                socketConnection.close();
            }
            
            System.out.println("Connection closed");
            
            // We need to let the JavaFX application know we've closed the
            // socket. Platform.runLater() will allow us to do that in a
            // thread-safe manner.
            Platform.runLater(() -> onCloseUpdate(true));
        } catch (IOException e) {} // You dun goofed!
    }
    
    /**
     * Initialize the socket connection.
     * The client and server sockets will initialize different, so this method 
     * is left as abstract, to be implemented in the subclasses.
     * @throws SocketException the connection could not be created
     */
    public abstract void initConnection() throws SocketException;
    
    /**
     * Closes any outstanding connections.
     * In case our subclasses create more than one socket, we'll close them
     * here.
     */
    public abstract void closeAdditionalSockets();
    
    /**
     * Wait until our setup is finished.
     * Our <code>SocketSetupThread</code> will called <code>notifyReady()</code>
     * to let us know it's done, successfully or otherwise. The
     * <code>synchronized</code> keyword means this method is thread-safe.
     */
    private synchronized void waitForReady()
    {
        while (!ready) {
            try {
                wait();
            } catch (InterruptedException e) {} // Goofin occurred.
        }
    }
    
    /**
     * Notify <code>waitForReady()</code> that we are, in fact, ready.
     */
    private synchronized void notifyReady()
    {
        ready = true;
        notifyAll(); // From java.lang.Object
    }
    
    /**
     * Send a <code>String</code> over the connection.
     * A newline is appended to the message for clarity.
     * @param msg the message to send
     */
    public void sendMessage(String msg)
    {
        try {
            output.write(msg, 0, msg.length());
            output.newLine();
            output.flush();
        } catch (IOException e) {} // The message failed to send...
    }
    
    /**
     * Setup our initial connection in the background.
     * Normally, our entire application would have to wait until the connection
     * occurred before continuing. However, since we will be doing it in a 
     * <code>Thread</code>, it will happen in the background.
     */
    private class SocketSetupThread extends Thread
    {
        // run() is the method that does the work of the Thread, like main() for
        // the entire application.
        @Override
        public void run()
        {
            try {
                // Initialize our socket connections.
                initConnection();
                // If we're successful, setup our I/O streams.
                if (socketConnection != null && !socketConnection.isClosed()) {
                    input = new BufferedReader(new InputStreamReader(
                            socketConnection.getInputStream()));
                    output = new BufferedWriter(new OutputStreamWriter(
                            socketConnection.getOutputStream()));
                    output.flush();
                }
                notifyReady(); // We're done! Let the world know
            } catch (Exception e) {
                // We failed, but we still have to close this Thread.
                notifyReady();
            }
        }
    }
    
    /**
     * Listen for messages in the background.
     * Again, our application would seem to freeze while waiting for messages.
     * We need to try to read from the input stream in the background.
     */
    private class SocketReaderThread extends Thread
    {
        @Override
        public void run()
        {
            // Wait for our setup to be finished
            waitForReady();
            
            // Let JavaFX know we have a working connection, if we do
            if (socketConnection != null && socketConnection.isConnected()) {
                Platform.runLater(() -> onCloseUpdate(false));
            }
            
            // Read from our input stream
            try {
                if (input != null) {
                    // This is a common convention for reading from an input
                    // stream.
                    String line;
                    while ((line = input.readLine()) != null) {
                        // We need to send our message to JavaFX, so we can
                        // display it in our GUI. But, to pass our line variable
                        // to a lambda, we have to make it final, or constant.
                        final String tmp = line;
                        Platform.runLater(() -> onMessage(tmp));
                    }
                }
            } catch (IOException e) {}
            // finally will run code regardless of whether or not we get an
            // exception, a good place to clean up everything
            finally {
                close();
            }
        }
    }
}