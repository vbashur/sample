package com.vbashur.tree.path_sum;

import static org.junit.Assert.*;

import org.junit.Assert;
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
        TreeNode.printTree(node1);
        Assert.assertEquals( 1, s.hasPathSum( node1, 3 ));
        Assert.assertEquals( 1, s.hasPathSum( node1, 4 ));
        Assert.assertEquals( 0, s.hasPathSum( node1, 6 ));



    }
}