package innoticon.key;

import com.google.gson.annotations.Expose;

import java.nio.ByteBuffer;

/**
 * Local Key
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 7.
 */
@SuppressWarnings({"unused", "WeakerAccess", "DanglingJavadoc"})
public class Local extends innoticon.ds.Key {

    public interface Gen { innoticon.key.Local genLocalKey(); }

    /**
     * generate local key
     *
     * @param unique | long | generated unique number |
     * @return | noragram.key.Local | generated key object |
     */
    public static innoticon.key.Local Gen(long unique){ return new innoticon.key.Local(unique); }

    @Expose public long timestamp;          /** timestamp */
    @Expose public long unique;             /** management */

    /**
     * key object to bytes
     *
     * @return | byte[] | key's bytes, length is 16 |
     */
    @Override
    public byte[] encode() {
        byte[] timestamps = ByteBuffer.allocate(8).putLong(timestamp).array();
        byte[] uniques = ByteBuffer.allocate(8).putLong(unique).array();
        byte[] bytes = new byte[16];
        for(int i=0;i<8;i++){ bytes[i*2] = timestamps[8 - i -1]; }
        for(int i=0;i<8;i++){ bytes[i*2 + 1] = uniques[i]; }
        return bytes;
    }

    @Override
    public boolean decode(byte[] arr) {
        if(arr!=null && arr.length==16) {
            byte[] timestamps = new byte[8];
            byte[] uniques = new byte[8];
            for (int i = 0; i < 8; i++) {
                timestamps[8 - i - 1] = arr[i * 2];
                uniques[i] = arr[i * 2 + 1];
            }
            timestamp = ByteBuffer.allocate(8).put(timestamps).getLong();
            unique = ByteBuffer.allocate(8).put(uniques).getLong();
            return true;
        }
        return false;
    }

    public long timestamp(){ return timestamp; }        /** get timestamp */
    public long unique(){ return unique; }              /** get unique */

    public void timestamp(long v){ timestamp = v; }     /** set timestamp */
    public void unique(long v){ unique = v; }           /** set unique */

    /**
     * default constructor
     */
    public Local(){
        this.timestamp = 0;
        this.unique = 0;
    }

    /**
     * constructor to generate local key
     *
     * @param unique generated unique id
     */
    private Local(long unique){
        this.timestamp = System.currentTimeMillis();
        this.unique = unique;
    }
}
