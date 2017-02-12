package local;

import java.util.Set;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 12.
 */
public interface Map<K, V> {
    V get(K key);
    V set(K key, V value);
    V del(K key);
    int size();
//    Map<K, V> update(Map<K, V> x);
//    Set<java.util.Map.Entry<K, V>> entries();
//    Map<K, V> clear();
}
