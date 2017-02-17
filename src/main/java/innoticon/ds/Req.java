package innoticon.ds;

import com.google.gson.annotations.Expose;

import static innoticon.ds.Action.Type.DIALOG_LEAVE_REQ;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 7.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Req extends innoticon.ds.Json {

    @Expose public innoticon.ds.Action action;

    public innoticon.ds.Action action(){ return action; }

    public int type(){ return action!=null ? action.type() : 0; }

    public Req(){ action = null; }

    public Req(long unique, int type){
        innoticon.Client client = innoticon.Client.Get();
        this.action = client.genAction(type, client.key(), innoticon.ds.Action.Key.Gen(unique));
    }
}
