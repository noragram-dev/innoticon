package innoticon.msg;

import com.google.gson.annotations.Expose;
import novemberizing.util.Log;

import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 23.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Innoticon extends innoticon.msg.Abstract {
    private static final String Tag = "Innoticon";

    @SafeVarargs
    public static innoticon.msg.Innoticon Gen(novemberizing.ds.tuple.Pair<Integer,String> ev, novemberizing.ds.tuple.Pair<Integer,String>... events) {
        return new innoticon.msg.Innoticon(ev, events);
    }

    public static innoticon.msg.Innoticon Gen(novemberizing.ds.tuple.Pair<Integer,String>[] events){
        return new innoticon.msg.Innoticon(events);
    }

    public static innoticon.msg.Innoticon Gen(Collection<novemberizing.ds.tuple.Pair<Integer,String>> events){
        return new innoticon.msg.Innoticon(events);
    }


    @Expose public HashMap<Integer, String> timeline = null;
    @Expose public int current = -1;

    public void current(int v){ current = v; }
    public int current(){ return current; }

    public HashMap<Integer, String> timeline(){ return timeline; }

    public void __push(novemberizing.ds.tuple.Pair<Integer,String> ev){
        if(ev!=null && ev.first!=null && ev.second!=null){
            if(timeline==null){
                timeline = new HashMap<>();
            }
            timeline.put(ev.first, ev.second);
        } else {
            Log.d(Tag, "ev==null || ev.first==null || ev.second==null");
        }
    }

    @SafeVarargs
    public final Innoticon push(novemberizing.ds.tuple.Pair<Integer, String> ev, novemberizing.ds.tuple.Pair<Integer, String>... events) {
        __push(ev);
        for(novemberizing.ds.tuple.Pair<Integer, String> event : events){
            __push(event);
        }
        return this;
    }

    public Innoticon push(novemberizing.ds.tuple.Pair<Integer, String>[] events) {
        for(novemberizing.ds.tuple.Pair<Integer, String> event : events){
            __push(event);
        }
        return this;
    }

    public Innoticon push(Collection<novemberizing.ds.tuple.Pair<Integer, String>> events) {
        for(novemberizing.ds.tuple.Pair<Integer, String> event : events){
            __push(event);
        }
        return this;
    }

    public Innoticon(){}

    @SafeVarargs
    public Innoticon(novemberizing.ds.tuple.Pair<Integer,String> ev, novemberizing.ds.tuple.Pair<Integer,String>... events){
        this.key = new innoticon.ds.Message.Key(getClass().getName());
        push(ev, events);
    }

    public Innoticon(novemberizing.ds.tuple.Pair<Integer,String>[] events){
        this.key = new innoticon.ds.Message.Key(getClass().getName());
        push(events);
    }

    public Innoticon(Collection<novemberizing.ds.tuple.Pair<Integer,String>> events){
        this.key = new innoticon.ds.Message.Key(getClass().getName());
        push(events);
    }
}
