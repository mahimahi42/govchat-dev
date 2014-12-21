package edu.govschool.govchat.socket;

// For IOExceptions
import java.io.IOException;
// For socket classes
import java.net.*;
// For Platform
import javafx.application.Platform;

/**
 * Client socket implementation for GovChat.
 * Based on Oracle documentation.
 * Each of the client GUI applications will create an instance of this class to
 * use to connect to the <code>GCServerSocket</code> created by the server.
 * @author Mr. Davis
 */
public class GCClientSocket extends GCGenericSocket
implements GCSocketListener
{
    /**
     * The default host for testing purposes.
     * <code>localhost</code> refers to the same computer a program runs on.
     */
    public static final String DEFAULT_HOST = "localhost";
    
    /**
     * The host this client is connected to.
     */
    public String host;
    // This instance of our interface will talk to JavaFX for us
    private GCSocketListener fxListener;
    
    /**
     * Default constructor.
     * Create a new client socket bound to the specified host and port
     * @param fxListener the listener instance to talk to our GUI
     * @param host the host to connect to
     * @param port the port to bind to
     */
    public GCClientSocket(GCSocketListener fxListener,
                          String host,
                          int port)
    {
        super(port);
        this.host = host;
        this.fxListener = fxListener;
    }
    
    /**
     * Debug constructor.
     * Create a new client socket connected to <code>localhost</code> on port 
     * 2000
     * @param fxListener the listener instance to talk to our GUI
     */
    public GCClientSocket(GCSocketListener fxListener)
    {
        this(fxListener, DEFAULT_HOST, DEFAULT_PORT);
    }
    
    /**
     * Read a message from the socket.
     * We use <code>Platform</code> to send our message to the GUI.
     * @param line the message received
     */
    @Override
    public void onMessage(final String line)
    {
        Platform.runLater(() -> fxListener.onMessage(line));
    }
    
    /**
     * Change the connection status of the socket.
     * <code>Platform</code> is again used to inform our GUI.
     * @param isClosed the new connection status of the socket
     */
    @Override
    public void onCloseUpdate(final Boolean isClosed)
    {
        Platform.runLater(() -> fxListener.onCloseUpdate(isClosed));
    }
    
    /**
     * Initialize a client connection.
     * We connect to the <code>GCServerSocket</code> listening on the host and 
     * port specified in the constructor.
     * @throws SocketException the connection failed to connect
     */
    @Override
    public void initConnection() throws SocketException
    {
        try {
            // Create our only socket
            socketConnection = new Socket();
            // Allow us to connect if another client fails to connect
            socketConnection.setReuseAddress(true);
            // Create the connection
            socketConnection.connect(new InetSocketAddress(host, port));
            System.out.println("Connected to: " + host + ":" + port);
        } catch (Exception e) {
            throw new SocketException();
        }
    }
    
    /**
     * Null method.
     * We have no extra sockets, so this method doesn't need an implementation.
     */
    @Override
    public void closeAdditionalSockets() {}
}