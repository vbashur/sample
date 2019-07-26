package com.vbashur.tree.find_bottom_left_tree_value;

import com.vbashur.common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution s = new Solution();

    @Test
    public void findBottomLeftValue() {
        TreeNode node1 = new TreeNode( 1 );
        TreeNode node2 = new TreeNode( 2 );
        TreeNode node3 = new TreeNode( 3 );
        node1.left = node2;
        node1.right = node3;
        int leftmost = s.findBottomLeftValue(node1);
        Assert.assertEquals(2, leftmost);
    }
}
