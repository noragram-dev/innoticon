package innoticon.ds;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import novemberizing.util.Log;

import java.util.HashMap;
import java.util.Collection;

import static innoticon.ds.Action.Type.SEND_ENVELOPE_REQ;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 12.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Envelope extends innoticon.ds.Req {
    /**
     * if you call this, automatically set action object and from field set client's {@link innoticon.ds.User}
     * @return | {@link innoticon.ds.Envelope} | generated envelope |
     */
    public static innoticon.ds.Envelope Gen(){
        return new innoticon.ds.Envelope(innoticon.Client.Gen());
    }

    /**
     * generated with message
     * @param msg
     * @param messages
     * @param <T>
     * @return
     */
    @SafeVarargs
    public static <T extends innoticon.ds.Message> innoticon.ds.Envelope Gen(T msg, T... messages){
        innoticon.ds.Envelope envelope = Gen();
        if(msg!=null){
            envelope.add(msg);
        }
        if(messages!=null){
            for(T message : messages){
                if(message!=null){
                    envelope.add(message);
                }
            }
        }
        return envelope;
    }

    /**
     * generated message
     * @param messages
     * @param <T>
     * @return
     */
    public static <T extends innoticon.ds.Message> innoticon.ds.Envelope Gen(T[] messages){
        innoticon.ds.Envelope envelope = Gen();
        if(messages!=null){
            for(T message : messages){
                if(message!=null){
                    envelope.add(message);
                }
            }
        }
        return envelope;
    }

    /**
     * generated message
     * @param messages
     * @param <T>
     * @return
     */
    public static <T extends innoticon.ds.Message> innoticon.ds.Envelope Gen(Collection<T> messages){
        innoticon.ds.Envelope envelope = Gen();
        if(messages!=null){
            for(T message : messages){
                if(message!=null){
                    envelope.add(message);
                }
            }
        }
        return envelope;
    }

    /**
     * if you want to generate modified envelope, call this.
     * @param from
     * @return
     */
    public static innoticon.ds.Envelope Gen(innoticon.ds.From from){
        return new innoticon.ds.Envelope(innoticon.Client.Gen(), from);
    }

    /**
     * generate envelope
     * @param from
     * @param msg
     * @param messages
     * @param <T>
     * @return
     */
    @SafeVarargs
    public static <T extends innoticon.ds.Message> innoticon.ds.Envelope Gen(innoticon.ds.From from, T msg, T... messages){
        innoticon.ds.Envelope envelope = Gen(from);
        if(msg!=null){
            envelope.add(msg);
        }
        if(messages!=null){
            for(T message : messages){
                if(message!=null){
                    envelope.add(message);
                }
            }
        }
        return envelope;
    }

    /**
     * generate envelope
     * @param from
     * @param messages
     * @param <T>
     * @return
     */
    public static <T extends innoticon.ds.Message> innoticon.ds.Envelope Gen(innoticon.ds.From from, T[] messages){
        innoticon.ds.Envelope envelope = Gen(from);
        if(messages!=null){
            for(T message : messages){
                if(message!=null){
                    envelope.add(message);
                }
            }
        }
        return envelope;
    }

    /**
     * generate envelope
     * @param from
     * @param messages
     * @param <T>
     * @return
     */
    public static <T extends innoticon.ds.Message> innoticon.ds.Envelope Gen(innoticon.ds.From from, Collection<T> messages){
        innoticon.ds.Envelope envelope = Gen(from);
        if(messages!=null){
            for(T message : messages){
                if(message!=null){
                    envelope.add(message);
                }
            }
        }
        return envelope;
    }

    /** from's information */
    @Expose public innoticon.ds.From from = null;
    /** because firebase/ firebase not support list */
    @Expose public HashMap<String,innoticon.ds.To> destinations = null;
    /** because firebase/ firebase not support list */
    @Expose public HashMap<innoticon.ds.Message.Key, String> messages = null;

    public innoticon.ds.From from(){ return from; }
    public HashMap<String,innoticon.ds.To> destinations(){ return destinations; }
    public HashMap<innoticon.ds.Message.Key, String> messages(){ return messages; }

    /**
     * get destination by key,
     * @param key
     * @return
     * @see innoticon.ds.To#key()
     */
    public innoticon.ds.To destination(String key){ return destinations.get(key); }

    /**
     * get message by key
     * @param key
     * @return
     */
    public innoticon.ds.Message message(innoticon.ds.Message.Key key) {
        innoticon.ds.Message message = null;
        if(key!=null){
            Class<innoticon.ds.Message> c;
            try {
                c = (Class<innoticon.ds.Message>) Class.forName(key.name());
                message = innoticon.Client.Deserialize(messages.get(key), c);
            } catch (ClassNotFoundException e) {
                Log.w("warning>", "class not found");
                message = innoticon.Client.Deserialize(messages.get(key),innoticon.msg.Abstract.class);
            } catch (ClassCastException e){
                Log.e("critical>", e.getMessage());
            }
        }
        return message;
    }

    /**
     * add destination
     * @param to
     * @return
     */
    public Envelope add(innoticon.ds.To to){
        if(to!=null){
            if(destinations==null){
                destinations = new HashMap<>();
            }
            destinations.put(to.key(), to);
        }
        return this;
    }

    /**
     * add destinations
     * @param to
     * @param destinations
     * @return
     */
    public Envelope add(innoticon.ds.To to, innoticon.ds.To... destinations){
        if(to!=null){
            if(this.destinations==null){
                this.destinations = new HashMap<>();
            }
            this.destinations.put(to.key(), to);
        }
        if(destinations!=null){
            if(this.destinations==null){
                this.destinations = new HashMap<>();
            }
            for(innoticon.ds.To destination: destinations){
                if(destination!=null) {
                    this.destinations.put(destination.key(), destination);
                }
            }
        }
        return this;
    }

    /**
     * add destinations
     * @param destinations
     * @return
     */
    public Envelope add(innoticon.ds.To[] destinations){
        if(destinations!=null){
            if(this.destinations==null){
                this.destinations = new HashMap<>();
            }
            for(innoticon.ds.To destination: destinations){
                if(destination!=null) {
                    this.destinations.put(destination.key(), destination);
                }
            }
        }
        return this;
    }

    /**
     * add destinations
     * @param destinations
     * @return
     */
    public Envelope add(Collection<innoticon.ds.To> destinations){
        if(destinations!=null){
            if(this.destinations==null){
                this.destinations = new HashMap<>();
            }
            for(innoticon.ds.To destination: destinations){
                if(destination!=null) {
                    this.destinations.put(destination.key(), destination);
                }
            }
        }
        return this;
    }

    /**
     * del destinations
     * @param to
     * @return
     */
    public Envelope del(innoticon.ds.To to){
        if(to!=null){
            if(destinations!=null){
                destinations.remove(to.key());
            }
        }
        return this;
    }

    /**
     * del destination by key "Dialog:[To.id()]"
     * @param key
     * @return
     */
    public Envelope del(String key){
        if(destinations!=null){
            destinations.remove(key);
        }
        return this;
    }

    /**
     * add message
     * @param message
     * @return
     */
    public Envelope add(innoticon.ds.Message message){
        if(message!=null && message.key()!=null){
            if(messages==null){
                messages = new HashMap<>();
            }
            messages.put(message.key(), innoticon.Client.Serialize(message));
        }
        return this;
    }

    /**
     * del message
     * @param message
     * @return
     */
    public Envelope del(innoticon.ds.Message message){
        if(message!=null){
            if(messages!=null){
                messages.remove(message.key());
            }
        }
        return this;
    }

    /**
     * del message
     * @param key
     * @return
     */
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
