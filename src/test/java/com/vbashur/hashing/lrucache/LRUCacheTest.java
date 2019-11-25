package com.vbashur.hashing.lrucache;

import org.junit.Test;

public class LRUCacheTest {

    @Test
    public void test() {
        LRUCache c = new LRUCache(2);
//        System.out.println(c.get(2));
        c.put(2,1);
//        System.out.println(c.get(1));
        c.put(1,1);
        c.put(2,3);
        c.put(4,1);
        System.out.println(c.get(1));
        System.out.println(c.get(2));
    }

}