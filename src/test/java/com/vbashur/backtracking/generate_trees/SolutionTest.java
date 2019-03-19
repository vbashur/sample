package com.vbashur.backtracking.generate_trees;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.vbashur.common.TreeNode;

public class SolutionTest {

    @Test
    public void generateTrees() {
        Solution s= new Solution();
        List<TreeNode> nodes = s.generateTrees( 2 );
        for (TreeNode n : nodes) {
            System.out.println( n );
        }

    }
}