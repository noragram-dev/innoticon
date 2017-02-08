package messenger.ds;

import com.google.gson.annotations.Expose;

/**
 * messenger's unique user object
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 7.
 */
@SuppressWarnings({"WeakerAccess", "unused", "DanglingJavadoc"})
public class User extends innoticon.ds.Json {
    @Expose public String email;                /** email, unique */
    @Expose public String name;                 /** name */
    @Expose public String phone;                /** phone */

    public String email(){ return email; }      /** get email */
    public String name(){ return  name; }       /** get name */
    public String phone(){ return phone; }      /** get phone */

    public void email(String v){ email = v; }   /** set email */
    public void name(String v){ name = v; }     /** set nmee */
    public void phone(String v){ phone = v; }   /** set phone */

    /** default constructor */
    public User(){
        this.email = null;
        this.name = null;
        this.phone = null;
    }

    /**
     * constructor
     * @param email | string | email |
     * @param name  | string | name |
     * @param phone | string | phone |
     */
    public User(String email, String name, String phone){
        this.email = email;
        this.name = name;
        this.phone = phone;
    }
}
