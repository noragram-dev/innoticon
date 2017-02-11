package innoticon.ds;

import com.google.gson.annotations.Expose;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 7.
 */
public class Res extends innoticon.ds.Json {
    /** action key */
    public static class Key extends innoticon.ds.Key {

        public interface Gen { Res.Key genResKey(); }

        /**
         * action key generator only generate client key
         *
         * @param unique | long | unique |
         * @return | string | generated key |
         */
        public static Key Gen(long unique){ return new Res.Key(innoticon.key.Local.Gen(unique)); }

        @Expose public innoticon.ds.Client.Key from;            /** client key */
        @Expose public innoticon.key.Local local;               /** server key */

        public innoticon.ds.Client.Key from(){ return from; }
        public innoticon.key.Local local(){ return local; }

        public void from(innoticon.ds.Client.Key v){ from = v; }
        public void local(innoticon.key.Local v){ local = v; }

        @Override
        public byte[] encode(){
            if(from!=null && local!=null){
                byte[] froms = from.encode();
                byte[] locals = local.encode();
                byte[] bytes = new byte[32];
                for(int i=0;i<16;i++){
                    bytes[i*2] = froms[i];
                    bytes[i*2 + 1] = locals[16 - i - 1];
                }
                return bytes;
            }
            return null;
        }

        @Override
        public innoticon.ds.Key decode(byte[] bytes) {
            if(bytes!=null && bytes.length==32){
                byte[] froms = new byte[16];
                byte[] locals = new byte[16];
                for(int i=0;i<16;i++){
                    froms[i] = bytes[i*2];
                    locals[16 - i - 1] = bytes[i*2 + 1];
                }
                if(from==null){ from = new innoticon.ds.Client.Key(); }
                if(local==null){local = new innoticon.key.Local(); }
                from.decode(froms);
                local.decode(locals);
                return this;
            }
            return null;
        }

        /** default constructor */
        public Key(){
            this.from = null;
            this.local = null;
        }

        /**
         * constructor to generate
         * @param local | noragram.key.Local | client key |
         */
        public Key(innoticon.key.Local local){
            innoticon.Client client = innoticon.Client.Get();
            this.from = client.key();
            this.local = local;
        }
    }

    @Expose public innoticon.ds.Res.Key key;            /** null is ok. */
    @Expose public Action action;
    @Expose public String api;
    @Expose public String error;
    @Expose public String msg;

    public innoticon.ds.Res.Key key(){ return key; }
    public Action action(){ return action; }
    public String api(){ return api; }
    public String error(){ return error; }
    public String msg(){ return msg; }

    public Res(){
        action = null;
        api = null;
        error = null;
        key = null;
        msg = null;
    }

    public Res(String api,Action action){
        this.api = api;
        this.action = action;
    }

    public Res(String api,Action action, innoticon.ds.Res.Key key){
        this.api = api;
        this.action = action;
        this.key = key;
    }

    public Res(Class c,Action action){
        this.api = c.getName().toLowerCase();
        this.action = action;
    }
    public Res(Class c, String msg, Action action){
        this.api = c.getName().toLowerCase();
        this.msg = msg;
        this.action = action;
    }

    public Res(Class c, String msg, Action action, innoticon.ds.Res.Key key){
        this.api = c.getName().toLowerCase();
        this.action = action;
        this.msg = msg;
        this.key = key;
    }

    public Res(Class c,Action action, innoticon.ds.Res.Key key){
        this.api = c.getName().toLowerCase();
        this.action = action;
        this.key = key;
    }

    public Res(Class c, Throwable e, Action action){
        this.api = c.getName().toLowerCase();
        this.error = e.getMessage();
        this.action = action;
    }

    public Res(Class c, Throwable e, Action action, innoticon.ds.Res.Key key){
        this.api = c.getName().toLowerCase();
        this.action = action;
        this.error = e.getMessage();
        this.key = key;
    }
}
