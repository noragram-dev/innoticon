package firebase.rx;

import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import novemberizing.rx.Req;
import novemberizing.util.Log;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 9.
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class Data<T> extends novemberizing.rx.Observable<T> implements ValueEventListener {
    public static <T> novemberizing.rx.Req.Factory<T> Req(String path, T o, Class<T> c){
        return new novemberizing.rx.Req.Factory<T>(){
            @Override
            public Req<T> call() {
                return new firebase.rx.Data<>(path, c, false).set(o);
            }
        };
    }
    public static <T> novemberizing.rx.Req.Factory<T> Req(String path, T o, GenericTypeIndicator<T> indicator){
        return new novemberizing.rx.Req.Factory<T>(){
            @Override
            public Req<T> call() {
                return new firebase.rx.Data<>(path, indicator, false).set(o);
            }
        };
    }
    public static <T> novemberizing.rx.Req<T> Set(String path, T o, Class<T> c){ return new firebase.rx.Data<>(path, c).set(o); }
    public static <T> novemberizing.rx.Req<T> Set(String path, T o, GenericTypeIndicator<T> indicator){ return new firebase.rx.Data<>(path, indicator).set(o); }


    private static final String Tag = "firebase.rx.db>";

    protected DatabaseReference __reference;
    protected final String __path;
    protected final Class<T> __c;
    protected final GenericTypeIndicator<T> __indicator;
    protected final boolean __once;

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

    protected T convert(DataSnapshot snapshot) throws Exception {
        if(__indicator!=null) {
            return snapshot.getValue(__indicator);
        } else {
            return snapshot.getValue(__c);
        }
    }

    public novemberizing.rx.Req<T> set(T o){
        return req(novemberizing.rx.Operator.Req(o, (value, res) -> __reference.setValue(value, (e, reference) -> {
            if (e != null) {
                res.error(e.toException());
            } else {
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
