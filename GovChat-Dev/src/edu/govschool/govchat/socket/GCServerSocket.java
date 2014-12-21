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