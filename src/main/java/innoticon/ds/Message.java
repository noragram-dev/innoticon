package innoticon.ds;

import com.google.gson.annotations.Expose;

import java.nio.ByteBuffer;

/**
 * remove builder concept, replace serialize, deserialize, and converter
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 12.
 */
@SuppressWarnings({"DanglingJavadoc", "unchecked", "unused", "WeakerAccess"})
public interface Message {

    class Res {
        public static class Code {
            public static final int FAIL_TO_SEND = 1;
        }
        public static innoticon.ds.Message.Res Gen(int code,String str){ return new Res(code,str); }
        @Expose public int code;
        @Expose public String str;
        @Expose public long timestamp;

        public int code(){ return code; }
        public void code(int v){ code = v; }

        public String str(){ return str; }
        public void str(String v){ str = v; }

        public long timestamp(){ return timestamp; }
        public void timestamp(long v){ timestamp = v; }

        public Res(){}

        public Res(int code,String str){
            this.code = code;
            this.str = str;
            this.timestamp = System.currentTimeMillis();
        }
    }

    /**
     * message converer interface,
     * If this is implemented at CommandLineInterface, <T extends Message, String> convert(T message, Class<String> c)
     * else if at Android, <T extends Message, Drawable or LinearLayout> ....
     */
    interface Converter {
        <T extends Message, Z> Z convert(T message, Class<T> c);
    }

    /**
     * serializer class
     * @see innoticon.Client
     */
    interface Serializer {
        String serialize(innoticon.ds.Message message);
    }

    /**
     * deserializer class
     * @see innoticon.Client
     */
    interface Deserializer {
        <T extends innoticon.ds.Message> T deserialize(String str, Class<T> c);
    }

    /**
     *
     */
    class Key extends innoticon.key.Local {
        @Expose public String name = null;
        public void name(String v){ name = v; }
        public String name(){ return name; }
        public Key(){}
        public Key(String name){
            this.name = name;
            this.timestamp = System.currentTimeMillis();
            this.unique = innoticon.Client.Gen();
        }

        /**
         * key object to bytes
         *
         * @return | byte[] | key's bytes, length is 16 |
         */
        @Override
        public byte[] encode() {
            if(name==null || name.length()==0){
                return null;
            }
            byte[] timestamps = ByteBuffer.allocate(8).putLong(timestamp).array();
            byte[] uniques = ByteBuffer.allocate(8).putLong(unique).array();
            byte[] names = name.replaceAll("[.]","-").getBytes();
            byte[] bytes = new byte[16 + names.length];
            for(int i=0;i<8;i++){ bytes[i*2] = timestamps[8 - i -1]; }
            for(int i=0;i<8;i++){ bytes[i*2 + 1] = uniques[i]; }
            System.arraycopy(names,0,bytes,16,names.length);
            return bytes;
        }

        @Override
        public innoticon.ds.Key decode(byte[] bytes) {
            if(bytes!=null && bytes.length>16) {
                byte[] timestamps = new byte[8];
                byte[] uniques = new byte[8];
                byte[] names = new byte[bytes.length - 16];
                for (int i = 0; i < 8; i++) {
                    timestamps[8 - i - 1] = bytes[i * 2];
                    uniques[i] = bytes[i * 2 + 1];
                }
                System.arraycopy(bytes,16,names,0,bytes.length - 16);
                timestamp = ByteBuffer.wrap(timestamps).getLong();
                unique = ByteBuffer.wrap(uniques).getLong();
                name = new String(names).replaceAll("[-]",".");
                return this;
            }
            return null;
        }

        /**
         * for hash's key
         * @param o
         * @return
         */
        @Override
        public boolean equals(Object o){
            if(o instanceof innoticon.ds.Message.Key){
                innoticon.ds.Message.Key y = (innoticon.ds.Message.Key) o;
                if(name!=null ? name.equals(y.name) : y.name==null){
                    return timestamp==y.timestamp && unique==y.unique;
                } else {
                    return false;
                }
            }
            return false;
        }
    }

    Envelope envelope();                                /** get envelope */
    void envelope(Envelope v);                          /** set envelope */

    innoticon.ds.Message.Key key();                     /** get key */
    void key(innoticon.ds.Message.Key v);               /** set key */

    long timestamp();                                   /** get timestamp by message key */
}
