package innoticon.client.req.telegram.user;

import com.google.gson.annotations.Expose;

import static innoticon.ds.Action.Type.TELEGRAM_USER_ADD_REQ;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 3. 4.
 */
@SuppressWarnings({"DanglingJavadoc", "unused", "WeakerAccess"})
public class Add extends innoticon.ds.Req {

    public static String Json(telegram.ds.User user){ return innoticon.Client.Json(Gen(user)); }

    public static Add Gen(telegram.ds.User user){ return new Add(user); }

    @Expose public telegram.ds.User user;

    public Add(){}

    public Add(telegram.ds.User user){
        innoticon.Client client = innoticon.Client.Get();

        /** generate client key */
        action = client.genAction(TELEGRAM_USER_ADD_REQ, client.key(), innoticon.ds.Action.Key.Gen(client.gen()));
        /** detail */
        this.user = user;
    }
}
