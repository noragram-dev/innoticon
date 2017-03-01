package innoticon.msg;

import com.google.gson.annotations.Expose;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 3. 2.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Location extends innoticon.msg.Text {

    public static innoticon.msg.Text Gen(String str, String image){
        return new innoticon.msg.Location(str, image);
    }

    @Expose public String image = null;

    public String image(){ return image; }
    public void image(String v){ image = v; }

    public Location(){}

    public Location(String str, String image){
        this.key = new innoticon.ds.Message.Key(getClass().getName());
        this.str = str;
        this.image = image;
    }
}
