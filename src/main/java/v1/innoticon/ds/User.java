package v1.innoticon.ds;

/**
 * static user information class.
 * not changeable, and user's unique information.
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 24.
 */
@SuppressWarnings({"DanglingJavadoc", "WeakerAccess", "unused"})
public class User {
    public String uid = "";             /** | string | user identity | unique | */
    public String email = "";           /** | string | user email address | unique | */
    public String shorten = "";         /** | string | user short identity, we will use @shorten | unique | */

    public String uid(){ return uid; }
    public String email(){ return email; }
    public String shorten(){ return shorten; }

    public void uid(String v){ uid = v; }
    public void email(String v){ email = v; }
    public void shorten(String v){ shorten = v; }

    public User(){}

    public User(String uid, String email, String shorten){
        this.uid = uid;
        this.email = email;
        this.shorten = shorten;
    }
}
