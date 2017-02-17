package innoticon.to;

import com.google.gson.annotations.Expose;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 12.
 */
public class DialogUser extends innoticon.ds.To {
    @Expose public String uid;
    @Override
    public String key() {
        return null;
    }

    @Override
    public String id() {
        return uid;
    }
}
