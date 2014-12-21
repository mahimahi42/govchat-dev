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
 * GUI for the GovChat server.
 * Most of the actual work is handled with <code>GCServerSocket</code>, this
 * provides us with a GUI to work with this socket and the entire server in
 * general.
 * @author Mr. Davis
 */
public class GCServer extends Application
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
    
    // Since this is the server GUI, we need a server socket!
    private GCServerSocket serverSocket;
    
    // Some flags to represent several states our application can be in
    private boolean socketClosed = true;
    private boolean tryingToConnect = false;
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage)
    {
        
    }
}