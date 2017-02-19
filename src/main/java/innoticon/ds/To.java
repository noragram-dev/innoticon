package innoticon.ds;

import com.google.gson.annotations.Expose;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 12.
 */
public abstract class To implements innoticon.ds.Addr {
    /**
     * maybe useless, just we use path,...
     */
    public enum Type {
        Dialog,
        User,
        DialogUser,
    }

    @Expose public To.Type type = null;
    public To.Type type(){ return type; }

    public abstract String key();
    public abstract String id();
}
