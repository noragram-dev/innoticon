package innoticon.ds;

import com.google.gson.annotations.Expose;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 7.
 */
@SuppressWarnings({"DanglingJavadoc", "WeakerAccess", "unused"})
public class User extends messenger.ds.User {
    @Expose public String uid;              /** user id issued by firebase */

    public String uid(){ return uid; }      /** get uid */
    public void uid(String v){ uid = v; }   /** set uid */

    public User(){
        super();
        this.uid = null;
    }

    public User(String email, String name, String phone, String uid){
        super(email, name, phone);
        this.uid = uid;
    }
}
