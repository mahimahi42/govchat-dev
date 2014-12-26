package edu.govschool.govchat.net.socket;

// For IOExceptions
import java.io.IOException;
// For socket classes
import java.net.*;
// For Platform
import javafx.application.Platform;

/**
 * Server socket implementation for GovChat.
 * Based on Oracle documentation.
 * This socket will act as the central server for our application. Our server
 * will instantiate an instance of this class for use.
 * @author Mr. Davis
 */
public class GCServerSocket extends GCGenericSocket
implements GCSocketListener
{
    // This instance of our interface will talk to JavaFX for us
    private GCSocketListener fxListener;
    // This ServerSocket will accept connections from clients
    private ServerSocket serverSocket;
    
    /**
     * Default constructor.
     * Creates an instance of our server socket on the given port
     * @param fxListener the listener instance to talk to our GUI
     * @param port the port to bind to
     */
    public GCServerSocket(GCSocketListener fxListener,
                          int port)
    {
        // super(int) calls the GCGenericSocket(int) constructor
        super(port);
        this.fxListener = fxListener;
    }
    
    /**
     * Debug constructor.
     * Creates an instance of our server socket on the default port of 2000
     * @param fxListener the listener instance to talk to our GUI
     */
    public GCServerSocket(GCSocketListener fxListener)
    {
        this(fxListener, DEFAULT_PORT);
    }
    
    /**
     * Read a message sent over the socket.
     * All we have to do is send the message to our GUI to display, but we could
     * do other things with it here.
     * @param line the received message
     */
    @Override
    public void onMessage(final String line)
    {
        Platform.runLater(() -> fxListener.onMessage(line));
    }
    
    /**
     * Change the connection status of the socket.
     * All we have to do again is inform the GUI.
     * @param isClosed true if we're closed, false otherwise
     */
    @Override
    public void onCloseUpdate(final Boolean isClosed)
    {
        Platform.runLater(() -> fxListener.onCloseUpdate(isClosed));
    }
    
    /**
     * Initialize a connection.
     * We create an instance of <code>ServerSocket</code> to accept incoming 
     * connections, and printing to STDOUT when we're successful.
     * @throws SocketException the connection could not be created
     */
    @Override
    public void initConnection() throws SocketException 
    {
        try {
            // Create our ServerSocket listening on our bound port
            serverSocket = new ServerSocket(port);
            // Allow us to have multiple bound connections
            serverSocket.setReuseAddress(true);
            // Wait for the connection
            System.out.println("Waiting...");
            socketConnection = serverSocket.accept();
            System.out.println("Connection successful: " + 
                            socketConnection.getInetAddress().getHostName());
        } catch (IOException e) {
            throw new SocketException();
        }
    }
    
    /**
     * Close the extra sockets we opened.
     * This is where the <code>ServerSocket</code> will be destroyed.
     */
    @Override
    public void closeAdditionalSockets()
    {
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        } catch (Exception e) {}
    }
}