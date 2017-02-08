package innoticon.client.req.invite;

import com.google.gson.annotations.Expose;

import static innoticon.ds.Action.Type.REJECTTOINVITEREQ;


/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 6.
 */
@SuppressWarnings({"DanglingJavadoc", "WeakerAccess", "unused"})
public class Reject extends innoticon.ds.Req {

    public static Reject Gen(String uid) {
        innoticon.Client client = innoticon.Client.Get();
        return new Reject(client.gen(), uid);
    }

    @Expose public String uid;

    public String v() { return uid; }

    public String friend(){ return uid; }

    public Reject() { this.uid = null; }

    public Reject(long unique, String uid) {
        innoticon.Client client = innoticon.Client.Get();

        /** generate client key */
        action = client.genAction(REJECTTOINVITEREQ, client.key(), innoticon.ds.Action.Key.Gen(unique));
        /** detail */
        this.uid = uid;
    }
}
