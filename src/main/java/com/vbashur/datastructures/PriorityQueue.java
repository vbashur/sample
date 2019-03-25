package com.vbashur.datastructures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * Created by vic on 3/25/19.
 */
public class PriorityQueue<T extends Comparable> {

    private Comparator<T> comparator;
    private List<T> items;

    public PriorityQueue(Comparator<T> comparator) {
        this.comparator = comparator;
        this.items = new ArrayList<>();
    }

    public PriorityQueue(Comparator<T> comparator, Collection<T> items) {
        this.comparator = comparator;
        this.items = new ArrayList<T>(items);
    }

    public PriorityQueue(Collection<T> items) {
        this.comparator = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        };
        this.items = new ArrayList<T>(items);
    }

    public void add(T item) {
        //TODO
    }

    public T poll() {
        //TODO returns the top element removing it from the Queue
        return null;
    }

    public T peek() {
        //TODO returns the top element without deletion from the Queue
        return null;
    }




}
