package edu.govschool.govchat.gui.modals;

// For representing the connection
import java.util.HashMap;
import java.util.Map;
// Our JavaFX imports
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
public class GCClientOptionsBox extends GCConnectionOptionsBox
{
    // The unique GUI elements for our options box
    private static TextField hostField;
    private static Label hostLabel;

    @Override
    public Map show() {
        // Create our Stage to display
        stage = new Stage();

        // Set some options for our window
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Connect to GovChat");

        // Initialize the rest of our elements
        hostField = new TextField("localhost");
        portField = new TextField("2000");
        portLabel = new Label("Port:");
        hostLabel = new Label("Host:");
        connectBtn = new Button("Connect");

        // Set some options for our elements
        portField.setPrefColumnCount(4);
        hostField.setPrefColumnCount(20);
        connectBtn.setOnAction(e -> connectBtn_click());

        // Organize our elements
        HBox pane = new HBox(10, hostLabel, hostField, portLabel, portField,
                connectBtn);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10));
        Scene scene = new Scene(pane);

        // Display our window
        stage.setScene(scene);
        stage.showAndWait();

        return connection;
    }

    // We will represent the desired connection in the form of:
    //      hostname:port
    // which is a common representation
    @Override
    protected void connectBtn_click() {
        connection.put("hostname", hostField.getText());
        connection.put("port", portField.getText());
        stage.close();
    }
}