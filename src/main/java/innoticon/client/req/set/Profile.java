package innoticon.client.req.set;

import com.google.gson.annotations.Expose;

import static innoticon.ds.Action.Type.SETPROFILEREQ;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 10.
 */
@SuppressWarnings({"DanglingJavadoc", "WeakerAccess", "unused"})
public class Profile extends innoticon.ds.Req {
    public static Profile Gen(String name, String phone, String description){
        innoticon.Client client = innoticon.Client.Get();
        return new Profile(client.gen(), name, phone, description);
    }

    public static String Json(String name, String phone, String description){
        innoticon.Client client = innoticon.Client.Get();
        return client.toJson(Gen(name, phone, description));
    }

    @Expose public String name;
    @Expose public String phone;
    @Expose public String description;

    public String name(){ return name; }
    public String phone(){ return phone; }
    public String description(){ return description; }


    public Profile(long unique, String name, String phone, String description){
        innoticon.Client client = innoticon.Client.Get();
        /** set action */
        action = client.genAction(SETPROFILEREQ, client.key(), innoticon.ds.Action.Key.Gen(unique));

        /** detail */
        this.name = name;
        this.phone = phone;
        this.description = description;
    }
}
