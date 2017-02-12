package innoticon.req;

import com.google.gson.annotations.Expose;

/**
 * because can be avail created dialog by system or server.
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 12.
 */
public class Dialog extends innoticon.ds.Req {
    public static class Key extends innoticon.key.Local {
        public static Dialog.Key Gen(String str){
            return (Dialog.Key) new Dialog.Key().decode(novemberizing.util.Key.Decode(str));
        }
    }

    public static class Info extends innoticon.ds.Json {
        @Expose public String title;
        @Expose public String password;
        @Expose public long timestamp;

        public String title(){ return title; }
        public String password(){ return password; }
        public long timestamp(){ return timestamp; }

        public void title(String v){ title = v; }
        public void password(String v){ this.password = v; }
        public void timestamp(long v){ this.timestamp = v; }

        public Info(){}

        public Info(String title, String password, long timestamp){
            this.timestamp = timestamp;
            this.title = title;
            this.password = password;
        }
    }

    @Expose public Dialog.Key key;

    public Dialog(){
        this.key = null;
    }

    public Dialog(long unique, int type) {
        super(unique, type);
    }
}
