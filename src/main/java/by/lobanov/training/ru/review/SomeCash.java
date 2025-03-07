package by.lobanov.training.ru.review;

import org.apache.tomcat.util.collections.ManagedConcurrentWeakHashMap;

import java.util.Map;

public class SomeCash {

    public Map<String, byte[]> cashMap = new ManagedConcurrentWeakHashMap<>();

    public void put(String key, byte[] value) {
        cashMap.put(key, value);
    }

    public byte[] find(String key) {
        return cashMap.get(key);
    }
}