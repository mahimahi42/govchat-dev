package edu.govschool.govchat.gui.modals;

import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

/**
 * Display a modal dialog to select host and port.
 * This will allow users of our application to select the host and port they 
 * wish to connect to.
 * @author Mr. Davis
 */
public class GCConnectionOptionsBox 
{
    // Our GUI elements for our options box
    private static Stage stage;
    private static TextField portField;
    private static TextField hostField;
    private static Button connectBtn;
    
    // The final representation of our desired connection
    private static String connection = "";
    
    public static String show()
    {
        // Create our Stage to display
        stage = new Stage();
        
        // Set some options for our window
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Connect to GovChat");
        
        // Initialize the rest of our elements
        portField = new TextField();
        hostField = new TextField();
        connectBtn = new Button("Connect");
        
        // Set some options for our elements
        portField.setPrefColumnCount(4);
        hostField.setPrefColumnCount(20);
        connectBtn.setOnAction(e -> connectBtn_click());
        
        // Organize our elements
        HBox pane = new HBox(10, hostField, portField, connectBtn);
        Scene scene = new Scene(pane);
        
        // Display our window
        stage.setScene(scene);
        stage.showAndWait();
        
        return connection;
    }
    
    // We will represent the desired connection in the form of:
    //      hostname:port
    // which is a common representation
    private static void connectBtn_click()
    {
        connection = hostField.getText() + ":" + portField.getText();
        stage.close();
    }
}