package innoticon.req.dialog;

import com.google.gson.annotations.Expose;
import innoticon.req.Dialog;

import static innoticon.ds.Action.Type.DIALOG_JOIN_REQ;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 12.
 */
public class Join extends Dialog {
    @Expose public innoticon.ds.User user;
    @Expose public String password;

    public Join(){
        this.user = null;
        this.password = null;
    }

    public Join(long unique) {
        super(unique, DIALOG_JOIN_REQ);
        innoticon.Client client = innoticon.Client.Get();
        this.user = client.me();
        this.password = null;
    }

    public Join(long unique, String password) {
        super(unique, DIALOG_JOIN_REQ);
        /** no detail information */
        innoticon.Client client = innoticon.Client.Get();
        this.user = client.me();
        this.password = password;

    }
}
