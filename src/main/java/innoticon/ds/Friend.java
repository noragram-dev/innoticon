package innoticon.ds;

import com.google.gson.annotations.Expose;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 13.
 */
public class Friend extends innoticon.ds.Json {
    @Expose public long update = 0;
    @Expose public innoticon.ds.User profile = null;

    public long update(){ return update; }
    public innoticon.ds.User profile(){ return profile; }

    public Friend(){}
}
