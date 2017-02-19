package innoticon.to;

import com.google.gson.annotations.Expose;
import innoticon.ds.From;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 12.
 */
@SuppressWarnings("WeakerAccess")
public class User extends innoticon.ds.To {
    public static innoticon.to.User Gen(innoticon.ds.User user){
        return new innoticon.to.User(user);
    }

    public static innoticon.to.User Gen(innoticon.ds.Friend friend){
        return friend!=null ? Gen(friend.profile()) : null;
    }

    @Expose public innoticon.ds.User profile = null;

    public User(){
        this.type = Type.User;
    }

    public User(innoticon.ds.User profile){
        this.type = Type.User;
        this.profile = profile;
    }


    @Override
    public String key() { return type!=null && profile!=null ? type.name() + ":" + profile.uid() : null; }

    @Override
    public String id() {
        return this.profile!=null ? this.profile.uid() : null;
    }
}
