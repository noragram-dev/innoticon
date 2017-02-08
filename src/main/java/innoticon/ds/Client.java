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
        @Expose public long generation;                     /** generation key number, received by server */

        public long timestamp(){ return timestamp; }        /** get timestamp */
        public void timestamp(long v){ timestamp = v; }     /** set timestamp */
        public void generation(long v){ generation = v; }   /** set generation number */
        public long generation(){ return generation; }      /** get generation number */
        public long unique(){ return unique; }              /** get unique */
        public void unique(long v){ unique = v; }           /** set unique */

        /**
         * get key's byte
         *
         * @return | byte[] | byte array |
         */
        @Override
        public byte[] bytes(){
            byte[] timestamps = ByteBuffer.allocate(8).putLong(timestamp).array();
            byte[] uniques = ByteBuffer.allocate(8).putLong(unique).array();
            byte[] generations = ByteBuffer.allocate(8).putLong(generation).array();
            byte[] bytes = new byte[24];
            for(int i=0;i<8;i++){ bytes[i*3] = timestamps[8 - i - 1]; }
            for(int i=0;i<8;i++){ bytes[i*3 + 1] = generations[i]; }
            for(int i=0;i<8;i++){ bytes[i*3 + 2] = uniques[i]; }
            return bytes;
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
