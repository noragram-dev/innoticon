package innoticon.ds;

import com.google.gson.annotations.Expose;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 7.
 */
public class Res extends innoticon.ds.Json {
    @Expose public Action action;
    @Expose public String api;
    @Expose public String error;

    public Action action(){ return action; }
    public String api(){ return api; }
    public String error(){ return error; }

    public Res(){
        action = null;
        api = null;
        error = null;
    }

    public Res(String api,Action action){
        this.api = api;
        this.action = action;
    }
}
