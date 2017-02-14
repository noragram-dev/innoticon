package firebase.db;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 14.
 */
public class Del extends novemberizing.rx.Operator<String, Boolean> {

    @Override
    protected void on(Task<String, Boolean> req, String in) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference(in);
        reference.setValue(null, new DatabaseReference.CompletionListener() {
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
