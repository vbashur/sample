package com.vbashur.stack_queue.bintreetravers;

import com.vbashur.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-inorder-traversal/
public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<TreeNode> nodes = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        nodes.addFirst(root);
        while (!nodes.isEmpty()) {
            TreeNode last = nodes.pollFirst();
            if (last != null) {
                nodes.offerFirst(last.right);
                nodes.offerFirst(last);
                nodes.offerFirst(last.left);
            } else {
                last = nodes.peekFirst();
                if (last != null) {
                    res.add(nodes.pollFirst().val);
                }
            }
        }
        return res;

    }
}
