package innoticon;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 7.
 */
@SuppressWarnings({"DanglingJavadoc", "unused", "WeakerAccess"})
public abstract class Client implements Runnable,
                                        innoticon.key.Local.Gen,
                                        innoticon.ds.Action.Key.Gen,
                                        innoticon.ds.Action.Gen,
                                        innoticon.ds.Res.Key.Gen,
                                        innoticon.ds.Message.Serializer,
                                        innoticon.ds.Message.Deserializer {

    /**
     * client config class
     *
     * @author novemberizing, me@novemberizing.net
     * @since 2017. 2. 7.
     */
    public static class Config extends innoticon.ds.Json {
        /**
         * Init Config
         *
         * @param path | string | config path |
         * @param gson | Gson | gson |
         * @return | noragram.Client.Config | config |
         */
        public static Config Init(String path, Gson gson){
            Config config = new Config();
            config.init(path, gson);
            return config;
        }

        private Gson __gson;                                                    /** gson */
        private String __path;                                                  /** config path */

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
        public void save(){ novemberizing.util.File.Set(__path, json(__gson)); }

        /**
         * set path & gson
         *
         * @param path | string | config path |
         * @param gson | Gson | gson |
         */
        public void init(String path, Gson gson){
            __path = path;
            __gson = gson;
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

//    @Expose protected innoticon.ds.Client.Key __key;
    @Expose protected String __dev;
    @Expose protected String __app;
    @Expose protected Config __config;
    @Expose protected innoticon.ds.User __me;
    @Expose protected String __name;
    @Expose protected String __phone;

    public abstract innoticon.ds.Client.Key key();

    public String dev(){ return __dev; }
    public String app(){ return __app; }
    public Config config(){ return __config; }
    public innoticon.ds.User me(){ return __me; }
    public String name(){ return __name; }
    public String phone(){ return __phone; }

    public innoticon.ds.User profile(String name, String phone){
        __me.name(name);
        __me.phone(phone);
        return __config.me(__me);
    }

    public innoticon.ds.User name(String name){
        __me.name(name);
        return __config.me(__me);
    }

    public long gen(){ return __config.gen(); }

    @Override public innoticon.key.Local genLocalKey(){ return innoticon.key.Local.Gen(gen()); }
    @Override public innoticon.ds.Action.Key genActionKey() { return new innoticon.ds.Action.Key(genLocalKey()); }
    @Override public innoticon.ds.Action genAction(int type, innoticon.ds.Client.Key client, innoticon.ds.Action.Key key) { return new innoticon.ds.Action(type, client, key); }
    @Override public innoticon.ds.Res.Key genResKey(){ return new innoticon.ds.Res.Key(genLocalKey()); }

    @Override public String serialize(innoticon.ds.Message message){ return __gson.toJson(message); }

    @Override public <T extends innoticon.ds.Message> T deserialize(String str, Class<T> c){ return __gson.fromJson(str, c); }

    public abstract void init();

}
