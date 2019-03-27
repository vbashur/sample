package com.vbashur.datastructures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.vbashur.common.TreeNode;

public class BinaryTreeTest {



    TreeNode root;

        @Before
        public void setup() {
            root = new TreeNode( 1 );
            TreeNode node2 = new TreeNode( 2 );
            TreeNode node3 = new TreeNode( 3 );
            TreeNode node4 = new TreeNode( 4 );
            TreeNode node5 = new TreeNode( 5 );
            TreeNode node6 = new TreeNode( 6 );
            TreeNode node7 = new TreeNode( 7 );
            root.left = node2;
            root.right = node3;
            node2.left = node4;
            node2.right = node5;
            node3.left = node6;
            node3.right = node7;
        }
    @Test
    public void preOrderTraversal() {


        String treePrint = BinaryTree.preOrderTraversal( root, new StringBuilder(  ) );
        System.out.println(treePrint);

    }

    @Test
    public void inOrderTraversal() {
        String treePrint = BinaryTree.inOrderTraversal( root, new StringBuilder(  ) );
        System.out.println(treePrint);
    }

    @Test
    public void postOrderTraversal() {
        String treePrint = BinaryTree.postOrderTraversal( root, new StringBuilder(  ) );
        System.out.println(treePrint);
    }

    @Test
    public void bfsRecursiveTraversal() {
    }

    @Test
    public void bfsIterativeTraversal() {
    }

    @Test
    public void dfsRecursiveTraversal() {
    }

    @Test
    public void dfsIterativeTraversal() {
    }
}