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
    @Expose public String photo;                /** photo */

    public String email(){ return email; }      /** get email */
    public String name(){ return  name; }       /** get name */
    public String phone(){ return phone; }      /** get phone */
    public String photo(){ return photo; }

    public String email(String v){ return email = v; }   /** set email */
    public String name(String v){ return name = v; }     /** set nmee */
    public String phone(String v){ return phone = v; }   /** set phone */
    public String photo(String v){ return photo = v; }

    /** default constructor */
    public User(){
        this.email = null;
        this.name = null;
        this.phone = null;
        this.photo = null;
    }

    /**
     * constructor
     * @param email | string | email |
     * @param name  | string | name |
     * @param phone | string | phone |
     */
    public User(String email, String name, String phone, String photo){
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.photo = photo;
    }
}
