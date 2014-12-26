package edu.govschool.govchat.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Application to easily launch a GovChat client or server.
 * This launcher window will allow the user to setup their user, and then launch
 * a GovChat server or client instance.
 * @author Mr. Davis
 */
public class GCLauncher extends Application
{
    // The button to launch a server instance
    public static Button serverBtn;
    // The button to launch a client instance
    public static Button clientBtn;
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage)
    {
        // Create our buttons
        serverBtn = new Button("Launch Server");
        clientBtn = new Button("Launch Client");
        
        // Set our buttons' actions
        serverBtn.setOnAction(e -> {
            Platform.runLater(() -> new GCServer().start(new Stage()));
        });
        clientBtn.setOnAction(e -> {
            Platform.runLater(() -> new GCClient().start(new Stage()));
        });
        
        // Organize our window
        VBox pane = new VBox(10, serverBtn, clientBtn);
        Scene scene = new Scene(pane);
        
        // Create and show our window
        primaryStage.setScene(scene);
        primaryStage.setTitle("GovChat Launcher");
        primaryStage.show();
    }
}