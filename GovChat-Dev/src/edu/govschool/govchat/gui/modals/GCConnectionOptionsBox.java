package edu.govschool.govchat.gui.modals;

// For representing the connection
import java.util.HashMap;
import java.util.Map;
// Our JavaFX imports
import javafx.scene.control.*;
import javafx.stage.*;

/**
 * Display a modal dialog to select host and port.
 * This will allow users of our application to select the host and port they 
 * wish to connect to.
 * @author Mr. Davis
 */
public abstract class GCConnectionOptionsBox 
{
    protected Stage stage;
    protected TextField portField;
    protected Label portLabel;
    protected Button connectBtn;
    
    // The final representation of our desired connection
    protected Map<String, String> connection = new HashMap<>();
    
    // Methods to be overridden by our subclasses
    public abstract Map show();
    protected abstract void connectBtn_click();
}