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

    public DialogUser(){
        this.type = Type.DialogUser;
    }

    public DialogUser(innoticon.ds.User profile){
        this.type = Type.User;
        this.profile = profile;
    }

    @Override
    public String key() {
        return null;
    }

    @Override
    public String id() {
        return profile!=null ? profile.uid() : null;
    }
}
