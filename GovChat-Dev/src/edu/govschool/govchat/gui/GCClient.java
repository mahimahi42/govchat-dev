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
    