package com.vbashur.datastructures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

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
        this.items = new ArrayList<T>();
        for (T item : items) {
            this.add( item );
        }
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
        if (items.size() == 0) {
            items.add(null);
        }
        items.add(item);
        buildTreeUp(items.size() - 1);
    }

    public T poll() {
        if (items.size() > 1) {
            T peek = items.get(1);
            items.set(1, items.get(items.size() - 1));
            items.set(items.size() - 1, peek);
            items.remove(items.size() - 1);
            buildTreeDown(1);
            return peek;
        }
        return null;
    }

    public T peek() {
        if (items.size() > 1)
            return items.get(1);
        return null;
    }

    public static List<? extends Comparable> sort(Comparator<? extends Comparable> comparator, Collection<? extends Comparable> items) {
        PriorityQueue pq = new PriorityQueue( comparator, items );
        LinkedList<Comparable> st = new LinkedList<>(  );
        while (pq.hasItems()) {
            st.add( pq.poll() );
        }
        List<Comparable> col = new LinkedList<>(  );
        while( !st.isEmpty() ) {
            col.add( st.pollLast() );
        }
        return col;
    }

    public boolean hasItems() {
        return items.size() > 1;
    }

    private void buildTreeUp(int index) {
        while (index > 1) {
            buildHeapSubtree(index);
            index /= 2;
        }
        buildHeapSubtree(1);
    }

    private void buildTreeDown(int index) {
        while (index < items.size() && getSubtreeMaxElementIndex(index) != index) {
            int subtreeMaxElementIndex = getSubtreeMaxElementIndex(index);
            buildHeapSubtree(index);
            index = subtreeMaxElementIndex;
        }
    }

    private void buildHeapSubtree(int index) {
        int subtreeMaxElementIndex = getSubtreeMaxElementIndex(index);
        if (subtreeMaxElementIndex != index) {
            T tmp = items.get(subtreeMaxElementIndex);
            items.set(subtreeMaxElementIndex, items.get(index));
            items.set(index, tmp);
        }
    }

    private int getSubtreeMaxElementIndex(int rootIndex) {
        T left = rootIndex * 2 < items.size() ? items.get(rootIndex * 2) : null;
        T right = rootIndex * 2 + 1 < items.size() ? items.get(rootIndex * 2 + 1) : null;
        T root = items.get(rootIndex);
        int maxElementIndex = rootIndex;
        if (left != null && right != null) {
            maxElementIndex = comparator.compare(left, right) > 0 ? rootIndex * 2 : rootIndex * 2 + 1;
        } else if (left != null) {
            maxElementIndex = rootIndex * 2;
        } else if (right != null) {
            maxElementIndex = rootIndex * 2  + 1;
        }
        return comparator.compare(items.get(rootIndex), items.get(maxElementIndex)) > 0 ? rootIndex : maxElementIndex;
    }




}
