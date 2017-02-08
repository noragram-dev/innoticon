package innoticon.ds;

import com.google.gson.annotations.Expose;

import java.util.HashMap;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 7.
 */
@SuppressWarnings({"WeakerAccess", "unused", "DanglingJavadoc"})
public class Server {

    @Expose public String uid;              /** make named uuid */
    @Expose public String name;             /** email */
    @Expose public String app;

    public String uid(){ return uid; }
    public void uid(String v){ uid = v; }

    public String name(){ return name; }
    public void name(String v){ name = v; }
}
