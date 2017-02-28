package innoticon.ds;

import com.google.gson.annotations.Expose;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 28.
 */
public class Profile extends innoticon.ds.User {
    @Expose public String description = null;

    public String description(){ return description; }
    public void description(String v){ description = v; }

    public Profile(){}

    public Profile(String email, String name, String phone, String photo, String uid, String description){
        super(email, name, phone, photo, uid);
        this.description = description;
    }

    public Profile(innoticon.ds.User u, String description){
        super(u.email, u.name, u.phone, u.photo, u.uid);
        this.description = description;
    }

}
