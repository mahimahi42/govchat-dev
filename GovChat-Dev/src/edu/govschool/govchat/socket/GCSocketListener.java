package edu.govschool.govchat.socket;

/**
 * Listener interface for sockets used in GovChat.
 * Based on Oracle documentation. While our two sockets will be inheriting from
 * <code>GCGenericSocket</code> to share setup code, this interface will define
 * a few methods that the sockets will use differently depending on what they
 * are listening for. Additionally, these messages will interact somehow with
 * the JavaFX aspect of our application, so we have to deal with them 
 * individually.
 * @author Mr. Davis
 */
public interface GCSocketListener 
{
    // Fired when a message is received.
    public void onMessage(String line);
    // Fired when a close update is received.
    public void onCloseUpdate(Boolean closed);
}