package firebase.rx;


import com.google.firebase.database.*;
import novemberizing.rx.Observable;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 9,
 */
public class Map<T> extends Observable<novemberizing.ds.tuple.Triple<Integer, String, T>> implements ChildEventListener {
    public static final int INSERT = 1;
    public static final int UPDATE = 2;
    public static final int DELETE = 3;
    public static final int MOVE = 4;

    private DatabaseReference __reference;
    private final String __path;
    private final Class<T> __c;
    private final GenericTypeIndicator<T> __indicator;

    public Map(String path, Class<T> c){
        __path = path;
        __c = c;
        __indicator = null;
        on();
    }

    public Map(String path, GenericTypeIndicator<T> indicator){
        __path = path;
        __c = null;
        __indicator = indicator;
        on();
    }

    public Map<T> on(){
        if(__reference==null) {
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
            emit(new novemberizing.ds.tuple.Triple<>(INSERT, snapshot.getKey(), convert(snapshot)));
        } catch(Exception e){
            error(e);
        }
    }

    @Override
    public void onChildChanged(DataSnapshot snapshot, String s) {
        try {
            emit(new novemberizing.ds.tuple.Triple<>(UPDATE, snapshot.getKey(), convert(snapshot)));
        } catch(Exception e){
            error(e);
        }
    }

    @Override
    public void onChildRemoved(DataSnapshot snapshot) {
        try {
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

    @Override
    public void onCancelled(DatabaseError e) {
        error(e.toException());
    }
}
