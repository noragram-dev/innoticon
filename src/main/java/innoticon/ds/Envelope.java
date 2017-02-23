package innoticon.ds;

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
@SuppressWarnings({"WeakerAccess", "unused", "DanglingJavadoc"})
public class Envelope extends innoticon.ds.Req {
    /**
     * if you call this, automatically set action object and from field set client's {@link innoticon.ds.User}
     * @return | {@link innoticon.ds.Envelope} | generated envelope |
     */
    public static innoticon.ds.Envelope Gen(){
        return new innoticon.ds.Envelope(innoticon.Client.Gen());
    }

    public static String Json(innoticon.ds.Envelope envelope){
        innoticon.Client client = innoticon.Client.Get();
        return client.toJson(envelope);
    }

//    public static innoticon.ds.Envelope Gen(String key, String msg){
//        innoticon.ds.Envelope envelope = null;
//        if(msg!=null){
//            envelope = Gen();
//            envelope.add(key, msg);
//        }
//        return envelope;
//    }

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

    public static innoticon.ds.Envelope Gen(innoticon.ds.From from){
        return new innoticon.ds.Envelope(innoticon.Client.Gen(), from);
    }

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
    @Expose public HashMap<String, String> messages = null;

    public innoticon.ds.Envelope one(String key, String value){
        innoticon.ds.Envelope envelope = null;
        if(key!=null && key.length()>0 && value!=null && value.length()>0){
            /**
             * no deep copy just
             * @todo check this logic
             */
            envelope = new innoticon.ds.Envelope(this);
            envelope.from = this.from;
            envelope.destinations = this.destinations;
            messages.put(key, value);
        } else {
            Log.e("envelope", "key==null && key.length()==0 && value==null && value.length()==0");
        }
        return envelope;
    }

    public innoticon.ds.Envelope one(innoticon.ds.Message msg){
        innoticon.ds.Envelope envelope = null;
        if(msg!=null){
            /**
             * no deep copy just
             * @todo check this logic
             */
            envelope = new innoticon.ds.Envelope(this);
            envelope.from = this.from;
            envelope.destinations = this.destinations;
            envelope.add(msg);
        } else {
            Log.e("envelope", "key==null && key.length()==0 && value==null && value.length()==0");
        }
        return envelope;
    }

    public innoticon.ds.From from(){ return from; }
    public HashMap<String,innoticon.ds.To> destinations(){ return destinations; }
    public HashMap<String, String> messages(){ return messages; }

    public innoticon.ds.To destination(String key){ return destinations.get(key); }

    @SuppressWarnings("unchecked")
    public innoticon.ds.Message message(innoticon.ds.Message.Key key) {
        innoticon.ds.Message message = null;
        if(key!=null){
            Class<innoticon.ds.Message> c;
            try {
                c = (Class<innoticon.ds.Message>) Class.forName(key.name());
                message = innoticon.Client.Deserialize(messages.get(key.hex()), c);
            } catch (ClassNotFoundException e) {
                Log.w("warning>", "class not found");
                message = innoticon.Client.Deserialize(messages.get(key.hex()),innoticon.msg.Abstract.class);
            } catch (ClassCastException e){
                Log.e("critical>", e.getMessage());
            }
        }
        return message;
    }

    public Envelope add(innoticon.ds.To to){
        if(to!=null){
            if(destinations==null){
                destinations = new HashMap<>();
            }
            destinations.put(to.key(), to);
        }
        return this;
    }
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
        if(message!=null && message.key()!=null){
            if(messages==null){
                messages = new HashMap<>();
            }
            messages.put(message.key().hex(), innoticon.Client.Serialize(message));
        }
        return this;
    }

    public Envelope add(String key, String msg){
        if(key!=null && key.length()>0 && msg!=null && msg.length()>0){
            messages.put(key, msg);
        }
        return this;
    }

    public Envelope del(innoticon.ds.Message message){
        if(message!=null){
            if(messages!=null){
                messages.remove(message.key().hex());
            }
        }
        return this;
    }

    public Envelope del(innoticon.ds.Message.Key key){
        if(key!=null){
            if(messages!=null){
                messages.remove(key.hex());
            }
        }
        return this;
    }

    public Envelope(){}

    public Envelope(Envelope envelope){
        super(envelope!=null ? envelope.action : null);
    }

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
