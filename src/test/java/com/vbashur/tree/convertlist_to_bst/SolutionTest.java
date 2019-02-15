package com.vbashur.tree.convertlist_to_bst;

import static org.junit.Assert.*;

import org.junit.Test;

import com.vbashur.common.ListNode;
import com.vbashur.common.TreeNode;

public class SolutionTest {

    Solution s = new Solution();

    @Test
    public void test() {
        ListNode n1 = new ListNode( 1 );
        ListNode n2 = new ListNode( 2 );
        ListNode n3 = new ListNode( 3 );
        ListNode n4 = new ListNode( 4 );
        ListNode n5 = new ListNode( 5 );
        ListNode n6 = new ListNode( 6 );
        ListNode n7 = new ListNode( 7 );
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        TreeNode tn = s.sortedListToBST( n1 );

        TreeNode.printTree( tn );

    }

}