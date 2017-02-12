package innoticon.client.req.user;

import com.google.gson.annotations.Expose;

import static innoticon.ds.Action.Type.USERBLOCK;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 12.
 */
public class Block extends innoticon.ds.Req {
    public static Block Gen(String uid){
        innoticon.Client client = innoticon.Client.Get();
        return new Block(client.gen(), uid);
    }

    @Expose public String uid;
    public String uid(){ return uid; }

    public Block(){}

    public Block(long unique, String uid){
        innoticon.Client client = innoticon.Client.Get();

        /** generate client key */
        action = client.genAction(USERBLOCK, client.key(), innoticon.ds.Action.Key.Gen(unique));
        /** detail */
        this.uid = uid;
    }
}