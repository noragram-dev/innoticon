package innoticon.msg;

//import innoticon.ds.Drawable;
//import innoticon.ds.Envelope;
//import innoticon.ds.Message;

import com.google.gson.annotations.Expose;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 13.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public  abstract class Abstract implements innoticon.ds.Message {
    protected innoticon.ds.Envelope __envelope = null;
    protected innoticon.ds.Message.Builder __builder = null;

    @Expose public innoticon.ds.Message.Key key = null;

    @Override public long timestamp(){ return key!=null ? key.timestamp() : 0; }

    @Override public innoticon.ds.Envelope envelope() { return __envelope; }
    @Override public void envelope(innoticon.ds.Envelope v) { __envelope = v; }

    @Override public innoticon.ds.Message.Key key() { return key; }
    @Override public void key(innoticon.ds.Message.Key v) { key = v; }

    @Override public Builder builder() { return __builder; }
    @Override public void builder(Builder v) { __builder = v; }

    @Override public innoticon.ds.Drawable drawable() { return drawable(__builder); }

    @Override public String text() { return text(__builder); }

    public Abstract(){}
}
