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
    
    public GCClientSocket(GCSocketListener fxListener,
                          String host,
                          int port)
    {
        super(port);
        this.host = host;
        this.fxListener = fxListener;
    }
    
    @Override
    public void onMessage(final String line)
    {
        
    }
    
    @Override
    public void onCloseUpdate(final Boolean isClosed)
    {
        
    }
    
    @Override
    public void initConnection() throws SocketException
    {
        
    }
    
    @Override
    public void closeAdditionalSockets() {}
}