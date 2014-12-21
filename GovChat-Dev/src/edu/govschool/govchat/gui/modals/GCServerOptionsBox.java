package edu.govschool.govchat.gui.modals;

// For representing the connection
import java.util.Map;
// Our JavaFX imports
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

/**
 * Display a modal dialog to select the port.
 * This will allow server managers to set the port that clients will bind to.
 * @author Mr. Davis
 */
public class GCServerOptionsBox extends GCConnectionOptionsBox
{
    @Override
    public Map show() {
        // Create our Stage to display
        stage = new Stage();

        // Set some options for our window
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Connect to GovChat");

        // Initialize the rest of our elements
        portField = new TextField("2000");
        portLabel = new Label("Port:");
        connectBtn = new Button("Connect");

        // Set some options for our elements
        portField.setPrefColumnCount(4);
        connectBtn.setOnAction(e -> connectBtn_click());

        // Organize our elements
        HBox pane = new HBox(10, portLabel, portField, connectBtn);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10));
        Scene scene = new Scene(pane);

        // Display our window
        stage.setScene(scene);
        stage.showAndWait();

        return connection;
    }

    // We will represent the desired connection in the form of a map,
    // which is a data structure like an array but that uses Objects as indices,
    // not integers.
    @Override
    protected void connectBtn_click() {
        connection.put("port", portField.getText());
        stage.close();
    }
}