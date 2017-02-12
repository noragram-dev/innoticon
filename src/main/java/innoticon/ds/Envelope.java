package innoticon.ds;

import com.google.gson.annotations.Expose;

import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 12.
 */
public class Envelope {
    @Expose public From from;
    @Expose public HashMap<String,To> destinations;         /** because firebase/ firebase not support list */
    @Expose public HashMap<String,Message> messages;        /** because firebase/ firebase not support list */

    public From from(){ return from; }
    public Collection<To> destinations(){ return destinations.values(); }

    public Collection<Message> messages(){ return messages.values(); }

    public To destination(String key){ return destinations.get(key); }
    public Message message(String key){ return messages.get(key); }

}
