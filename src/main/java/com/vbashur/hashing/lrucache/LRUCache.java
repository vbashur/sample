package com.vbashur.hashing.lrucache;

import java.util.LinkedHashMap;

public class LRUCache {

    private LinkedHashMap<Integer, Integer> lhm;
    int capacity;
    int size;

    public LRUCache(int capacity) {
        lhm = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        if (lhm.containsKey(key)) {
            int val = lhm.get(key);
            lhm.remove(key);
            size -= 1;
            put(key, val);
            return val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (!lhm.containsKey(key)) {
            size += 1;
            if (size > capacity) {
                Integer firstKey = lhm.keySet().iterator().next();
                evict(firstKey);
            }
            lhm.put(key, value);
        } else {
            lhm.remove(key);
            size -= 1;
            put(key, value);
        }

    }

    private void evict(int key) {
        lhm.remove(key);
        size -= 1;
    }
}
