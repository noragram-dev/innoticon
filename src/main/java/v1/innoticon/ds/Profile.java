package v1.innoticon.ds;

import com.google.gson.annotations.Expose;
import novemberizing.util.Log;

import java.util.HashMap;

/**
 * User's Profile Table
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 24.
 */
@SuppressWarnings({"unused", "WeakerAccess", "DanglingJavadoc"})
public class Profile {
    private static final String Tag = "v1/innoticon/ds/profile>";

    @Expose public v1.innoticon.ds.User user = null;                /** | innoticon.ds.User | user information | unique | */
    @Expose public String name = null;                              /** | string | nick | */
    @Expose public String phone = null;                             /** | string | phone | */
    @Expose public String description = null;                       /** | string | description | */
    @Expose public v1.innoticon.ds.Image photo = null;              /** | innoticon.ds.Image | photo image | */
    @Expose public v1.innoticon.ds.Image background = null;         /** | innoticon.ds.Image | background | */
    @Expose public HashMap<String, v1.innoticon.ds.Json> additional = null;     /** | hash map | additional json information | */

    /** todo how to add additional information. background music, and etc. */

    public String uid(){ return user!=null ? user.uid : null; }
    public String email(){ return user!=null ? user.email : null; }
    public String shorten(){ return user!=null ? user.shorten : null; }

    public Profile add(String key, v1.innoticon.ds.Json value){
        if(key!=null){
            v1.innoticon.ds.Json old = additional.put(key, value);
            Log.d(Tag, old, "removed old value");
        } else {
            Log.w(Tag, "key==null");
        }
        return this;
    }

    public <T> Profile add(String key, String value, Class<T> c){
        if(key!=null && value!=null && c!=null){
            /** todo implement this */
            // v1.innoticon.ds.Json old = additional.put(key, value);
            // Log.d(Tag, old, "removed old value");
        } else {
            Log.w(Tag, "key==null || value==null || c==null");
        }
        return this;
    }

    public Profile uid(String v){
        if(user!=null){
            user.uid(v);
        }
        return this;
    }
    public Profile email(String v){
        if(user!=null) {
            user.email = v;
        }
        return this;
    }
    public Profile shorten(String v){
        if(user!=null){
            user.shorten = v;
        }
        return this;
    }

    public Profile name(String v){
        name = v;
        return this;
    }

    public Profile phone(String v){
        phone = v;                                                  /** todo: validate phone number */
        return this;
    }

    public Profile description(String v){
        description = v;
        return this;
    }

    public Profile photo(v1.innoticon.ds.Image v){
        photo = v;
        return this;
    }

    public Profile background(v1.innoticon.ds.Image v){
        background = v;
        return this;
    }

    public Profile(){}

    public Profile(v1.innoticon.ds.User user){
        this.user = user;
    }
}
