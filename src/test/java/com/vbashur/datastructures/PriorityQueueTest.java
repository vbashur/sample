package com.vbashur.datastructures;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

public class PriorityQueueTest {

    @Test
    public void pqWithAscComparator() {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>( new Comparator<Integer>() {
            @Override
            public int compare( Integer o1, Integer o2 ) {
                return o1.compareTo( o2 );
            }
        } );
        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(4);
        pq.add(5);
        Assert.assertEquals(Integer.valueOf( 5), pq.peek());
        Assert.assertEquals(Integer.valueOf( 5), pq.poll());
        Assert.assertEquals(Integer.valueOf( 4), pq.poll());
        Assert.assertEquals(Integer.valueOf( 3), pq.poll());
        Assert.assertEquals(Integer.valueOf( 2), pq.poll());
        Assert.assertEquals(Integer.valueOf( 1), pq.poll());
        Assert.assertNull(pq.poll());
        Assert.assertNull(pq.poll());

    }

    @Test
    public void pqWithDescComparator() {
        PriorityQueue<String> pq = new PriorityQueue<String>( new Comparator<String>() {
            @Override
            public int compare( String o1, String o2 ) {
                return (-1) * o1.compareTo( o2 );
            }
        } );
        pq.add("q");
        pq.add("e");
        pq.add("v");
        pq.add("a");
        pq.add("p");
        Assert.assertEquals( "a", pq.peek());
        Assert.assertEquals( "a", pq.peek());
        Assert.assertEquals(String.valueOf( "a"), pq.poll());
        Assert.assertEquals(String.valueOf( "e"), pq.poll());
        Assert.assertEquals(String.valueOf( "p"), pq.poll());
        Assert.assertEquals(String.valueOf( "q"), pq.poll());
        Assert.assertEquals(String.valueOf( "v"), pq.poll());
        Assert.assertNull(pq.poll());
        Assert.assertNull(pq.poll());

    }


}