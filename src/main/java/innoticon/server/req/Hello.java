package innoticon.server.req;

import com.google.gson.annotations.Expose;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 7.
 */
@SuppressWarnings({"DanglingJavadoc", "WeakerAccess", "unused"})
public class Hello extends innoticon.ds.Req {

    @Expose public String device;
    @Expose public String app;
    @Expose public innoticon.ds.User user;
    @Expose public innoticon.ds.Client.Key key;

    public String device(){ return device; }
    public String app(){ return app; }
    public innoticon.ds.User user(){ return user; }
    public innoticon.ds.Client.Key key(){ return key; }

    public Hello(){
        this.device = null;
        this.app = null;
        this.user = null;
        this.key = null;
    }
}
