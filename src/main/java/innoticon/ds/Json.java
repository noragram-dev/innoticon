package innoticon.ds;

import com.google.gson.Gson;

/**
 * Json
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 7.
 */
@SuppressWarnings("unused")
public class Json {
    /**
     * from object to json
     *
     * @param gson | com.google.gson.Gson | ... |
     * @return | string | json string |
     */
    public String json(Gson gson){ return gson!=null ? gson.toJson(this) : "{}"; }
}
