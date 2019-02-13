package com.vbashur.tree.invert_binary_tree;


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

import com.vbashur.common.TreeNode;

/*
 * Created by vic on 13/02/19.
 * <p>
 * https://www.interviewbit.com/problems/invert-the-binary-tree/
 */
public class Solution {

    public TreeNode invertTree(TreeNode A) {
        TreeNode rootNode = A;
        TreeNode left = rootNode.left;
        TreeNode right = rootNode.right;
        A.left = right;
        A.right = left;
        if (A.left != null) {
            invertTree( A.left );
        }
        if (A.right != null) {
            invertTree( A.right );
        }
        return rootNode;
    }
}
