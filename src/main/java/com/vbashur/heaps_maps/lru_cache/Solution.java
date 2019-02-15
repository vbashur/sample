package com.vbashur.heaps_maps.lru_cache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;

public class Solution {

    LinkedList<Integer> fifoQueue;
    LinkedHashSet<Integer> fifoSet;
    Map<Integer, Integer> lruCache;
    int capacity;

    public Solution( int capacity ) {
        fifoQueue = new LinkedList<Integer>();
        fifoSet = new LinkedHashSet<>();

        lruCache = new HashMap<>( capacity );
        this.capacity = capacity;


    }

    public int get( int key ) {
        if( lruCache.containsKey( key ) ) {
            fifoSet.remove( key );
            return lruCache.remove( key );
        } else {
            return -1;
        }
    }

    public void set( int key, int value ) {
        if( fifoSet.size() == capacity ) {
            if( fifoSet.contains( key ) ) {
                fifoSet.remove( key );
            } else {
                Iterator<Integer> iterFirst = fifoSet.iterator();
                int polled = iterFirst.next();
                fifoSet.remove( polled );
                lruCache.remove( polled );
            }

        }
        fifoSet.add( key );
        lruCache.put( key, value );

    }

    /*
    public Solution( int capacity) {
        fifoQueue = new LinkedList<Integer>();

        lruCache = new HashMap<>( capacity );
        this.capacity = capacity;


    }

    public int get(int key) {
        if (lruCache.containsKey( key )) {
            int index = fifoQueue.indexOf( key );
            fifoQueue.remove( index );
            return lruCache.remove( key );
        } else {
            return  -1;
        }
    }

    public void set(int key, int value) {
        if (fifoQueue.size() == capacity) {
            Integer polled = fifoQueue.getFirst();
            if (!lruCache.containsKey( polled )) {
                fifoQueue.pollFirst();
            }
} else if (lruCache.containsKey( key )) {

        get( key );
        }
        fifoQueue.add( key );
        lruCache.put( key, value );

        }
     */
}
