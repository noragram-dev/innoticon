package innoticon.ds;

import com.google.gson.annotations.Expose;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 12.
 */
@SuppressWarnings({"DanglingJavadoc", "unchecked", "unused"})
public interface Message {
    interface Converter {
        <T extends Message, Z> Z convert(T message, Class<T> c);
    }

    interface Serializer {
        String serialize(innoticon.ds.Message message);
    }

    interface Deserializer {
        <T extends innoticon.ds.Message> T deserialize(String str, Class<T> c);
    }

    class Key extends innoticon.key.Local {
        @Expose public String name = null;
        public void name(String v){ name = v; }
        public String name(){ return name; }
        public Key(){}
        public Key(String name){
            this.name = name;
        }
    }

    Envelope envelope();                                /** get envelope */
    void envelope(Envelope v);                          /** set envelope */

    innoticon.ds.Message.Key key();                     /** get key */
    void key(innoticon.ds.Message.Key v);               /** set key */

    long timestamp();                                   /** get timestamp by message key */
}
