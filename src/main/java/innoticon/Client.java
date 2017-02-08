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
                                        innoticon.ds.Action.Gen {

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

        public long unique(){ return unique; }                                  /** get unique key */
        public innoticon.ds.User me(){ return me; }                             /** get me */
        public innoticon.ds.Client client(){ return client; }                   /** get client */

        /** set me */
        public innoticon.ds.User me(innoticon.ds.User v){
            this.me = v;
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
            unique = 0;
        }
    }

    private static Client __singleton = null;

    public static Client Init(innoticon.Client client){ return __singleton = client; }

    public static Client Get(){ return __singleton; }

    protected Gson __gson;

    @Expose protected innoticon.ds.Client.Key __key;
    @Expose protected String __dev;
    @Expose protected String __app;
    @Expose protected Config __config;
    @Expose protected innoticon.ds.User __me;

    public innoticon.ds.Client.Key key(){ return __key; }

    public String dev(){ return __dev; }
    public String app(){ return __app; }
    public Config config(){ return __config; }
    public innoticon.ds.User me(){ return __me; }

    public long gen(){ return __config.gen(); }

    @Override public innoticon.key.Local genLocalKey(){ return innoticon.key.Local.Gen(gen()); }
    @Override public innoticon.ds.Action.Key genActionKey() { return new innoticon.ds.Action.Key(genLocalKey()); }
    @Override public innoticon.ds.Action genAction(int type, innoticon.ds.Client.Key client, innoticon.ds.Action.Key key) { return new innoticon.ds.Action(type, client, key); }

    public abstract void init();

}
