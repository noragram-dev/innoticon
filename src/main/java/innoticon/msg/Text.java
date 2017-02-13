package innoticon.msg;

import com.google.gson.annotations.Expose;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 12.
 */
public class Text extends innoticon.msg.Abstract {
    @Expose public String str = null;

    public String str(){ return str; }
    public void str(String v){ this.str = v; }

    public Text(){}

}
