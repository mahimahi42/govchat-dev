package edu.govschool.govchat.socket;

// For input/output streams
import java.io.*;
// For built-in sockets
import java.net.*;
// For Platform.runLater()
import javafx.application.Platform;

/**
 * Generic socket to extend for use in GovChat.
 * Based on Oracle documentation.
 * Abstract classes must have their abstract methods implemented in a subclass,
 * which will happen in <code>GCClientSocket</code> and 
 * <code>GCServerSocket</code>. We define this 'generic' socket, however, 
 * because both the client and server sockets share a lot of the same code.
 * @author Mr. Davis
 */
public abstract class GCGenericSocket implements GCSocketListener
{

}