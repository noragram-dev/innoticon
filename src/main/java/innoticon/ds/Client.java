package innoticon.ds;

import com.google.gson.annotations.Expose;

import java.nio.ByteBuffer;

/**
 * client class
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 7.
 */
@SuppressWarnings({"WeakerAccess", "unused", "DanglingJavadoc"})
public class Client extends innoticon.ds.Json {
    /**
     * client key class
     *
     * @author novemberizing, me@novemberizing.net
     * @since 2017. 2. 7.
     */
    public static class Key extends innoticon.ds.Key {
        public interface Gen { Client.Key genClientKey(); }

        @Expose public long timestamp;                      /** timestamp */
        @Expose public long unique;                         /** timestamp's unique */

        public long timestamp(){ return timestamp; }        /** get timestamp */
        public void timestamp(long v){ timestamp = v; }     /** set timestamp */
        public long unique(){ return unique; }              /** get unique */
        public void unique(long v){ unique = v; }           /** set unique */

        /**
         * get key's byte
         *
         * @return | byte[] | byte array |
         */
        @Override
        public byte[] encode(){
            byte[] timestamps = ByteBuffer.allocate(8).putLong(timestamp).array();
            byte[] uniques = ByteBuffer.allocate(8).putLong(unique).array();
            byte[] bytes = new byte[16];
            for(int i=0;i<8;i++){ bytes[i*2] = timestamps[8 - i - 1]; }
            for(int i=0;i<8;i++){ bytes[i*2 + 1] = uniques[i]; }
            return bytes;
        }

        @Override
        public boolean decode(byte[] bytes) {
            if(bytes!=null && bytes.length==16) {
                byte[] timestamps = new byte[8];
                byte[] uniques = new byte[8];
                for (int i = 0; i < 8; i++) {
                    timestamps[8 - i - 1] = bytes[i * 2];
                    uniques[i] = bytes[i * 2 + 1];
                }
                timestamp = ByteBuffer.wrap(timestamps).getLong();
                unique = ByteBuffer.wrap(uniques).getLong();
                return true;
            }
            return false;
        }
    }

    @Expose public String device;                       /** device */
    @Expose public String app;                          /** app */
    @Expose public Client.Key key;                      /** client's key */

    public String device(){ return device; }            /** get device string */
    public String app(){ return app; }                  /** get app string */
    public Client.Key key(){ return key; }              /** get client's key */

    public void device(String v){ this.device = v; }    /** set device */
    public void app(String v){ this.app = v; }          /** set app id */
    public void key(Client.Key v){ this.key = v; }      /** set client key */

    /**
     * default constructor
     */
    public Client(){
        device = null;
        app = null;
        key = null;
    }
}
