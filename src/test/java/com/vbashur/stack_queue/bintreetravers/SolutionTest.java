package com.vbashur.stack_queue.bintreetravers;

import com.vbashur.common.TreeNode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void inorderTraversal() {
        Solution s = new Solution();


        TreeNode node1 = new TreeNode( 1 );
        TreeNode node2 = new TreeNode( 2 );
        TreeNode node3 = new TreeNode( 3 );
        node1.left = node2;
        node2.left = node3;
//        TreeNode.printTree(node1);
        List<Integer> traversals = s.inorderTraversal(node1);
        traversals.forEach(System.out::println);
    }
}