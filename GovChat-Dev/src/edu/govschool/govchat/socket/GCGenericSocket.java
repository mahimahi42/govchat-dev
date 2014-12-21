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
    // For testing purposes, we'll use a default port of 2000.
    // It is defined here in the superclass because both the
    // client and server need to agree on the port.
    public static final int DEFAULT_PORT = 2000;
    
    // The port we'll be using
    public int port;
    // The Socket connection we'll be using
    // `protected` means that we and our subclasses can access this property, 
    // no classes outside us.
    protected Socket socketConncetion = null;
    // Streams to perform I/O
    private BufferedWriter output = null;
    private BufferedReader input = null;
    // Flag to see if our setup has completed
    private boolean ready = false;
    // Thread to setup our connection
    private Thread setupThread;
    // Thread to read message from our connection
    private Thread readerThread;
}