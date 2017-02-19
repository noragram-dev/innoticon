package innoticon.to;

import com.google.gson.annotations.Expose;
import innoticon.ds.From;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 12.
 */
public class DialogUser extends innoticon.ds.To {
    @Expose public innoticon.ds.User profile = null;


    @Override
    public String key() {
        return null;
    }

    @Override
    public String id() {
        return profile!=null ? profile.uid() : null;
    }
}
