package innoticon.server.req;

import com.google.gson.annotations.Expose;

import static innoticon.ds.Action.Type.HELLOREQ;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 7.
 */
@SuppressWarnings({"DanglingJavadoc", "WeakerAccess", "unused"})
public class Hello extends innoticon.ds.Req {
    public static Hello Gen(){
        innoticon.Client client = innoticon.Client.Get();
        return new Hello(client.gen());
    }

    @Expose public String device;
    @Expose public String app;
    @Expose public innoticon.ds.User user;

    public String device(){ return device; }
    public String app(){ return app; }
    public innoticon.ds.User user(){ return user; }

    public Hello(){
        this.device = null;
        this.app = null;
        this.user = null;
    }

    public Hello(long unique){
        innoticon.Client client = innoticon.Client.Get();
        /** action */
        action = client.genAction(HELLOREQ, client.key(), innoticon.ds.Action.Key.Gen(unique));

        /** detail */
        this.device = client.dev();
        this.app = client.app();
        this.user = client.me();
    }
}
