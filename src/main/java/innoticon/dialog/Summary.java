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

    @Expose public innoticon.ds.Envelope envelope = null;
    @Expose public innoticon.ds.User from = null;
    @Expose public long timestamp = 0;

    public innoticon.ds.Envelope envelope(){ return envelope; }
    public long timestamp(){ return timestamp; }
    public innoticon.ds.User from(){ return from; }

    public void envelope(innoticon.ds.Envelope v){ envelope = v; }
    public void timestamp(long v){ timestamp = v; }
    public void from(innoticon.ds.User v){ from = v; }

    public Summary(){}

    public Summary(innoticon.ds.Envelope envelope){
        this.envelope = envelope;
        this.timestamp = System.currentTimeMillis();
        this.from = envelope.from.user();
    }
}
