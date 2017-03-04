package innoticon.ds;

import com.google.gson.annotations.Expose;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 3. 3.
 */

@SuppressWarnings({"WeakerAccess", "unused"})
public class Name {
    @Expose public String first;
    @Expose public String last;

    public String first(){ return first; }
    public String last(){ return last; }

    public void first(String v){ first = v; }
    public void last(String v){ last = v; }

    /**
     * name
     *
     * @param first | string | first name |
     * @param last  | string | last name |
     * @return | boolean | changed |
     */
    public boolean set(String first,String last){
        this.first = first;
        this.last = last;
        return false;
    }

    public Name(){}

    public Name(String first, String last){
        this.first = first;
        this.last = last;
    }
}
