package com.vbashur.tree.find_bottom_left_tree_value;

import com.vbashur.common.TreeNode;

/*
 Created by vic on 26/07/19.
https://leetcode.com/problems/find-bottom-left-tree-value/

Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2:
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7

 */
public class Solution {

    private int max = Integer.MIN_VALUE;
    private int max_val = 0;

    public int findBottomLeftValue(TreeNode root) {
        getBottomLeftNode(root, 0);
        return max_val;
    }


    public void getBottomLeftNode(TreeNode node, int counter) {
        if (node == null) {
            return;
        }
        if (counter > max) {
            max = counter;
            max_val = node.val;
        }
        getBottomLeftNode(node.left, counter + 1);
        getBottomLeftNode(node.right, counter + 1);
    }

    /*
     public int findBottomLeftValue(TreeNode root) {
        if (root != null) {
            getBottomLeftNode(root, true, 1);
        }
        return max_val;
    }


    public void getBottomLeftNode(TreeNode node, boolean parentHasLeft, int counter) {
        if (node.left != null) {
            getBottomLeftNode(node.left, true, counter + 1);
        }
        if (node.right != null) {
            getBottomLeftNode(node.right, false, counter + 1);
        }
        if (parentHasLeft) {
            if (counter > max) {
                max = counter;
                max_val = node.val;
            }
        }
    }
     */
}
