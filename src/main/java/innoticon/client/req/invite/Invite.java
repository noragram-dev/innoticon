package innoticon.client.req.invite;

import com.google.gson.annotations.Expose;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 12.
 */
@SuppressWarnings("unused")
public abstract class Invite extends innoticon.ds.Req {

    @Expose public innoticon.ds.User from;


    public innoticon.ds.User from(){ return from; }
}
