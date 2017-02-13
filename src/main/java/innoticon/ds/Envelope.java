package innoticon.ds;

import com.google.gson.annotations.Expose;

import java.util.HashMap;

import static innoticon.ds.Action.Type.SEND_ENVELOPE_REQ;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 12.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Envelope extends innoticon.ds.Req {
    public static innoticon.ds.Envelope Gen(long unique){
        return new innoticon.ds.Envelope(innoticon.Client.Gen());
    }

    public static innoticon.ds.Envelope Gen(long unique, innoticon.ds.From from){
        return new innoticon.ds.Envelope(innoticon.Client.Gen(), from);
    }

    @Expose public innoticon.ds.From from = null;
    /** because firebase/ firebase not support list */
    @Expose public HashMap<String,innoticon.ds.To> destinations = null;
    /** because firebase/ firebase not support list */
    @Expose public HashMap<innoticon.ds.Message.Key, innoticon.ds.Message> messages = null;

    public innoticon.ds.From from(){ return from; }
    public HashMap<String,innoticon.ds.To> destinations(){ return destinations; }
    public HashMap<innoticon.ds.Message.Key, innoticon.ds.Message> messages(){ return messages; }

    public innoticon.ds.To destination(String key){ return destinations.get(key); }
    public innoticon.ds.Message message(innoticon.ds.Message.Key key){ return messages.get(key); }

    public Envelope add(innoticon.ds.To to){
        if(to!=null){
            if(destinations==null){
                destinations = new HashMap<>();
            }
            destinations.put(to.key(), to);
        }
        return this;
    }

    public Envelope del(innoticon.ds.To to){
        if(to!=null){
            if(destinations!=null){
                destinations.remove(to.key());
            }
        }
        return this;
    }

    public Envelope del(String key){
        if(destinations!=null){
            destinations.remove(key);
        }
        return this;
    }

    public Envelope add(innoticon.ds.Message message){
        if(message!=null){
            if(messages==null){
                messages = new HashMap<>();
            }
            messages.put(message.key(), message);
        }
        return this;
    }

    public Envelope del(innoticon.ds.Message message){
        if(message!=null){
            if(messages!=null){
                messages.remove(message.key());
            }
        }
        return this;
    }

    public Envelope del(innoticon.ds.Message.Key key){
        if(key!=null){
            if(messages!=null){
                messages.remove(key);
            }
        }
        return this;
    }

    public Envelope(){}

    public Envelope(long unique){
        super(unique, SEND_ENVELOPE_REQ);
        innoticon.Client client = innoticon.Client.Get();
        this.from = new innoticon.ds.From(client);
    }

    public Envelope(long unique, innoticon.ds.From from){
        super(unique, SEND_ENVELOPE_REQ);
        this.from = from;
    }
}
