package com.vbashur.heaps_maps.mergesortedlists;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.vbashur.common.ListNode;

public class SolutionTest {

    @Test
    public void test() {


        ListNode a0 = new ListNode( 1 );
        ListNode b0 = new ListNode( 10 );
        ListNode c0 = new ListNode( 20 );
        a0.next = b0;
        b0.next = c0;

        ListNode a1 = new ListNode( 4 );
        ListNode b1 = new ListNode( 11 );
        ListNode c1 = new ListNode( 13 );
        a1.next = b1;
        b1.next = c1;

        ListNode a2 = new ListNode( 3 );
        ListNode b2 = new ListNode( 8 );
        ListNode c2 = new ListNode( 9 );
        a2.next = b2;
        b2.next = c2;

        ArrayList<ListNode> a = new ArrayList<>(  );
        a.add( a0 );
        a.add( a1 );
        a.add( a2 );
        Solution s = new Solution();
        ListNode res = s.mergeKLists( a );
        ListNode resNext = res;
        while( resNext!= null )        {
            System.out.print( resNext.val + " -> " );

            resNext = resNext.next;
        }
    }

}