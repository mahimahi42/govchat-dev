package edu.govschool.govchat.user;

import java.io.Serializable;

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
    }
}