package innoticon;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import novemberizing.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 7.
 */
@SuppressWarnings({"DanglingJavadoc", "unused", "WeakerAccess"})
public class Client implements  Runnable,
                                innoticon.key.Local.Gen,
                                innoticon.ds.Action.Key.Gen,
                                innoticon.ds.Action.Gen,
                                innoticon.ds.Res.Key.Gen,
                                innoticon.ds.Message.Serializer,
                                innoticon.ds.Message.Deserializer {

    private static final String Tag = "innoticon.client>";

    /**
     * client config class
     *
     * @author novemberizing, me@novemberizing.net
     * @since 2017. 2. 7.
     */
    public static class Config extends innoticon.ds.Json {

        private Gson __gson;                                                    /** gson */
        private String __path;                                                  /** config path */
        private novemberizing.ds.on.Single<String> __save;                      /** save function */

        @Expose private innoticon.ds.Client client;                             /** noragram client */

        @Expose private long unique;                                            /** management unique key */
        @Expose private innoticon.ds.User me;                                   /** me */
        @Expose private String name;                                            /** name */
        @Expose private String phone;                                           /** phone */

        public long unique(){ return unique; }                                  /** get unique key */
        public innoticon.ds.User me(){ return me; }                             /** get me */
        public innoticon.ds.Client client(){ return client; }                   /** get client */
        public String name(){ return name; }
        public String phone(){ return phone; }

        public String name(String v){
            name = v;
            save();
            return this.name;
        }

        public String phone(String v){
            phone = v;
            save();
            return this.phone;
        }

        /** set me */
        public innoticon.ds.User me(innoticon.ds.User v){
            this.me = v;
            if(name==null && this.me!=null){
                name = this.me.name;
            }
            save();
            return this.me;
        }

        /** set client key */
        public innoticon.ds.Client client(innoticon.ds.Client v){
            this.client = v;
            save();
            return this.client;
        }

        /**
         * generate unique number
         * @return | long | generated unique number |
         */
        synchronized public long gen(){
            unique++;
            save();
            return unique;
        }

        /** save config */
        public void save(){
            if(__save!=null) {
                __save.on(json(__gson));
            }
        }

        public void init(Gson gson, novemberizing.ds.on.Single<String> save){
            __gson = gson;
            __save = save;
        }

        public Config(){
            __gson = null;
            __path = null;
            unique = System.currentTimeMillis();
        }
    }

    private static Client __singleton = null;

    public static Client Init(innoticon.Client client){ return __singleton = client; }

    public static Client Get(){ return __singleton; }

    public static long Gen(){
        Client client = Get();
        return client.gen();
    }

    public static String Serialize(innoticon.ds.Message message){
        Client client = Get();
        return client.serialize(message);
    }

    public static <T extends innoticon.ds.Message> T Deserialize(String str, Class<T> c){
        Client client = Get();
        return client.deserialize(str, c);
    }

    protected Gson __gson;
    public final novemberizing.rx.Observable<innoticon.Client> observable = new novemberizing.rx.Observable<>();

    @Expose protected Config __config;
    @Expose protected innoticon.ds.User __me;
    @Expose protected innoticon.ds.Client __client;
    @Expose protected String __token;

    public innoticon.ds.Client.Key key() { return __client!=null ? __client.key() : null; }

    public Config config(){ return __config; }

    public innoticon.ds.Client client(){ return __client; }
    public String dev(){ return __client!=null ? __client.device() : null ; }
    public String app(){ return __client!=null ? __client.app() : null; }

    public innoticon.ds.User me(){ return __me; }
    public String name(){ return __me!=null ? __me.name() : null; }
    public String email(){ return __me!=null ? __me.email() : null; }
    public String uid(){ return __me!=null ? __me.uid() : null; }
    public String phone(){ return __me!=null ? __me.phone() : null; }
    public String photo(){ return __me!=null ? __me.photo() : null; }

    public innoticon.Client dev(String v){
        if(__client!=null){
            __client.device(v);
            if(__config==null){
                __config = new Config();
            }
            __config.client(__client);
        } else {
            Log.e(Tag, "__client==null");
        }
        return this;
    }

    public innoticon.Client app(String v){
        if(__client!=null){
            __client.app(v);
            if(__config==null){
                __config = new Config();
            }
            __config.client(__client);
        } else {
            Log.e(Tag, "__client==null");
        }
        return this;
    }

    public innoticon.Client me(innoticon.ds.User v){
        __me = v;
        if(__config==null){
            __config = new Config();
        }
        __config.me(__me);
        return this;
    }

    public innoticon.Client profile(String name, String phone, String photo){
        if(__me!=null){
            __me.name(name);
            __me.phone(phone);
            __me.photo(photo);
            if(__config==null){
                __config = new Config();
            }
            __config.me(__me);
        } else {
            Log.w(Tag, "__me==null");
        }
        return this;
    }

    public innoticon.Client photo(String v){
        if(__me!=null){
            __me.photo(v);
            if(__config==null){
                __config = new Config();
            }
            __config.me(__me);
        } else {
            Log.w(Tag, "__photo==null");
        }
        return this;
    }

    public innoticon.Client name(String v){
        if(__me!=null){
            __me.name(v);
            if(__config==null){
                __config = new Config();
            }
            __config.me(__me);
        } else {
            Log.w(Tag, "__me==null");
        }
        return this;
    }

    public innoticon.Client phone(String v){
        if(__me!=null){
            __me.phone(v);
            if(__config==null){
                __config = new Config();
            }
            __config.me(__me);
        } else {
            Log.w(Tag, "__me==null");
        }
        return this;
    }

    public innoticon.Client email(String v){
        if(__me!=null){
            __me.phone(v);
            if(__config==null){
                __config = new Config();
            }
            __config.me(__me);
        } else {
            Log.w(Tag, "__me==null");
        }
        return this;
    }

    public innoticon.Client uid(String v){
        if(__me!=null){
            __me.uid(v);
            if(__config==null){
                __config = new Config();
            }
            __config.me(__me);
        } else {
            Log.w(Tag, "__me==null");
        }
        return this;
    }

    public innoticon.Client client(innoticon.ds.Client v){
        __client = v;
        if(__config==null){
            __config = new Config();
        }
        __config.client(__client);
        return this;
    }

    public innoticon.Client pub(){
        novemberizing.rx.Observable.Emit(observable, this);
        return this;
    }

    public String token(){ return __token; }

    public void token(String v){ __token = v; }

    public <T> String toJson(T item){ return __gson.toJson(item); }

    public long gen(){ return __config.gen(); }

    @Override public innoticon.key.Local genLocalKey(){ return innoticon.key.Local.Gen(gen()); }
    @Override public innoticon.ds.Action.Key genActionKey() { return new innoticon.ds.Action.Key(genLocalKey()); }
    @Override public innoticon.ds.Action genAction(int type, innoticon.ds.Client.Key client, innoticon.ds.Action.Key key) { return new innoticon.ds.Action(type, client, key); }
    @Override public innoticon.ds.Res.Key genResKey(){ return new innoticon.ds.Res.Key(genLocalKey()); }

    @Override public String serialize(innoticon.ds.Message message){
        try {
            return URLEncoder.encode(__gson.toJson(message),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            Log.e(Tag, e.getMessage());
        }
        return "";
    }

    @Override public <T extends innoticon.ds.Message> T deserialize(String str, Class<T> c){
        try {
            return __gson.fromJson(URLDecoder.decode(str,"UTF-8"),c);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            e.printStackTrace();
        }
        return null;
    }


    public void init(){
        __gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Override
    public void run() {
        Log.d(Tag, "dummy");
    }
}
