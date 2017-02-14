package firebase.db;

import com.google.firebase.database.DataSnapshot;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 14
 * Created by novem on 2017-02-14.
 */
public interface Deserializer<T> { T deserialize(DataSnapshot snapshot); }
