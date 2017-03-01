package innoticon.ds;

import com.google.gson.annotations.Expose;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 7.
 */
@SuppressWarnings({"DanglingJavadoc", "WeakerAccess", "unused"})
public class User extends messenger.ds.User {
    @Expose public String uid;                  /** user id issued by firebase */
    @Expose public String description;          /** description */

    public String uid(){ return uid; }          /** get uid */
    public void uid(String v){ uid = v; }       /** set uid */

    public String description(){ return description; }
    public void description(String v){ description = v; }

    public User(){
        super();
        this.uid = null;
    }

    public User(String email, String name, String phone, String photo, String uid){
        super(email, name, phone, photo);
        this.uid = uid;
    }

    public User(innoticon.ds.User u){
        super(u.email, u.name, u.phone, u.photo);
        this.uid = u.uid;
    }
}
