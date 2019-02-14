package com.vbashur.tree.flatten_to_list;

import org.junit.Test;

import com.vbashur.common.TreeNode;


public class SolutionTest {

    Solution s = new Solution();

    @Test
    public void test() {

        TreeNode node1 = new TreeNode( 1 );
        TreeNode node2 = new TreeNode( 2 );
        TreeNode node3 = new TreeNode( 3 );

        node1.left = node2;
        node1.right = node3;
        node2.right = null;
        node3.right = null;
        node2.left = null;
        node3.left = null;
        TreeNode.printTree( node1 );
        TreeNode actualTreeNode = s.flatten( node1 );
        System.out.println("------res------");
        TreeNode.printTree( actualTreeNode );

    }

    @Test
    public void testRightSided() {

        TreeNode node1 = new TreeNode( 1 );
        TreeNode node2 = new TreeNode( 2 );
        TreeNode node3 = new TreeNode( 3 );
        node1.right = node2;
        node2.right = node3;

        TreeNode.printTree( node1 );
        TreeNode actualTreeNode = s.flatten( node1 );
        System.out.println("------res------");
        TreeNode.printTree( actualTreeNode );
    }

    @Test
    public void testLeftSided() {

        TreeNode node1 = new TreeNode( 1 );
        TreeNode node2 = new TreeNode( 2 );
        TreeNode node3 = new TreeNode( 3 );
        node1.left = node2;
        node2.left = node3;

        TreeNode.printTree( node1 );
        TreeNode actualTreeNode = s.flatten( node1 );
        System.out.println("------res------");
        TreeNode.printTree( actualTreeNode );
    }

    @Test
    public void testComplex1() {

        TreeNode node1 = new TreeNode( 1 );
        TreeNode node2 = new TreeNode( 2 );
        TreeNode node3 = new TreeNode( 3 );
        TreeNode node4 = new TreeNode( 4 );
        node1.left = node2;
        node2.left = node3;
        node2.right = node4;

        TreeNode.printTree( node1 );
        TreeNode actualTreeNode = s.flatten( node1 );
        System.out.println("------res------");
        TreeNode.printTree( actualTreeNode );
    }

    @Test
    public void testComplex2() {

        TreeNode node1 = new TreeNode( 1 );
        TreeNode node2 = new TreeNode( 2 );
        TreeNode node3 = new TreeNode( 3 );
        TreeNode node4 = new TreeNode( 4 );
        TreeNode node5 = new TreeNode( 5 );
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node4.right = node5;

        TreeNode.printTree( node1 );
        TreeNode actualTreeNode = s.flatten( node1 );
        System.out.println("------res------");
        TreeNode.printTree( actualTreeNode );
    }

    @Test
    public void testSlightRightSided() {

        TreeNode node1 = new TreeNode( 1 );
        TreeNode node2 = new TreeNode( 2 );
        TreeNode node3 = new TreeNode( 3 );
        TreeNode node4 = new TreeNode( 4 );
        TreeNode node5 = new TreeNode( 5 );
        TreeNode node6 = new TreeNode( 6 );
        TreeNode node7 = new TreeNode( 7 );
        node1.right = node2;
        node2.right = node3;
        node3.right = node5;
        node3.left = node4;
        node5.right = node7;
        node5.left = node6;

        TreeNode.printTree( node1 );
        TreeNode actualTreeNode = s.flatten( node1 );
        System.out.println("------res------");
        TreeNode.printTree( actualTreeNode );
    }


//    @Ignore
    @Test
    public void testMadLeftSided() {

        TreeNode node1 = new TreeNode( 1 );
        TreeNode node2 = new TreeNode( 2 );
        TreeNode node3 = new TreeNode( 3 );
        TreeNode node4 = new TreeNode( 4 );
        TreeNode node5 = new TreeNode( 5 );
        TreeNode node6 = new TreeNode( 6 );
        TreeNode node7 = new TreeNode( 7 );
        node1.right = node3;
        node1.left = node2;
        node3.right = node4;
        node4.right = node7;
        node3.left = node5;
        node5.left = node6;

        TreeNode.printTree( node1 );
        TreeNode actualTreeNode = s.flatten( node1 );
        System.out.println("------res------");
        TreeNode.printTree( actualTreeNode );
    }

    @Test
    public void testDoubleTree() {

        TreeNode node1 = new TreeNode( 1 );
        TreeNode node2 = new TreeNode( 2 );
        TreeNode node3 = new TreeNode( 3 );
        TreeNode node4 = new TreeNode( 4 );
        TreeNode node5 = new TreeNode( 5 );
        node1.right = node4;
        node1.left = node2;
        node2.left = node3;

        TreeNode.printTree( node1 );
        TreeNode actualTreeNode = s.flatten( node1 );
        System.out.println("------res------");
        TreeNode.printTree( actualTreeNode );
    }


}