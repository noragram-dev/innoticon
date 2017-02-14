package firebase.db;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import novemberizing.ds.tuple.Pair;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 14.
 */
public class Set<T> extends novemberizing.rx.Operator<novemberizing.ds.tuple.Pair<String,T>, Boolean> {

    @Override
    protected void on(Task<Pair<String, T>, Boolean> req, Pair<String, T> in) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference(in.first);
        reference.setValue(in.second, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError error, DatabaseReference reference) {
                if(error!=null){
                    req.error(error.toException());
                    req.next(false);
                } else {
                    req.next(true);
                }
                req.complete();
            }
        });
    }
}
