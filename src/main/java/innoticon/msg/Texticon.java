package innoticon.msg;

import com.google.gson.annotations.Expose;

/**
 *
 * @author novemberizing <me@novemberizing.net>
 * @since 2017. 4. 7.
 */
public class Texticon extends innoticon.msg.Text {

    public static innoticon.msg.Texticon Gen(String str, String image){
        return new innoticon.msg.Texticon(str, image);
    }

    @Expose public String image = null;


    public String image(){ return image; }
    public void image(String v){ image = v; }

    public Texticon(){}

    public Texticon(String str, String image){
        this.key = new innoticon.ds.Message.Key(getClass().getName());
        this.str = str;
        this.image = image;
    }
}
