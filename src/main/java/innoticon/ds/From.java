package innoticon.ds;

import com.google.gson.annotations.Expose;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 12.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class From implements innoticon.ds.Addr {
    @Expose public innoticon.ds.Client.Key key = null;
    @Expose public innoticon.ds.User user = null;

    public innoticon.ds.Client.Key client(){ return key; }
    public innoticon.ds.User user(){ return user; }

    public void client(innoticon.ds.Client.Key v){ this.key = v; }
    public void user(innoticon.ds.User v){ this.user = v; }

    public From(){}

    public From(innoticon.Client client){
        this.key = client.key();
        this.user = client.me();
    }

}
