package firebase.db;


import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

/**
 * remove get's deserializer
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 14.
 */
@SuppressWarnings("WeakerAccess")
public class Get<T> extends novemberizing.rx.Operator<String, T> {
    protected GenericTypeIndicator<T> __indicator =  new GenericTypeIndicator<T>() {};

    @Override
    protected void on(Task<String, T> task, String in) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference(in);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                try {
                    task.next(snapshot.getValue(__indicator));
                } catch(Exception e){
                    task.error(e);
                } finally {
                    task.complete();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                task.error(error.toException());
                task.complete();
            }
        });
    }
}
