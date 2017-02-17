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

    public static Accept Gen(String uid, innoticon.client.req.invite.Invite invite) {
        innoticon.Client client = innoticon.Client.Get();
        if(invite!=null) {
            return new Accept(client.gen(), uid, invite);
        } else {
            return null;
        }
    }

    public static String Json(String uid, innoticon.client.req.invite.Invite invite){
        innoticon.Client client = innoticon.Client.Get();
        return client.toJson(Gen(uid, invite));
    }

    public static Accept Gen(String uid, innoticon.client.req.invite.Invite invite, String greeting) {
        innoticon.Client client = innoticon.Client.Get();
        if (invite != null){
            return new Accept(client.gen(), uid, invite, greeting);
        } else {
            return null;
        }
    }

    public static String Json(String uid, innoticon.client.req.invite.Invite invite, String greeting){
        innoticon.Client client = innoticon.Client.Get();
        return client.toJson(Gen(uid, invite, greeting));
    }

    @Expose public innoticon.ds.User user = null;
    @Expose public innoticon.ds.Res res = null;
    @Expose public innoticon.ds.User friend = null;

    public innoticon.ds.User friend(){ return friend; }
    public innoticon.ds.User user(){ return user; }
    public innoticon.ds.Res res(){ return res; }

    public Accept() {}

    public Accept(long unique, String uid, innoticon.client.req.invite.Invite invite) {
        innoticon.Client client = innoticon.Client.Get();

        /** generate client key */
        action = client.genAction(ACCEPTTOINVITEREQ, client.key(), innoticon.ds.Action.Key.Gen(unique));
        /** detail */
        this.user = client.me();
        this.friend = invite.from();
        this.friend.uid = uid;
        this.res = new innoticon.ds.Res(invite.getClass(),
                invite.action(),
                client.genResKey());
    }

    public Accept(long unique, String uid, innoticon.client.req.invite.Invite invite, String greeting) {
        innoticon.Client client = innoticon.Client.Get();

        /** generate client key */
        action = client.genAction(ACCEPTTOINVITEREQ, client.key(), innoticon.ds.Action.Key.Gen(unique));
        /** detail */
        this.user = client.me();
        this.friend = invite.from();
        this.friend.uid = uid;
        this.res = new innoticon.ds.Res(invite.getClass(),
                greeting,
                invite.action(),
                client.genResKey());
    }
}
