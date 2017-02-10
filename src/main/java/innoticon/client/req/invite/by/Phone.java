package innoticon.client.req.invite.by;

import com.google.gson.annotations.Expose;

import static innoticon.ds.Action.Type.INVITEBYPHONEREQ;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 7.
 */
@SuppressWarnings({"DanglingJavadoc", "WeakerAccess", "unused"})
public class Phone extends innoticon.ds.Req {
    public static Phone Gen(String phone){
        innoticon.Client client = innoticon.Client.Get();
        return new Phone(client.gen(), phone);
    }

    @Expose public String phone;

    public String phone(){ return phone; }
    public String v(){ return phone; }

    public Phone(long unique, String phone){
        innoticon.Client client = innoticon.Client.Get();
        /** action */
        action = client.genAction(INVITEBYPHONEREQ, client.key(), innoticon.ds.Action.Key.Gen(unique));

        /** detail */
        this.phone = phone;
    }
}
