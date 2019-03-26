package com.vbashur.tree.least_common_ancestor_recur;

import com.vbashur.common.TreeNode;

/**
 * Created by vic on 3/21/19.
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null){
            return null;
        }
        if(root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null){
            return root;
        }
        return left != null ? left : right;

    }
}