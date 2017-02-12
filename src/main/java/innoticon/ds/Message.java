package innoticon.ds;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 12.
 */
public interface Message {
    interface Builder {
        <T extends Message> String text(T message, Class<T> c);
        <T extends Message, Z extends Draw> Z draw(T message, Class<T> c);
    }

    Envelope envelope();

    /**
     * make default drawable
     * @return | Draw | Android's Drawable object , ... |
     */
    Draw drawable();
    /**
     * make drawable to use the other builder
     * @return | Draw | Android's Drawable object , ... |
     */
    Draw drawable(Builder builder);

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

    /**
     * set builder
     * @param builder builder
     * @return
     */
    Message builder(Builder builder);
}
