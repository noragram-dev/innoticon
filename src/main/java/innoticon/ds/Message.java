package innoticon.ds;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 12.
 */
@SuppressWarnings("DanglingJavadoc")
public interface Message {
    interface Builder {
        <T extends Message> String text(T message, Class<T> c);
        <T extends Message, Z extends Drawable> Z draw(T message, Class<T> c);
    }

    class Key extends innoticon.key.Local {}

    Envelope envelope();                                /** get envelope */
    void envelope(Envelope v);                          /** set envelope */

    innoticon.ds.Message.Key key();                     /** get key */
    void key(innoticon.ds.Message.Key v);               /** set key */

    innoticon.ds.Message.Builder builder();             /** get builder */
    void builder(innoticon.ds.Message.Builder v);       /** set builder */

    long timestamp();                                   /** get timestamp by message key */

    /**
     * make default drawable
     * @return | Drawable | Android's Drawable object , ... |
     */
    Drawable drawable();
    /**
     * make drawable to use the other builder
     * @return | Drawable | Android's Drawable object , ... |
     */
    Drawable drawable(Builder builder);

    /**
     * make text message to use custom builder
     * @param builder default builder
     * @return text messgae
     */
    String text(Builder builder);

    /**
     * make default text message
     * @return text message
     */
    String text();
}
