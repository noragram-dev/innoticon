package innoticon.ds;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import novemberizing.util.Log;

import java.util.HashMap;

/**
 *
 * @author novemberizing <me@novemberizing.net>
 * @since 2017. 4. 7.
 */
public class Scenario {
    private static final String Tag = "Scenario";

    @Expose public HashMap<Integer, String> timeline = new HashMap<>();
    @Expose public boolean repeat = false;
    @Expose public int current = 0;

    public void next(){
        if(repeat){
            current++;
            if(timeline.size()<=current) {
                current = 0;
            }
        } else if(timeline!=null && current<timeline.size()){
            current++;
        }
    }

    public Scenario add(Scene scene){
        if(scene!=null){
            Gson gson = innoticon.Client.Gson();
            if (gson != null) {
                timeline.put(timeline.size(), gson.toJson(scene));
            } else {
                Log.w(Tag, "gson==null");
            }
        } else {
            Log.w(Tag, "scene==null");
        }
        return this;
    }

    public Scenario repeat(boolean v){
        repeat = v;
        return this;
    }

    public boolean repeat(){ return repeat; }

    public Scenario(){

    }
}
