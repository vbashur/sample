package com.vbashur.tree.invert_binary_tree;

import static org.junit.Assert.*;

import org.junit.Test;

import com.vbashur.common.TreeNode;


/*

Given a binary tree, invert the binary tree and return it.
Look at the example for more details.

Example :
Given binary tree

     1
   /   \
  2     3
 / \   / \
4   5 6   7

invert and return

     1
   /   \
  3     2
 / \   / \
7   6 5   4

 */
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

        TreeNode.printTree( node1 );
        TreeNode actualTreeNode = s.invertTree( node1 );
        System.out.println("------res------");
        TreeNode.printTree( actualTreeNode );

    }
}