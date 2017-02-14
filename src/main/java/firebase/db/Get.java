package firebase.db;


import com.google.firebase.database.*;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 14.
 */
public class Get<T> extends novemberizing.rx.Operator<novemberizing.ds.tuple.Pair<String, firebase.db.Deserializer<T>>, T> {
    @Override
    protected void on(Task<novemberizing.ds.tuple.Pair<String, firebase.db.Deserializer<T>>, T> task, novemberizing.ds.tuple.Pair<String, firebase.db.Deserializer<T>> in) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference(in.first);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                try {
                    task.next(in.second.deserialize(snapshot));
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
