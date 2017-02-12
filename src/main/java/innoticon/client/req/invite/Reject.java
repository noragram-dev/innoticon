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

    public static Reject Gen(String uid, innoticon.ds.Req req) {
        innoticon.Client client = innoticon.Client.Get();
        return new Reject(client.gen(), uid, req);
    }

    public static Reject Gen(String uid, innoticon.ds.Req req, String greeting) {
        innoticon.Client client = innoticon.Client.Get();
        return new Reject(client.gen(), uid, req, greeting);
    }

    @Expose public String uid;
    @Expose public innoticon.ds.Res res;

    public innoticon.ds.Res res(){ return res; }
    public String friend(){ return uid; }

    public Reject() { this.uid = null; }

    public Reject(long unique, String uid, innoticon.ds.Res res) {
        innoticon.Client client = innoticon.Client.Get();

        /** generate client key */
        action = client.genAction(REJECTTOINVITEREQ, client.key(), innoticon.ds.Action.Key.Gen(unique));
        /** detail */
        this.uid = uid;
        this.res = res;
    }

    public Reject(long unique, String uid, innoticon.ds.Req req) {
        innoticon.Client client = innoticon.Client.Get();

        /** generate client key */
        action = client.genAction(REJECTTOINVITEREQ, client.key(), innoticon.ds.Action.Key.Gen(unique));
        /** detail */
        this.uid = uid;
        this.res = new innoticon.ds.Res(req.getClass(),req.action(),client.genResKey());
    }

    public Reject(long unique, String uid, innoticon.ds.Req req, String sorry) {
        innoticon.Client client = innoticon.Client.Get();

        /** generate client key */
        action = client.genAction(REJECTTOINVITEREQ, client.key(), innoticon.ds.Action.Key.Gen(unique));
        /** detail */
        this.uid = uid;
        this.res = new innoticon.ds.Res(req.getClass(), sorry, req.action(),client.genResKey());
    }
}
