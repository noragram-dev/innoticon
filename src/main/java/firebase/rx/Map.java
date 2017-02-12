package firebase.rx;


import com.google.firebase.database.*;
import novemberizing.rx.Observable;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 9,
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class Map<T> extends Observable<novemberizing.ds.tuple.Triple<Integer, String, T>> implements ChildEventListener, local.Map<String, T> {
    public static final int INSERT = 1;
    public static final int UPDATE = 2;
    public static final int DELETE = 3;
    public static final int MOVE = 4;

    protected DatabaseReference __reference;
    protected final String __path;
    protected final Class<T> __c;
    protected final GenericTypeIndicator<T> __indicator;
    protected local.Map<String, T> __map;

    public Map(String path, Class<T> c){
        __path = path;
        __c = c;
        __indicator = null;
        if(__path==null){ error(new Exception("__path is null")); }
        on();
    }

    public Map(String path, Class<T> c, local.Map<String, T> map){
        __path = path;
        __c = c;
        __indicator = null;
        __map = map;
        if(__path==null){ error(new Exception("__path is null")); }
        on();
    }

    public Map(String path, GenericTypeIndicator<T> indicator, local.Map<String, T> map){
        __path = path;
        __c = null;
        __indicator = indicator;
        __map = map;
        if(__path==null){ error(new Exception("__path is null")); }
        on();
    }

    public Map(String path, GenericTypeIndicator<T> indicator){
        __path = path;
        __c = null;
        __indicator = indicator;
        if(__path==null){ error(new Exception("__path is null")); }
        on();
    }

    public Map<T> set(local.Map<String, T> map){
        __map = map;
        return this;
    }



    public Map<T> on(){
        if(__reference==null && __path!=null) {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            __reference = database.getReference(__path);
            __reference.addChildEventListener(this);
        }
        return this;
    }

    public Map<T> off(){
        if(__reference!=null){
            __reference.removeEventListener(this);
            __reference = null;
        }
        return this;
    }

    private T convert(DataSnapshot snapshot) throws Exception {
        if(__indicator!=null) {
            return snapshot.getValue(__indicator);
        } else {
            return snapshot.getValue(__c);
        }
    }

    @Override
    public void onChildAdded(DataSnapshot snapshot, String s) {
        try {
            emit(new novemberizing.ds.tuple.Triple<>(INSERT, snapshot.getKey(), __map.set(snapshot.getKey(), convert(snapshot))));
        } catch(Exception e){
            error(e);
        }
    }

    @Override
    public void onChildChanged(DataSnapshot snapshot, String s) {
        try {
            emit(new novemberizing.ds.tuple.Triple<>(UPDATE, snapshot.getKey(), __map.set(snapshot.getKey(),convert(snapshot))));
        } catch(Exception e){
            error(e);
        }
    }

    @Override
    public void onChildRemoved(DataSnapshot snapshot) {
        try {
            __map.del(snapshot.getKey());
            emit(new novemberizing.ds.tuple.Triple<>(DELETE, snapshot.getKey(), convert(snapshot)));
        } catch(Exception e){
            error(e);
        }
    }

    @Override
    public void onChildMoved(DataSnapshot snapshot, String s) {
        try {
            emit(new novemberizing.ds.tuple.Triple<>(DELETE, snapshot.getKey(), convert(snapshot)));
        } catch(Exception e){
            error(e);
        }
    }

    @Override public void onCancelled(DatabaseError e) { error(e.toException()); }
    @Override public T get(String key) { return __map!=null ? __map.get(key) : null; }
    @Override public T set(String key, T value) { return __map!=null ? __map.set(key, value) : null; }
    @Override public T del(String key) { return __map!=null ? __map.del(key) : null; }
    @Override public int size() { return __map!=null ? __map.size() : 0; }
}
