package v1.innoticon.ds;

import com.google.gson.annotations.Expose;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 24.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Image {
    @Expose public String path = null;              /** | string | image path | file://, http://, https://, cache://, db://, storage:// | */
    @Expose public String description = null;       /** | string | image description | */
    @Expose public String alternative = null;       /** | string | alternative | */

    public String path(){ return path; }
    public String description(){ return description; }
    public String alternative(){ return alternative; }

    public Image path(String v){
        path = v;
        return this;
    }

    public Image description(String v){
        description = v;
        return this;
    }

    public Image alternative(String v){
        alternative = v;
        return this;
    }

    public Image(){}

    public Image(String path){
        this.path = path;
    }
}
