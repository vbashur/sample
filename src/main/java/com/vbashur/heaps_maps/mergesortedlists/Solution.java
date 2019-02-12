package com.vbashur.heaps_maps.mergesortedlists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import com.vbashur.common.ListNode;

/**
 * Merge k sorted linked lists and return it as one sorted list.
 * <p>
 * Example :
 * <p>
 * 1 -> 10 -> 20
 * 4 -> 11 -> 13
 * 3 -> 8 -> 9
 * <p>
 * will result in
 * <p>
 * 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
 */

/**
 * Created by vic on 12/02/19.
 * <p>
 * https://www.interviewbit.com/problems/merge-k-sorted-lists/
 */
public class Solution {

    public class IntegerAscComparator implements Comparator<Integer> {
        public int compare( Integer a, Integer b ) {
            return a.compareTo( b );
        }
    }

    public ListNode mergeKLists( ArrayList<ListNode> a ) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>( new IntegerAscComparator() );
        for( ListNode list : a ) {
            ListNode item = list;
            while( item != null ) {
                pq.add( item.val );
                item = item.next;
            }
        }

        ListNode prevNode = null, firstNode = null;
        while( !pq.isEmpty() ) {
            Integer next = pq.poll();
            ListNode tmpNode = new ListNode( next );
            if( firstNode == null ) {
                prevNode = new ListNode( next );
                firstNode = prevNode;
            } else {
                prevNode.next = tmpNode;
                prevNode = tmpNode;
            }
        }
        return firstNode;
    }
}
