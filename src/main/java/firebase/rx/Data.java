package firebase.rx;

import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import novemberizing.rx.Req;
import novemberizing.util.Log;

import java.util.HashMap;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 9.
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class Data<T> extends novemberizing.rx.Observable<T> implements ValueEventListener {
    public static class Req {
        public static <T> novemberizing.rx.Req.Factory<T> Set(String path, T o, Class<T> c) {
            return new novemberizing.rx.Req.Factory<T>() {
                @Override
                public novemberizing.rx.Req<T> call() {
                    return new firebase.rx.Data<>(path, c, false).set(o);
                }
            };
        }

        public static <T> novemberizing.rx.Req.Factory<T> Set(String path, T o, GenericTypeIndicator<T> indicator) {
            return new novemberizing.rx.Req.Factory<T>() {
                @Override
                public novemberizing.rx.Req<T> call() {
                    return new firebase.rx.Data<>(path, indicator, false).set(o);
                }
            };
        }

        public static <T> novemberizing.rx.Req.Factory<HashMap<String, T>> Bulk(String path, HashMap<String, T> map, GenericTypeIndicator<HashMap<String, T>> indicator){
            return new novemberizing.rx.Req.Factory<HashMap<String, T>>() {

                @Override
                public novemberizing.rx.Req<HashMap<String, T>> call() {
                    return firebase.rx.Data.Bulk(path, map, indicator);
                }
            };
        }
    }
    public static <T> novemberizing.rx.Req<HashMap<String, T>> Bulk(String path, HashMap<String, T> map, GenericTypeIndicator<HashMap<String, T>> indicator){
        return new firebase.rx.Data<>(path, indicator, false).set(map);
    }
    public static <T> novemberizing.rx.Req<T> Set(String path, T o, Class<T> c){ return new firebase.rx.Data<>(path, c, false).set(o); }
    public static <T> novemberizing.rx.Req<T> Set(String path, T o, GenericTypeIndicator<T> indicator){ return new firebase.rx.Data<>(path, indicator,false).set(o); }

    public static novemberizing.rx.Req Del(String path){ return new firebase.rx.Data(path).del(); }

    private static final String Tag = "firebase.rx.db>";

    protected DatabaseReference __reference;
    protected final String __path;
    protected final Class<T> __c;
    protected final GenericTypeIndicator<T> __indicator;
    protected final boolean __once;

    private Data(String path){
        __path = path;
        __c = null;
        __indicator = null;
        __once = true;
        on();

    }

    public Data(String path, Class<T> c){
        __path = path;
        __c = c;
        __indicator = null;
        __once = false;
        on();
    }

    public Data(String path, GenericTypeIndicator<T> indicator){
        __path = path;
        __c = null;
        __indicator = indicator;
        __once = false;
        on();
    }

    public Data(String path, Class<T> c, boolean on){
        __path = path;
        __c = c;
        __indicator = null;
        __once = false;
        if(on){
            on();
        }

    }

    public Data(String path, GenericTypeIndicator<T> indicator, boolean on){
        __path = path;
        __c = null;
        __indicator = indicator;
        __once = false;
        if(on){
            on();
        }
    }

    public Data(String path, Class<T> c, boolean on, boolean once){
        __path = path;
        __c = c;
        __indicator = null;
        __once = once;
        if(on){
            on();
        }

    }

    public Data(String path, GenericTypeIndicator<T> indicator, boolean on, boolean once){
        __path = path;
        __c = null;
        __indicator = indicator;
        __once = once;
        if(on){
            on();
        }
    }

    public Data<T> on(){
        if(__reference==null && __path!=null) {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            __reference = database.getReference(__path);
            __reference.addValueEventListener(this);
        }
        return this;
    }

    public Data<T> off(){
        if(__reference!=null){
            __reference.removeEventListener(this);
            __reference = null;
        }
        return this;
    }

    @Override
    public T get(){ return super.get(); }

    public novemberizing.rx.Req<T> del(){ return set(null); }

    protected T convert(DataSnapshot snapshot) throws Exception {
        if (__indicator != null) {
            return snapshot.getValue(__indicator);
        } else if (__c != null) {
            return snapshot.getValue(__c);
        } else {
            return null;
        }
    }

    public novemberizing.rx.Req<T> set(T o){
        if(__reference==null){
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            __reference = database.getReference(__path);
        }
        return req(novemberizing.rx.Operator.Req(o, (value, res) -> __reference.setValue(value, (e, reference) -> {
            if (e != null) {
                if(__once){
                    off();
                }
                res.error(e.toException());
            } else {
                if(__once){
                    off();
                }
                res.complete();
            }
        })));
    }

    @Override
    public void onDataChange(DataSnapshot snapshot) {
        Log.d(Tag, this);
        try {
            emit(convert(snapshot));
            if(__once){
                off();
            }
        } catch(Exception e){
            error(e);
        }
    }

    @Override
    public void onCancelled(DatabaseError error) {
        Log.e(Tag, this);
        error(error.toException());
        if(__once){
            off();
        }
    }
}
