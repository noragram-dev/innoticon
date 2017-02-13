package innoticon.msg;

import com.google.gson.annotations.Expose;
import innoticon.ds.Drawable;
import innoticon.ds.Envelope;
import innoticon.ds.Message;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 12.
 */
public class Text extends innoticon.msg.Abstract {
    @Expose public String str = null;

    public String str(){ return str; }
    public void str(String v){ this.str = v; }

    public Text(){}

    @Override public Drawable drawable(Builder builder) { return builder.draw(this, innoticon.msg.Text.class); }

    @Override public String text(Builder builder) { return builder.text(this, innoticon.msg.Text.class); }
}
