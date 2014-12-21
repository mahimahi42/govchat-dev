package edu.govschool.govchat.gui;

// We need to import our socket package
import edu.govschool.govchat.socket.*;
// JavaFX imports
import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

/**
 * GUI for the GovChat client.
 * Most of the actual work is handled with <code>GCClientSocket</code>, this
 * provides us with a GUI to work with this socket and the entire client in
 * general.
 * @author Mr. Davis
 */
public class GCClient extends Application
{
    // Our GUI initially is very spartan, consisting of a large text area to
    // display messages sent and received, a entry field to enter messages, a
    // connect button and a send button. At first, we just connect using the
    // default host and port, localhost and 2000, so we don't need any elements
    // to input a custom host and port yet.
    private TextArea msgArea;
    private TextField entryField;
    private Button sendBtn;
    private Button connectBtn;
    
    // We need a client socket, since this is a client GUI
    private GCClientSocket clientSocket;
    
    // This flag will tell us if we're connected or not
    private boolean socketClosed = true;
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage)
    {
        
    }
    
    private void sendBtn_click()
    {
        
    }
    
    private void connectBtn_click()
    {
    
    }
    
    private class ClientSocketListener implements GCSocketListener
    {
        @Override
        public void onMessage(final String line)
        {
            
        }
        
        @Override
        public void onCloseUpdate(final Boolean isClosed)
        {
            
        }
    }
}
    