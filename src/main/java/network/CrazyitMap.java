package network;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CrazyitMap<K, V> {
    public Map<K, V> map = Collections.synchronizedMap(new HashMap<K, V>());

    public synchronized void removeByValue(Object value) {
        for (var key : map.keySet()) {
            if (map.get(key) == value || map.get(key).equals(value)) {
                map.remove(value);
                break;
            }
        }
    }

    public synchronized Set<V> valueSet() {
        Set<V> result = new HashSet<>();
        map.forEach((key, value) -> result.add(value));
        return result;
    }

    public synchronized K getKeyByValue(V val) {
        for (var key : map.keySet()) {
            if (map.get(key) == val || map.get(key).equals(val)) {
                return key;
            }
        }
        return null;
    }

    public synchronized V put(K key, V value) {
        for (var val : valueSet()) {
            if (val.equals(value) && val.hashCode() == value.hashCode()) {
                throw new RuntimeException("CrazyitMap实例中不允许有重复value!");
            }
        }
        return map.put(key, value);
    }

}
