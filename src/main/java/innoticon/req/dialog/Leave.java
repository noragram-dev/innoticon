package innoticon.req.dialog;

import innoticon.req.Dialog;

import static innoticon.ds.Action.Type.DIALOG_LEAVE_REQ;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 12.
 */
public class Leave extends Dialog {
    public static Leave Gen(innoticon.req.Dialog.Key key){
        return new Leave(innoticon.Client.Gen(), key);
    }

    public Leave(){

    }
    public Leave(long unique, innoticon.req.Dialog.Key key){
        innoticon.Client client = innoticon.Client.Get();
        this.action = client.genAction(DIALOG_LEAVE_REQ, client.key(), innoticon.ds.Action.Key.Gen(unique));
        /** no detail information */
        this.key = key;
    }
}
