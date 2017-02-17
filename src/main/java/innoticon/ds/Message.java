package innoticon.ds;

import com.google.gson.annotations.Expose;

/**
 * remove builder concept, replace serialize, deserialize, and converter
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 12.
 */
@SuppressWarnings({"DanglingJavadoc", "unchecked", "unused"})
public interface Message {
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
