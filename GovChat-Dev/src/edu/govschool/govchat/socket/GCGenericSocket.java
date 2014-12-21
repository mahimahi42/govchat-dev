package edu.govschool.govchat.socket;

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
    protected Socket socketConncetion = null;
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
    
    public void shutdown()
    {
        
    }
    
    private void close()
    {
        
    }
    
    public abstract void initConnection() throws SocketException;
    
    public abstract void closeAdditionalSockets();
    
    private synchronized void waitForReady()
    {
        
    }
    
    private synchronized void notifyReady()
    {
        
    }
    
    public void sendMessage(String msg)
    {
        
    }
    
    
    
    /**
     * Setup our initial connection in the background.
     * Normally, our entire application would have to wait until the connection
     * occurred before continuing. However, since we will be doing it in a 
     * <code>Thread</code>, it will happen in the background.
     */
    private class SocketSetupThread extends Thread
    {
        @Override
        public void run()
        {
            
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
            
        }
    }
}