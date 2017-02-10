package innoticon.server.res;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 10.
 */
public class Hello extends innoticon.ds.Res {
    public Hello(innoticon.ds.Action action){
        this.action = action;
        this.api = "innoticon.server.req.Hello";
    }
}
