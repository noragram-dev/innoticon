package innoticon.msg;

import com.google.gson.annotations.Expose;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 3. 2.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Location extends innoticon.msg.Text {

    public static innoticon.msg.Text Gen(String str, String image,int latitude,int longitude){
        return new innoticon.msg.Location(str, image, latitude, longitude);
    }

    @Expose public String image = null;
    @Expose public int latitude = 0;
    @Expose public int longitude = 0;

    public String image(){ return image; }
    public void image(String v){ image = v; }

    public void latitude(int v){ latitude = v; }
    public int latitude(){ return latitude; }

    public void longitude(int v){ longitude = v; }
    public int longitude(){ return longitude; }

    public Location(){}

    public Location(String str, String image,int latitude,int longitude){
        this.key = new innoticon.ds.Message.Key(getClass().getName());
        this.str = str;
        this.image = image;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
