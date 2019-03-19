package com.vbashur.backtracking.generate_trees;

import java.util.ArrayList;
import java.util.List;

import com.vbashur.common.TreeNode;

/*
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3


 */
/**
 * Created by vic on 19/03/19.
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 *
 */
// Backtracking is not understandable at all!
public class Solution {

    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        return generateBST(1, n);
    }

    private List<TreeNode> generateBST(int lo, int hi) {
        List<TreeNode> ret = new ArrayList<>();
        if(lo > hi) {
            ret.add(null);
            return ret;
        }
        for(int i = lo; i <= hi; ++i) {
            for(TreeNode left : generateBST(lo, i-1)) {
                for(TreeNode right : generateBST(i+1, hi)) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ret.add(root);
                }
            }
        }
        return ret;
    }
}
