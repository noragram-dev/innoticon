package innoticon.msg;

import com.google.gson.annotations.Expose;

/**
 * Gif type (emoji) messages.
 */
public class Emoticon extends innoticon.msg.Abstract {
    // Unique resource ID.

    @Expose
    public String resourceId = null;
    // Text description.
    @Expose
    public String text = null;

    public Emoticon(){}

}