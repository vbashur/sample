package com.vbashur.tree.path_sum;

import java.util.HashSet;
import java.util.Set;

import com.vbashur.common.TreeNode;

import sun.reflect.generics.tree.Tree;

/*



Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Example :

Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1

return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem


 */


/*
 * Created by vic on 14/02/19.
 * <p>
 * https://www.interviewbit.com/problems/path-sum/
 */


public class Solution {

    public int hasPathSum( TreeNode A, int B) {
        return sink(A, 0, B) ? 1 : 0;
    }

    public boolean sink( TreeNode node, int sum, int target) {
        if (node.right != null) {
            boolean sinkRes = sink(node.right, sum + node.val, target);
            if (sinkRes) return true;
        }
        if (node.left != null) {
            boolean sinkRes = sink(node.left, sum + node.val, target);
            if (sinkRes) return true;
        }
        if (node.right == null && node.left == null) {
            if (sum + node.val == target) return true;
        }
        return false;
    }
}
