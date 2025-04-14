package by.lobanov.training.ru.review.collection.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapAndNull {

    /**
     * https://habr.com/ru/articles/164027/
     * Что выведется в консоль?
     */
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put(null,  null);
        System.out.println(map.containsKey(null));

        Set set = new HashSet();
        set.add(null);
        System.out.println(set.contains(null));

        Map treeMap = new TreeMap();
        treeMap.put(null,  "null");
        System.out.println(treeMap.size());
        treeMap.put(0,  "0");
    }
}
