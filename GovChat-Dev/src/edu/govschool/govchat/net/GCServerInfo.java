package edu.govschool.govchat.net;

/**
 * Class to represent a GovChat server.
 * There are two pieces of information needed for a client to connect to a
 * GovChat server, the hostname and port. While we could use a data structure
 * such as a <code>Map</code> to represent this, creating a custom class allows
 * us full control over how we want to represent a server in GovChat.
 * @author Mr. Davis
 */
public class GCServerInfo 
{
    // A nickname for the server
    private String nickname;
    // The hostname of the server, either as a DNS address or IP
    private String hostname;
    // The port to bind to
    private int port;
    
    /**
     * Empty constructor.
     * Creates a new <code>GCServerInfo</code> with empty information. The port
     * is stored as <code>java.lang.Integer.MAX_VALUE</code>.
     */
    public GCServerInfo()
    {
        this("", "", Integer.MAX_VALUE);
    }
    
    /**
     * Convenience constructor.
     * Creates a new <code>GCServerInfo</code> with the given hostname and port
     * but without a nickname
     * @param hostname the hostname to connect to
     * @param port the port to bind to
     */
    public GCServerInfo(String hostname, int port)
    {
        this("", hostname, port);
    }
    
    /**
     * Default constructor.
     * Creates a new <code>GCServerInfo</code> with the given nickname,
     * hostname, and port.
     * @param nickname the nickname for the server
     * @param hostname the hostname to connect to
     * @param port the port to bind to
     */
    public GCServerInfo(String nickname, String hostname, int port)
    {
        this.nickname = nickname;
        this.hostname = hostname;
        this.port = port;
    }
    
    /**
     * Sets the nickname for the <code>GCServerInfo</code>.
     * We may want to update the nickname for a server.
     * @param nickname the new nickname
     */
    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    /**
     * Sets the hostname for the <code>GCServerInfo</code>.
     * The server details may change for a server.
     * @param hostname the new hostname
     */
    public void setHostname(String hostname)
    {
        this.hostname = hostname;
    }
    
    /**
     * Sets the port for the <code>GCServerInfo</code>.
     * The server details may change for a server.
     * @param port the new port
     */
    public void setPort(int port)
    {
        this.port = port;
    }
    
    /**
     * Gets the nickname from the <code>GCServerInfo</code>.
     * @return the current nickname
     */
    public String getNickname()
    {
        return this.nickname;
    }
    
    /**
     * Gets the hostname from the <code>GCServerInfo</code>.
     * @return the current hostname
     */
    public String getHostname()
    {
        return this.hostname;
    }
    
    /**
     * Gets the port from the <code>GCServerInfo</code>.
     * @return the current port
     */
    public int getPort()
    {
        return this.port;
    }
}