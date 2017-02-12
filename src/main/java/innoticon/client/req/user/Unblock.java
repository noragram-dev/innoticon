package innoticon.client.req.user;

import com.google.gson.annotations.Expose;

import static innoticon.ds.Action.Type.USERUNBLOCK;

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
    @Expose public String uid;
    public String uid(){ return uid; }

    public Unblock(){}

    public Unblock(long unique, String uid){
        innoticon.Client client = innoticon.Client.Get();
        /** generate client key */
        action = client.genAction(USERUNBLOCK, client.key(), innoticon.ds.Action.Key.Gen(unique));
        /** detail */
        this.uid = uid;
    }
}
