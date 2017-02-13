package innoticon.msg;

import com.google.gson.annotations.Expose;
import innoticon.ds.Drawable;

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

    @Override public Drawable drawable(Builder builder) { return builder.draw(this, Emoticon.class); }

    @Override public String text(Builder builder) { return builder.text(this, Emoticon.class); }

}