package edu.govschool.govchat.socket;

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
    
    @Override
    public void onMessage(final String line)
    {}
    
    @Override
    public void onCloseUpdate(final Boolean isClosed)
    {}
    
    @Override
    public void initConnection() throws SocketException 
    {}
    
    @Override
    public void closeAdditionalSockets()
    {}
}