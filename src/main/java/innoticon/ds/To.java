package innoticon.ds;

import com.google.gson.annotations.Expose;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 12.
 */
public class To implements innoticon.ds.Addr {

    public static innoticon.ds.To Gen(innoticon.ds.Friend friend){
        return friend!=null ? new innoticon.ds.To(friend.profile) : null;
    }
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

    public To(innoticon.ds.User user){
        this.type = Type.User;
        this.user = user;
    }
}
