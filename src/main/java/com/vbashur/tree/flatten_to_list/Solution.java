package com.vbashur.tree.flatten_to_list;

/*


Given a binary tree, flatten it to a linked list in-place.

Example :
Given


         1
        / \
       2   5
      / \   \
     3   4   6

The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6

Note that the left child of all nodes should be NULL.

 */

import com.vbashur.common.TreeNode;

/*
 * Created by vic on 13/02/19.
 * <p>
 * https://www.interviewbit.com/problems/flatten-binary-tree-to-linked-list/
 */
public class Solution {

    public TreeNode flatten( TreeNode a ) {
        return sinkLeft( a );
    }

    private TreeNode sinkLeft( TreeNode a ) {
        if( a.left != null ) {
            TreeNode appendedNode = sinkLeft( a.left );
            TreeNode tmp = a.right;
            a.right = appendedNode;
            TreeNode rightMost = getRightMost( appendedNode );
            rightMost.right = tmp;
            a.left = null;
        }
        if( a.right != null ) {
            sinkLeft( a.right );
        }
        return a;
    }

    private TreeNode getRightMost( TreeNode appendedNode ) {
        if( appendedNode.right != null ) {
            return getRightMost( appendedNode.right );
        }
        return appendedNode;
    }

/* FIRST APPROACH - FAILED TESTS
    private TreeNode sinkDeepRight(TreeNode a) {
        if (a.right != null && a.right.val != -1) {
            sinkDeepRight( a.right );
        }
        if (a.left != null && a.left.val != -1) {
            TreeNode appendedNode = sinkDeepRight( a.left );
            if (a.right != null ) {
                TreeNode rightMost = appendedNode.right != null ? sinkDeepRight( appendedNode.right ) : appendedNode;
                rightMost.right = a.right;
            }
            a.right = appendedNode;
            a.left = null;
        }
        return a;
    }
    */
}
