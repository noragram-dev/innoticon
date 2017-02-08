package innoticon.ds;

import com.google.gson.annotations.Expose;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 7.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Req extends innoticon.ds.Json {

    @Expose public innoticon.ds.Action action;

    public innoticon.ds.Action action(){ return action; }

    public String path(){ return ""; }

    public int type(){ return action!=null ? action.type() : 0; }

    public Req(){ action = null; }
}
