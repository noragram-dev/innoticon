package innoticon.client.req.invite;

import com.google.gson.annotations.Expose;

import static innoticon.ds.Action.Type.ACCEPTTOINVITEREQ;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 6.
 */
@SuppressWarnings({"DanglingJavadoc", "WeakerAccess", "unused"})
public class Accept extends innoticon.ds.Req {

    public static Accept Gen(String uid) {
        innoticon.Client client = innoticon.Client.Get();
        return new Accept(client.gen(), uid);
    }

    @Expose public String uid;

    public String v() { return uid; }

    public String friend(){ return uid; }

    public Accept() { this.uid = null; }

    public Accept(long unique, String uid) {
        innoticon.Client client = innoticon.Client.Get();

        /** generate client key */
        action = client.genAction(ACCEPTTOINVITEREQ, client.key(), innoticon.ds.Action.Key.Gen(unique));
        /** detail */
        this.uid = uid;
    }
}
