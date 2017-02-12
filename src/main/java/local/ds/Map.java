package local.ds;

import java.util.HashMap;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 12.
 */
public class Map<K, V> implements local.Map<K, V> {
    protected final HashMap<K, V> __map = new HashMap<>();

    @Override public V get(K key) { return __map.get(key); }
    @Override public V set(K key, V value) {
        __map.put(key, value);
        return value;
    }
    @Override public V del(K key) { return __map.remove(key); }
    @Override public int size() { return __map.size(); }
}
