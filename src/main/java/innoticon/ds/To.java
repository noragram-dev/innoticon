package innoticon.ds;

import com.google.gson.annotations.Expose;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 12.
 */
public class To implements innoticon.ds.Addr {
    /**
     * maybe useless, just we use path,...
     */
    public enum Type {
        Dialog,
        User,
        DialogUser,
    }

    @Expose public To.Type type = null;
    @Expose public innoticon.ds.User user = null;

    public String key(){
        String key = null;
        if(type!=null){
            if(user!=null && user.uid!=null){
                key = type.name().toLowerCase() + "/" + user.uid();
            }
        }
        return key;
    }

    public To.Type type(){ return type; }
    public void type(To.Type v){ type = v; }

    public innoticon.ds.User user(){ return user; }
    public void user(innoticon.ds.User v){ user = v; }

    public String id(){ return user!=null ? user.uid() : null; }

    public To(){

    }
}
