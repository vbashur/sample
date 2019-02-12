package com.vbashur.heaps_maps.mergesortedlists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
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

    public class IntegerDescComparator implements Comparator<Integer> {
        public int compare( Integer a, Integer b ) {
            return b.compareTo( a );
        }
    }

    public ListNode mergeKLists( ArrayList<ListNode> a ) {

        List<Integer> nodeValues = new LinkedList<>();
        for( ListNode list : a ) {
            ListNode item = list;
            while( item != null ) {
                nodeValues.add( item.val );
                item = item.next;
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>( nodeValues.size(), new IntegerDescComparator() );
        for( Integer val : nodeValues ) {
            pq.add( val );
        }
        Integer top = pq.poll();
        ListNode resListNode = new ListNode( top );
        while( top != null ) {
            Integer next = pq.poll();
            if( next == null ) {
                top = null;
            } else {
                ListNode tmpNode = new ListNode( next );
                tmpNode.next = resListNode;
                resListNode = tmpNode;
            }
        }
        return resListNode;
    }
}
