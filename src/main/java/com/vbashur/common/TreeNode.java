package com.vbashur.common;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode( int x ) {
        val = x;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static void printTree( TreeNode node) {
        System.out.print( node.val );
        if (node.left != null) {
            System.out.print(" L->" + node.left.val );
        }
        if (node.right != null) {
            System.out.print(" R->" + node.right.val );
        }
        System.out.println();
        if (node.left != null) {
            printTree( node.left );
        }
        if (node.right != null) {
            printTree( node.right );
        }

    }
}
