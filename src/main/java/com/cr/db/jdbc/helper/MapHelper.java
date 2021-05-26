package com.cr.db.jdbc.helper;

import java.util.HashMap;
import java.util.Map;

public class MapHelper<K, V> {
    public  Map<K, V> filterMap(Map<Object, V> map) {
        Map<K,V> nMap = new HashMap<K, V>();
        map.forEach((k, v) -> {
            if (k instanceof Integer)
                nMap.put((K)k, v);
        });
        return nMap;
    }
}
