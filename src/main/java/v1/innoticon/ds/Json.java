package v1.innoticon.ds;

import com.google.gson.annotations.Expose;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 24.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Json {
    @Expose public String key = null;                       /** | string | json's key | */
    @Expose public String classification = null;            /** | string | classification | */

    public String key(){ return key; }
    public String classification(){ return classification; }

    public Json key(String v){
        key = v;
        return this;
    }

    public Json classification(String v){
        classification = v;
        return this;
    }

    public Json(){}

    public Json(String key, String classification){
        this.key = key;
        this.classification = classification;
    }
}
