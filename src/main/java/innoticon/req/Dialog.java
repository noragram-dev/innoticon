package innoticon.req;

import com.google.gson.annotations.Expose;

/**
 * because can be avail created dialog by system or server.
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 12.
 */
public class Dialog extends innoticon.ds.Req {
    public static class Key extends innoticon.key.Local {}

    @Expose public Dialog.Key key;

    public Dialog(){
        this.key = null;
    }

    public Dialog(long unique, int type) {
        super(unique, type);
    }
}
