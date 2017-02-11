package innoticon.client.req.api;

import com.google.gson.annotations.Expose;
import innoticon.client.req.set.Phone;

import static innoticon.ds.Action.Type.ENABLEAPI;

/**
 * Enable API.
 */
public class Enable extends innoticon.ds.Req {

    public enum Type {
        CALENDAR,
    }
    @Expose
    public Type type;
    public String authToken;

    public String getTypeName(){ return type.name(); }
    public String getAuthToken(){ return authToken; }

    public static Enable Gen(Type type, String authToken){
        innoticon.Client client = innoticon.Client.Get();
        return new Enable(client.gen(), type, authToken);
    }

    public Enable(long unique, Type type, String authToken){
        innoticon.Client client = innoticon.Client.Get();
        /** set action */
        action = client.genAction(ENABLEAPI, client.key(), innoticon.ds.Action.Key.Gen(unique));

        /** detail */
        this.type = type;
        this.authToken = authToken;
    }
}
