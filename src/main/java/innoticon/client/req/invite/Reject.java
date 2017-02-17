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

    public static Reject Gen(String uid, innoticon.client.req.invite.Invite invite) {
        innoticon.Client client = innoticon.Client.Get();
        return new Reject(client.gen(), uid, invite);
    }

    public static Reject Gen(String uid, innoticon.client.req.invite.Invite invite, String greeting) {
        innoticon.Client client = innoticon.Client.Get();
        return new Reject(client.gen(), uid, invite, greeting);
    }

    public static String Json(String uid, innoticon.client.req.invite.Invite invite) {
        innoticon.Client client = innoticon.Client.Get();
        return client.toJson(Gen(uid, invite));
    }

    public static String Json(String uid, innoticon.client.req.invite.Invite invite, String greeting) {
        innoticon.Client client = innoticon.Client.Get();
        return client.toJson(Gen(uid, invite, greeting));
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

    public Reject(long unique, String uid, innoticon.client.req.invite.Invite invite) {
        innoticon.Client client = innoticon.Client.Get();

        /** generate client key */
        action = client.genAction(REJECTTOINVITEREQ, client.key(), innoticon.ds.Action.Key.Gen(unique));
        /** detail */
        this.uid = uid;
        this.res = new innoticon.ds.Res(invite.getClass(),invite.action(),client.genResKey());
    }

    public Reject(long unique, String uid, innoticon.client.req.invite.Invite invite, String sorry) {
        innoticon.Client client = innoticon.Client.Get();

        /** generate client key */
        action = client.genAction(REJECTTOINVITEREQ, client.key(), innoticon.ds.Action.Key.Gen(unique));
        /** detail */
        this.uid = uid;
        this.res = new innoticon.ds.Res(invite.getClass(), sorry, invite.action(),client.genResKey());
    }
}
