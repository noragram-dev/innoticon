package innoticon.msg;

import com.google.gson.annotations.Expose;
import innoticon.ds.Draw;
import innoticon.ds.Envelope;
import innoticon.ds.Message;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 12.
 */
public class Text implements innoticon.ds.Message {
    private Envelope __parent;      /** must not set expose for reculsive gson parse , occurring stack overflow */
    private Builder __builder;      /** must not set expose it's not data, only method ... */
    @Expose String str;

    @Override
    public Envelope envelope(){
        return __parent;
    }

    @Override public Draw drawable() { return __builder.draw(this, Text.class); }

    @Override public Draw drawable(Builder builder) { return builder.draw(this,Text.class); }

    @Override public String text(Builder builder) { return builder.text(this,Text.class); }

    @Override public String text() { return __builder.text(this, Text.class); }

    @Override
    public Message builder(Builder builder) {
        __builder = builder;
        return this;
    }
}
