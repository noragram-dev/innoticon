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

    public static Accept Gen(String uid, innoticon.ds.Res res) {
        innoticon.Client client = innoticon.Client.Get();
        return new Accept(client.gen(), uid, res);
    }

    public static Accept Gen(String uid, innoticon.ds.Req req) {
        innoticon.Client client = innoticon.Client.Get();
        return new Accept(client.gen(), uid, req);
    }

    public static Accept Gen(String uid, innoticon.ds.Req req, String greeting) {
        innoticon.Client client = innoticon.Client.Get();
        return new Accept(client.gen(), uid, req, greeting);
    }

    @Expose public String uid;
    @Expose public innoticon.ds.User profile;
    @Expose public innoticon.ds.Res res;

    public String friend(){ return uid; }
    public innoticon.ds.User profile(){ return profile; }
    public innoticon.ds.Res res(){ return res; }

    public Accept() { this.uid = null; }

    public Accept(long unique, String uid, innoticon.ds.Res res) {
        innoticon.Client client = innoticon.Client.Get();

        /** generate client key */
        action = client.genAction(ACCEPTTOINVITEREQ, client.key(), innoticon.ds.Action.Key.Gen(unique));
        /** detail */
        this.uid = uid;
        this.profile = client.me();
        this.res = res;
    }

    public Accept(long unique, String uid, innoticon.ds.Req req) {
        innoticon.Client client = innoticon.Client.Get();

        /** generate client key */
        action = client.genAction(ACCEPTTOINVITEREQ, client.key(), innoticon.ds.Action.Key.Gen(unique));
        /** detail */
        this.uid = uid;
        this.profile = client.me();
        this.res = new innoticon.ds.Res(req.getClass(),
                req.action(),
                client.genResKey());
    }

    public Accept(long unique, String uid, innoticon.ds.Req req, String greeting) {
        innoticon.Client client = innoticon.Client.Get();

        /** generate client key */
        action = client.genAction(ACCEPTTOINVITEREQ, client.key(), innoticon.ds.Action.Key.Gen(unique));
        /** detail */
        this.uid = uid;
        this.profile = client.me();
        this.res = new innoticon.ds.Res(req.getClass(),
                greeting,
                req.action(),
                client.genResKey());
    }
}
