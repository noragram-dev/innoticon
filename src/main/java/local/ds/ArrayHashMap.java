package local.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 18.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ArrayHashMap<K, V> extends local.ds.Map<K, V> {
    protected ArrayList<K> __keys = new ArrayList<>();
    protected final Comparator<K> __comparator;

    public ArrayHashMap(){
        __comparator = null;
    }

    public ArrayHashMap(Comparator<K> comparator){
        __comparator = comparator;
    }

    @SuppressWarnings("Java8ListSort")
    @Override
    public V set(K key, V value) {
        if(__map.get(key)==null) {
            __map.put(key, value);
            __keys.add(key);
            if(__comparator!=null) {
                Collections.sort(__keys, __comparator);
            }
        } else {
            __map.put(key, value);
        }
        return value;
    }
    @SuppressWarnings("Java8ListSort")
    @Override
    public V del(K key) {
        __keys.remove(key);
        if(__comparator!=null) {
            Collections.sort(__keys, __comparator);
        }
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
