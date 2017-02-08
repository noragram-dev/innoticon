package innoticon.client.req.add;

import com.google.gson.annotations.Expose;

import static innoticon.ds.Action.Type.ADDEMAILREQ;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 7.
 */
@SuppressWarnings({"DanglingJavadoc", "WeakerAccess", "unused"})
public class Email extends innoticon.ds.Req {
    public static Email Gen(String email){
        innoticon.Client client = innoticon.Client.Get();
        return new Email(client.gen(), email);
    }

    @Expose public String email;

    public String v(){ return email; }

    public Email(long unique, String email){
        innoticon.Client client = innoticon.Client.Get();
        /** action */
        action = client.genAction(ADDEMAILREQ, client.key(), innoticon.ds.Action.Key.Gen(unique));

        /** detail */
        this.email = email;
    }
}
