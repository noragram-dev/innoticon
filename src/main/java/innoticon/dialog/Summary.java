package innoticon.dialog;

import com.google.gson.annotations.Expose;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 27.
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class Summary {
    public static innoticon.dialog.Summary Gen(innoticon.ds.Envelope envelope){ return new Summary(envelope); }

    @Expose public String envelope = null;
    @Expose public innoticon.ds.User from = null;
    @Expose public long timestamp = 0;

    public String envelope(){ return envelope; }
    public long timestamp(){ return timestamp; }
    public innoticon.ds.User from(){ return from; }

    public void envelope(String v){ envelope = v; }
    public void timestamp(long v){ timestamp = v; }
    public void from(innoticon.ds.User v){ from = v; }

    public Summary(){}

    public Summary(String envelope, innoticon.ds.User from){
        this.envelope = envelope;
        this.timestamp = System.currentTimeMillis();
        this.from = from;
    }

    public Summary(innoticon.ds.Envelope envelope){
        this.envelope = envelope.action.key.hex();
        this.timestamp = System.currentTimeMillis();
        this.from = envelope.from.user();
    }
}
