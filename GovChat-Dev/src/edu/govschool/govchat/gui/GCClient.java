package edu.govschool.govchat.gui;

// We need our modals
import edu.govschool.govchat.gui.modals.*;
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
        // Initialize our GUI elements
        msgArea = new TextArea();
        entryField = new TextField();
        sendBtn = new Button("Send");
        connectBtn = new Button("Connect to localhost");
        
        // Set some options on our elements
        msgArea.setEditable(false); // Our messages should be read-only
        msgArea.setPrefColumnCount(20);
        msgArea.setPrefRowCount(20); // 20rows x 20characters big
        msgArea.setWrapText(true); // Our text will wrap if it's too big
        entryField.setPrefColumnCount(20); // Entry field is 20 characters wide
        entryField.setPromptText("Enter a message");
        
        // Set our event handlers
        sendBtn.setOnAction(e -> sendBtn_click());
        connectBtn.setOnAction(e -> connectBtn_click());
        
        // Organize our GUI
        HBox entryPane = new HBox(10, entryField, sendBtn);
        VBox pane = new VBox(10, msgArea, entryPane, connectBtn);
        pane.setAlignment(Pos.CENTER);
        
        // Display our GUI
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        
        // Set our window options
        primaryStage.setTitle("GovChat Client");
        primaryStage.setOnCloseRequest(e -> {
            if (clientSocket != null) clientSocket.shutdown();
        });
        primaryStage.show();
    }
    
    private void sendBtn_click()
    {
        // Create a temporary variable to store our message
        final String msg = entryField.getText();
        // Only send non-empty messages
        if (!msg.equals("")) {
            // Send the message over the connection
            clientSocket.sendMessage(msg);
            // Update our own message area
            msgArea.appendText("CLIENT: " + msg + "\n");
            // Set the entry field text to the empty string
            entryField.setText("");
        }
    }
    
    private void connectBtn_click()
    {
        // Only connect if we have no connection
        if (socketClosed) {
            final String[] connection = GCConnectionOptionsBox.show();
            clientSocket = new GCClientSocket(new ClientSocketListener(),
                                              connection[0],
                                              Integer.parseInt(connection[1]));
            clientSocket.connect();
        }
    }
    
    // This private class will be our listener for our client socket. It will
    // listen for messages sent from the server and for the connection status of
    // the socket.
    private class ClientSocketListener implements GCSocketListener
    {
        // If we've received a server message
        @Override
        public void onMessage(final String line)
        {
            msgArea.appendText("SERVER: " + line + "\n");
        }
        
        // Update our connection status
        @Override
        public void onCloseUpdate(final Boolean isClosed)
        {
            socketClosed = isClosed;
        }
    }
}
    