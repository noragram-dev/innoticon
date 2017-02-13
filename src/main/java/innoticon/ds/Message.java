package innoticon.ds;

import java.util.Collection;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 12.
 */
@SuppressWarnings({"DanglingJavadoc", "unchecked", "unused"})
public interface Message {
    interface Converter {
        <T extends Message, Z> Z draw(T message, Class<T> c);
    }

    class Key extends innoticon.key.Local {}

    Envelope envelope();                                /** get envelope */
    void envelope(Envelope v);                          /** set envelope */

    innoticon.ds.Message.Key key();                     /** get key */
    void key(innoticon.ds.Message.Key v);               /** set key */

    long timestamp();                                   /** get timestamp by message key */
}
