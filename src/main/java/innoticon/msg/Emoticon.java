package innoticon.msg;

import com.google.gson.annotations.Expose;
import innoticon.ds.Draw;
import innoticon.ds.Envelope;
import innoticon.ds.Message;

/**
 * Gif type (emoji) messages.
 */
public class Emoticon implements innoticon.ds.Message {
    private Envelope __parent;      /** must not set expose for reculsive gson parse , occurring stack overflow */
    private Builder __builder;      /** must not set expose it's not data, only method ... */
    // Unique resource ID.
    @Expose
    String resourceId;
    // Text description.
    @Expose
    String text;

    @Override
    public Envelope envelope(){
        return __parent;
    }

    @Override public Draw drawable() { return __builder.draw(this, Emoticon.class); }

    @Override public Draw drawable(Builder builder) { return builder.draw(this, Emoticon.class); }

    @Override public String text(Builder builder) { return builder.text(this, Emoticon.class); }

    @Override public String text() { return __builder.text(this, Emoticon.class); }

    @Override
    public Message builder(Builder builder) {
        __builder = builder;
        return this;
    }
}