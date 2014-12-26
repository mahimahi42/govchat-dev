package edu.govschool.govchat.user;

import edu.govschool.govchat.net.GCServerInfo;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * This class represents a connected user to GovChat.
 * This class will store the entire representation of a connected user. This
 * includes any data or methods needed on this object. For example, the user's
 * nickname (or username) and favorite servers could be stored here. The class
 * implements the interface <code>Serializable</code> to allow it to be written
 * to a file.
 * @author Mr. Davis
 */
public class GCUser implements Serializable
{
    // The username of the user
    private String username;
    // A list of favorite servers
    private List<GCServerInfo> favoriteServers;
    
    /**
     * Empty constructor.
     * Creates a <code>GCUser</code> with empty information.
     */
    public GCUser()
    {
        this("");
    }
    
    /**
     * Default constructor.
     * Creates a <code>GCUser</code> with the given username.
     * @param username the username of the <code>GCUser</code>
     */
    public GCUser(String username)
    {
        this.username = username;
        this.favoriteServers = new LinkedList<>();
    }
    
    /**
     * Gets the username of this <code>GCUser</code>.
     * @return the username of this <code>GCUser</code>
     */
    public String getUsername()
    {
        return this.username;
    }
    
    /**
     * Gets the favorite servers of this <code>GCUser</code>.
     * All the methods of <code>java.util.LinkedList</code> are available to
     * search and mutate the list of favorite servers.
     * @return the list of favorite servers
     */
    public List<GCServerInfo> getFavoriteServers()
    {
        return this.favoriteServers;
    }
    
    /**
     * Add a server to the list of favorite servers.
     * This is a convenience method to quickly add a server to the list of
     * favorite servers.
     * @param server the server to add
     */
    public void addServerToFavorites(GCServerInfo server)
    {
        this.favoriteServers.add(server);
    }
}