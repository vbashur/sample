package com.vbashur.tree.least_common_ancestor;

import static org.junit.Assert.*;

import org.junit.Test;

import com.vbashur.common.TreeNode;

public class SolutionTest {

    Solution s = new Solution();

    @Test
    public void test() {

        TreeNode node1 = new TreeNode( 1 );
        TreeNode node2 = new TreeNode( 2 );
        TreeNode node3 = new TreeNode( 3 );
        TreeNode node4 = new TreeNode( 4 );
        TreeNode node5 = new TreeNode( 5 );
        TreeNode node6 = new TreeNode( 6 );
        TreeNode node7 = new TreeNode( 7 );
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node1.left = node2;
        node1.right = node3;

        TreeNode.printTree(node1);
        Integer ancestor = s.lca( node1, 4, 5 );
        assertEquals( new Integer(2), ancestor );
        System.out.println("------res------" + ancestor);
        ancestor = s.lca( node1, 7, 4 );
        assertEquals( new Integer(1), ancestor );
        ancestor = s.lca( node1, 6, 1 );
        assertEquals( new Integer(1), ancestor );


    }

    @Test
    public void testFailed() {

        TreeNode node1 = new TreeNode( 1 );
        TreeNode node2 = new TreeNode( 2 );
        TreeNode node3 = new TreeNode( 3 );
        TreeNode node4 = new TreeNode( 4 );
        TreeNode node5 = new TreeNode( 5 );
        node4.right = node5;
        node3.left = node4;
        node1.left = node2;
        node1.right = node3;

        TreeNode.printTree(node1);
        Integer ancestor = s.lca( node1, 2, 9 );
        assertEquals( new Integer(-1), ancestor );
        System.out.println("------res------" + ancestor);
        ancestor = s.lca( node1, 28, 89 );
        assertEquals( new Integer(-1), ancestor );

    }





}