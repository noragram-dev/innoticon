package innoticon.ds;


import java.util.Base64;

/**
 * Key
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 7.
 */
@SuppressWarnings("unused")
public abstract class Key extends innoticon.ds.Json {


    /**
     * key object to hex
     *
     * @return | string | hex |
     */
    public String hex(){ return novemberizing.util.Key.Encode(encode()); }

    /**
     * key object to bytes
     *
     * @return | byte[] | key's bytes |
     */
    public abstract byte[] encode();
    public abstract Key decode(byte[] arr);

}
