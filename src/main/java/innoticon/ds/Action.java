package innoticon.ds;

import com.google.gson.annotations.Expose;

/**
 * action key
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 7.
 */
@SuppressWarnings({"DanglingJavadoc", "unused", "WeakerAccess", "PointlessArithmeticExpression"})
public class Action extends innoticon.ds.Json {

    public static class Type {
        private static final int BASE = 0;

        public static final int HELLOREQ = BASE + 1;
//        public static final int ADDEMAILREQ = BASE + 2;
//        public static final int ADDPHONEREQ = BASE + 3;
        public static final int INVITEBYEMAILREQ = BASE + 4;
        public static final int INVITEBYPHONEREQ = BASE + 5;
        public static final int ACCEPTTOINVITEREQ = BASE + 6;
        public static final int REJECTTOINVITEREQ = BASE + 7;
        public static final int SENDMSGREQ = BASE + 8;
        public static final int SETPROFILENAMEREQ = BASE + 9;
        public static final int SETPROFILEPHONEREQ = BASE + 10;
        public static final int SETPROFILEREQ = BASE + 11;
        public static final int ENABLEAPI = BASE + 12;

        private static final int SERVER = -1;

        public static final int REGISTERCLIENTREQ = SERVER * (BASE + 1);
        public static final int HELLOCLIENTREQ = SERVER * (BASE + 2);
        public static final int HELLOSERVERREQ = SERVER * (BASE + 3);
    }

    /** action key */
    public static class Key extends innoticon.ds.Key {

        public interface Gen { Action.Key genActionKey(); }

        /**
         * action key generator only generate client key
         *
         * @param unique | long | unique |
         * @return | string | generated key |
         */
        public static Key Gen(long unique){ return new Action.Key(innoticon.key.Local.Gen(unique)); }

        @Expose public innoticon.key.Local c;                        /** client key */
        @Expose public innoticon.key.Local s;                        /** server key */

        public innoticon.key.Local c(){ return c; }
        public innoticon.key.Local s(){ return s; }

        public void c(innoticon.key.Local v){ c = v; }
        public void s(innoticon.key.Local v){ s = v; }

        @Override
        public byte[] encode(){
            if(s!=null && c!=null){
                byte[] clients = c.encode();
                byte[] servers = s.encode();
                byte[] bytes = new byte[32];
                for(int i=0;i<16;i++){
                    bytes[i*2] = clients[i];
                    bytes[i*2 + 1] = servers[16 - i - 1];
                }
                return bytes;
            }
            return null;
        }

        @Override
        public innoticon.ds.Key decode(byte[] bytes) {
            if(bytes!=null && bytes.length==32){
                byte[] clients = new byte[16];
                byte[] servers = new byte[16];
                for(int i=0;i<16;i++){
                    clients[i] = bytes[i*2];
                    servers[16 - i - 1] = bytes[i*2 + 1];
                }
                if(c==null){ c = new innoticon.key.Local(); }
                if(s==null){ s = new innoticon.key.Local(); }
                c.decode(clients);
                s.decode(servers);
                return this;
            }
            return null;
        }

        /** default constructor */
        public Key(){
            this.c = null;
            this.s = null;
        }

        /**
         * constructor to generate
         * @param c | noragram.key.Local | client key |
         */
        public Key(innoticon.key.Local c){
            this.c = c;
            this.s = null;
        }
    }

    public interface Gen {
        innoticon.ds.Action genAction(int type, innoticon.ds.Client.Key client, innoticon.ds.Action.Key key);
    }

    public static String root(Action action){ return action!=null ? (action.type()<0 ? "server" : "user") : null; }
    public static String root(int type){ return type<0 ? "server" : "user"; }

    @Expose public int type;                                        /** action type number */
    @Expose public innoticon.ds.Client.Key client;                  /** client key */
    @Expose public innoticon.ds.Action.Key key;                     /** action key */
    @Expose private String uid;                                     /** hidden field */

    public int type(){ return this.type; }                          /** get action type */
    public void type(int v){ this.type = v; }                       /** set action type */

    public innoticon.ds.Client.Key client(){ return client; }       /** get client key */
    public void client(innoticon.ds.Client.Key v){ client = v;}     /** set client key */

    public innoticon.ds.Action.Key key(){ return key; }             /** get action key */
    public void key(innoticon.ds.Action.Key v){ key = v; }          /** set action key */

    public String uid(){ return uid; }

    /** default constructor */
    public Action(){
        type = 0;
        client = null;
        key = null;
        uid = null;
    }

    public Action(int type, innoticon.ds.Client.Key client, innoticon.ds.Action.Key key){
        this.type = type;
        this.client = client;
        this.key = key;
        this.uid = null;
    }
}
