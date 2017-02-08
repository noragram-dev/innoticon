package innoticon;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 8.
 */
@SuppressWarnings({"WeakerAccess", "DanglingJavadoc","unused"})
public abstract class Server implements Runnable,
                                        innoticon.key.Local.Gen,
                                        innoticon.ds.Action.Key.Gen,
                                        innoticon.ds.Action.Gen {

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

        @Expose private innoticon.ds.Server me;                                 /** noragram client */
        @Expose private long unique;                                            /** management unique key */

        public long unique(){ return unique; }                                  /** get unique key */
        public innoticon.ds.Server me(){ return me; }                           /** get me */

        /** set me */
        public innoticon.ds.Server me(innoticon.ds.Server v){
            this.me = v;
            save();
            return this.me;
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

    protected Gson __gson;

    @Expose protected innoticon.ds.Client.Key __key;
    @Expose protected String __dev;
    @Expose protected String __app;
    @Expose protected Server.Config __config;
    @Expose protected innoticon.ds.Server __me;

    public long gen(){ return __config.gen(); }

    @Override public innoticon.key.Local genLocalKey(){ return innoticon.key.Local.Gen(gen()); }
    @Override public innoticon.ds.Action.Key genActionKey() { return new innoticon.ds.Action.Key(genLocalKey()); }
    @Override public innoticon.ds.Action genAction(int type, innoticon.ds.Client.Key client, innoticon.ds.Action.Key key) { return new innoticon.ds.Action(type, client, key); }

    public abstract void init();
}
