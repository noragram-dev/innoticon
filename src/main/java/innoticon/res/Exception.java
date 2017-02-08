package innoticon.res;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 7.
 */
public class Exception extends innoticon.ds.Res {
    public static innoticon.res.Exception Gen(String api, String msg){
        return new innoticon.res.Exception(api, msg);
    }
    public Exception(){

    }

    public Exception(String api, String msg){
        this.api = api;
        this.error = msg;
    }
}
