package local.ds;

import java.util.ArrayList;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 18.
 */
public class ArrayHashMap<K, V> extends local.ds.Map<K, V> {
    protected ArrayList<K> __keys = new ArrayList<>();

    @Override public V set(K key, V value) {
        if(__map.get(key)==null) {
            __map.put(key, value);
            __keys.add(key);
        } else {
            __map.put(key, value);
        }
        return value;
    }
    @Override public V del(K key) {
        __keys.remove(key);
        return __map.remove(key);
    }

    public K key(int i){
        return (i>=0 && i<__keys.size()) ? __keys.get(i) : null;
    }

    public V value(int i){
        K key = key(i);
        return __map.get(key);
    }
}
