package innoticon.client.req.user;

import com.google.gson.annotations.Expose;

import static innoticon.ds.Action.Type.USERUNBLOCKREQ;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 12.
 */
public class Unblock extends innoticon.ds.Req {
    public static Unblock Gen(String uid){
        innoticon.Client client = innoticon.Client.Get();
        return new Unblock(client.gen(), uid);
    }
    public static String Json(String uid){
        innoticon.Client client = innoticon.Client.Get();
        return client.toJson(Gen(uid));
    }
    @Expose public String uid;
    public String uid(){ return uid; }

    public Unblock(){}

    public Unblock(long unique, String uid){
        innoticon.Client client = innoticon.Client.Get();
        /** generate client key */
        action = client.genAction(USERUNBLOCKREQ, client.key(), innoticon.ds.Action.Key.Gen(unique));
        /** detail */
        this.uid = uid;
    }
}
