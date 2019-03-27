package com.vbashur.datastructures;

import com.vbashur.common.TreeNode;

public class BinaryTree {

    public static String preOrderTraversal( TreeNode root, StringBuilder sb ) {
        if( root != null ) {
            sb.append( "<" + root.val + "> " );
            System.out.println( root );
            preOrderTraversal( root.left, sb );
            preOrderTraversal( root.right, sb );
        }
        return sb.toString();
    }

    public static String inOrderTraversal( TreeNode root, StringBuilder sb ) {
        if( root != null ) {
            inOrderTraversal( root.left, sb );
            sb.append( "<" + root.val + "> " );
            System.out.println( root );
            inOrderTraversal( root.right, sb );
        }
        return sb.toString();
    }

    public static String postOrderTraversal( TreeNode root, StringBuilder sb ) {
        if( root != null ) {
            postOrderTraversal( root.left, sb );
            postOrderTraversal( root.right, sb );
            sb.append( "<" + root.val + "> " );
            System.out.println( root );
        }
        return sb.toString();
    }

    public static String bfsRecursiveTraversal( TreeNode root ) {
        return "";

    }

    public static String bfsIterativeTraversal( TreeNode root ) {
        return "";
    }

    public static String dfsRecursiveTraversal( TreeNode root ) {
        return "";
    }

    public static String dfsIterativeTraversal( TreeNode root ) {
        return "";
    }
}
