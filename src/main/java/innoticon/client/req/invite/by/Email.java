package innoticon.client.req.invite.by;

import com.google.gson.annotations.Expose;

import static innoticon.ds.Action.Type.INVITEBYEMAILREQ;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 7.
 */
@SuppressWarnings({"DanglingJavadoc", "WeakerAccess", "unused"})
public class Email extends innoticon.client.req.invite.Invite {
    public static Email Gen(String email){
        innoticon.Client client = innoticon.Client.Get();
        return new Email(client.gen(), email);
    }

    public static String Json(String email){
        innoticon.Client client = innoticon.Client.Get();
        return client.toJson(Gen(email));
    }

    @Expose public String email;


    public String email(){ return email; }

    public String v(){ return email; }

    public Email(){}

    public Email(long unique, String email){
        innoticon.Client client = innoticon.Client.Get();
        /** action */
        action = client.genAction(INVITEBYEMAILREQ, client.key(), innoticon.ds.Action.Key.Gen(unique));

        /** detail */
        this.from = new innoticon.ds.User(client.me());
        this.from.uid = null;
        this.email = email;
    }
}
