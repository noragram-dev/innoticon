package innoticon.req.dialog;

import com.google.gson.annotations.Expose;

import java.util.HashMap;
import java.util.Collection;

import static innoticon.ds.Action.Type.DIALOG_INVITE_REQ;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 12.
 */
public class Invite extends innoticon.req.Dialog {

    public static innoticon.req.dialog.Invite Gen(innoticon.req.Dialog.Key key,innoticon.req.Dialog.Info info){
        return new Invite(innoticon.Client.Gen(), key, info);
    }

    @Expose public HashMap<String,innoticon.ds.User> users;
    @Expose public innoticon.req.Dialog.Info info;

    public innoticon.req.Dialog.Info info(){ return info; }
    public Collection<innoticon.ds.User> users(){ return users!=null ? users.values() : null; }

    public Invite add(innoticon.ds.User user){
        if(user!=null){
            if(users==null){
                users = new HashMap<>();
            }
            users.put(user.uid(),user);
        }
        return this;
    }

    public Invite add(String uid){
        if(uid!=null){
            innoticon.ds.User user = new innoticon.ds.User();
            user.uid(uid);
            add(user);
        }
        return this;
    }

    public Invite(){
        info = null;
        users = null;
    }

    public Invite(long unique,innoticon.req.Dialog.Key key,innoticon.req.Dialog.Info info){
        super(unique, DIALOG_INVITE_REQ);

        /** dialog key generate by server */

        /** set detail */
        this.key = key;
        this.info = info;
    }
}
