package innoticon.req.dialog;

import com.google.gson.annotations.Expose;
import innoticon.req.Dialog;

import java.util.Collection;
import java.util.HashMap;

import static innoticon.ds.Action.Type.DIALOG_CREATE_REQ;

/**
 * timestamp is exist in key,
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 12.
 */
public class Create extends Dialog {

    public static innoticon.req.dialog.Create Gen(String title, String password){
        innoticon.Client client = innoticon.Client.Get();
        return new Create(client.gen(), title, password);
    }

    public static innoticon.req.dialog.Create Gen(String title){
        innoticon.Client client = innoticon.Client.Get();
        return new Create(client.gen(), title);
    }

    @Expose public String title;
    @Expose public String password;         /** currently not support */
    @Expose public HashMap<String,innoticon.ds.User> users;

    public String title(){ return title; }
    public String password(){ return password; }
    public Collection<innoticon.ds.User> users(){ return users!=null ? users.values() : null; }

    public Create add(innoticon.ds.User user){
        if(user!=null){
            if(users==null){
                users = new HashMap<>();
            }
            users.put(user.uid(),user);
        }
        return this;
    }

    public Create add(String uid){
        if(uid!=null){
            innoticon.ds.User user = new innoticon.ds.User();
            user.uid(uid);
            add(user);
        }
        return this;
    }

    public Create(){
        title = null;
        password = null;
        users = null;
    }

    public Create(long unique,String title){
        innoticon.Client client = innoticon.Client.Get();

        /** generate client key */
        action = client.genAction(DIALOG_CREATE_REQ, client.key(), innoticon.ds.Action.Key.Gen(unique));

        /** dialog key generate by server */

        /** set detail */
        this.title = title;
        this.password = null;
    }

    public Create(long unique,String title, String password){
        innoticon.Client client = innoticon.Client.Get();

        /** generate client key */
        action = client.genAction(DIALOG_CREATE_REQ, client.key(), innoticon.ds.Action.Key.Gen(unique));

        /** dialog key generate by server */

        /** set detail */
        this.title = title;
        this.password = password;
    }
}
