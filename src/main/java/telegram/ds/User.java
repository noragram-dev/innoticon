package telegram.ds;

import com.google.gson.annotations.Expose;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 3. 3.
 */

@SuppressWarnings({"WeakerAccess", "unused"})
public class User {
    @Expose public innoticon.ds.Name name = null;
    @Expose public String nick = null;
    @Expose public String phone = null;
    @Expose public int id = 0;
    @Expose public long update = 0;
    @Expose public long access = 0;


    public innoticon.ds.Name name(){ return name; }
    public String nick(){ return nick; }
    public String phone(){ return phone; }
    public int id(){ return id; }
    public long update(){ return update; }
    public long access(){ return access; }

    public void name(innoticon.ds.Name v){ name = v; }
    public void name(String first, String last){
        if (name != null) {
            name.first(first);
            name.last(last);
        } else {
            name = new innoticon.ds.Name(first, last);
        }
    }

    public void nick(String v){ nick = v; }
    public void phone(String v){ phone = v; }
    public void id(int v){ id = v; }
    public void update(long v){ update = v; }
    public void access(long v){ access = v; }

    public User(){}

    public User(innoticon.ds.Name name, String nick, String phone, int id, long update, long access){
        this.name = name;
        this.nick = nick;
        this.phone = phone;
        this.id = id;
        this.update = update;
        this.access = access;
    }
}
