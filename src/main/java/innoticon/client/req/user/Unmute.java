package innoticon.client.req.user;

import com.google.gson.annotations.Expose;

import static innoticon.ds.Action.Type.USERUNMUTEREQ;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 12.
 */
public class Unmute extends innoticon.ds.Req {
    public static Unmute Gen(String uid){
        innoticon.Client client = innoticon.Client.Get();
        return new Unmute(client.gen(), uid);
    }
    public static String Json(String uid){
        innoticon.Client client = innoticon.Client.Get();
        return client.toJson(Gen(uid));
    }
    @Expose public String uid;
    public String uid(){ return uid; }

    public Unmute(){}

    public Unmute(long unique, String uid){
        innoticon.Client client = innoticon.Client.Get();
        /** generate client key */
        action = client.genAction(USERUNMUTEREQ, client.key(), innoticon.ds.Action.Key.Gen(unique));
        /** detail */
        this.uid = uid;

    }
}
