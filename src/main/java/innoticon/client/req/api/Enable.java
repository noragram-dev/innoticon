package innoticon.client.req.api;

import com.google.gson.annotations.Expose;

import static innoticon.ds.Action.Type.ENABLEAPI;

/**
 * Enable API.
 */
public class Enable extends innoticon.ds.Req {

    public enum Type {
        CALENDAR, WEATHER
    }
    @Expose
    public Type type;
    @Expose
    public String refreshToken;

    public String getTypeName(){ return type.name(); }
    public String getRefreshToken(){ return refreshToken; }

    public static Enable Gen(String type, String refreshToken){
        innoticon.Client client = innoticon.Client.Get();
        return new Enable(client.gen(), type, refreshToken);
    }

    public Enable(long unique, String type, String refreshToken){
        innoticon.Client client = innoticon.Client.Get();
        /** set action */
        action = client.genAction(ENABLEAPI, client.key(), innoticon.ds.Action.Key.Gen(unique));

        /** detail */
        this.type = Type.valueOf(type);
        this.refreshToken = refreshToken;
    }
}
