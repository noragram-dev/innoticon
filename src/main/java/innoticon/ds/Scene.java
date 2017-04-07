package innoticon.ds;

import com.google.gson.annotations.Expose;

/**
 *
 * @author novemberizing <me@novemberizing.net>
 * @since 2017. 4. 7.
 */
public class Scene {
    public static Scene Gen(int second, String image){ return new Scene(second, image); }

    @Expose public Integer second;
    @Expose public String image;

    public Integer second(){ return second; }
    public String image(){ return image; }

    public void second(int v){ second = v; }
    public void image(String v){ image = v;}

    public Scene(){
        second = 0;
        image = "";
    }

    public Scene(int second, String image){
        this.second = second;
        this.image = image;
    }
}
