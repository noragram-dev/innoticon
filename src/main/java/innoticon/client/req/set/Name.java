package innoticon.client.req.set;

import com.google.gson.annotations.Expose;

import static innoticon.ds.Action.Type.SETPROFILENAMEREQ;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 7.
 */
@SuppressWarnings({"DanglingJavadoc", "WeakerAccess", "unused"})
public class Name extends innoticon.ds.Req {
    public static Name Gen(String name){
        innoticon.Client client = innoticon.Client.Get();
        return new Name(client.gen(), name);
    }

    public static String Json(String name){
        innoticon.Client client = innoticon.Client.Get();
        return client.toJson(new Name(client.gen(), name));
    }

    @Expose
    public String name;

    public String v(){ return name; }

    public Name(long unique, String name){
        innoticon.Client client = innoticon.Client.Get();
        /** set action */
        action = client.genAction(SETPROFILENAMEREQ, client.key(), innoticon.ds.Action.Key.Gen(unique));

        /** detail */
        this.name = name;
    }
}
