package innoticon.client.req.user;

import com.google.gson.annotations.Expose;

import static innoticon.ds.Action.Type.USERMUTEREQ;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 12.
 */
public class Mute extends innoticon.ds.Req {
    public static Mute Gen(String uid){
        innoticon.Client client = innoticon.Client.Get();
        return new Mute(client.gen(), uid);
    }

    @Expose public String uid;
    public String uid(){ return uid; }

    public Mute(){}

    public Mute(long unique, String uid){
        innoticon.Client client = innoticon.Client.Get();
        /** generate client key */
        action = client.genAction(USERMUTEREQ, client.key(), innoticon.ds.Action.Key.Gen(unique));
        /** detail */
        this.uid = uid;
    }
}
