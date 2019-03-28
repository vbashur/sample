package com.vbashur.datastructures;

import java.util.LinkedList;

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

    public static String bfsRecursiveTraversal( TreeNode root, StringBuilder sb ) {
        if( root != null ) {
            System.out.println( root );
            sb.append( "<" + root.val + "> " );
            bfsRecursiveTraversalHelper( root, sb );
        }
        return sb.toString();
    }

    private static String bfsRecursiveTraversalHelper( TreeNode root, StringBuilder sb ) {
        LinkedList<TreeNode> adjs = new LinkedList<>();
        if( root.left != null ) adjs.add( root.left );
        if( root.right != null ) adjs.add( root.right );
        for( TreeNode tn : adjs ) {
            System.out.println( tn );
            sb.append( "<" + tn.val + "> " );

        }
        for( TreeNode tn : adjs ) {
            bfsRecursiveTraversalHelper( tn, sb );
        }
        return sb.toString();
    }

//    public static String bfsRecursiveTraversal( TreeNode root, StringBuilder sb ) {
//        if( root != null ) {
//            LinkedList<TreeNode> adjs = new LinkedList<>();
//            if( root.left != null ) adjs.add( root.left );
//            if( root.right != null ) adjs.add( root.right );
//            bfsRecursiveTraversalHelper( root, sb, new HashSet<Integer>(), adjs );
//        }
//        return sb.toString();
//    }
//
//    private static String bfsRecursiveTraversalHelper( TreeNode root, StringBuilder sb, Set<Integer> marked, LinkedList<TreeNode> adjs ) {
//        if( !marked.contains( root.val ) ) {
//            System.out.println( root );
//            sb.append( "<" + root.val + "> " );
//            marked.add( root.val );
//        }
//        for( TreeNode tn : adjs ) {
//            if( !marked.contains( tn ) ) {
//                System.out.println( tn );
//                sb.append( "<" + tn.val + "> " );
//                marked.add( tn.val );
//            }
//        }
//        if( root.left != null ) {
//            LinkedList<TreeNode> adjsLeft = new LinkedList<>();
//            if( root.left.left != null ) adjsLeft.add( root.left.left );
//            if( root.left.right != null ) adjsLeft.add( root.left.right );
//            bfsRecursiveTraversalHelper( root.left, sb, marked, adjsLeft );
//        }
//        if( root.right != null ) {
//            LinkedList<TreeNode> adjsRight = new LinkedList<>();
//            if( root.right.left != null ) adjsRight.add( root.right.left );
//            if( root.right.right != null ) adjsRight.add( root.right.right );
//            bfsRecursiveTraversalHelper( root.right, sb, marked, adjsRight );
//        }
//        return sb.toString();
//    }

    public static String bfsIterativeTraversal( TreeNode root, StringBuilder sb ) {
        if( root != null ) {
            LinkedList<TreeNode> nodes = new LinkedList<>();
            nodes.add( root );
            while( !nodes.isEmpty() ) {
                TreeNode node = nodes.pollFirst();
                System.out.println( node );
                sb.append( "<" + node.val + "> " );
                if( node.left != null ) nodes.add( node.left );
                if( node.right != null ) nodes.add( node.right );
            }
        }
        return sb.toString();
    }

    public static String dfsRecursiveTraversal( TreeNode root, StringBuilder sb ) {
        if( root != null ) {
            if( root.left != null ) {
                dfsRecursiveTraversal( root.left, sb );
            }
            if( root.right != null ) {
                dfsRecursiveTraversal( root.right, sb );
            }
            System.out.println( root );
            sb.append( "<" + root.val + "> " );
        }
        return sb.toString();
    }

    public static String dfsIterativeTraversal( TreeNode root, StringBuilder sb ) {
        if( root != null ) {
            LinkedList<TreeNode> nodes = new LinkedList<>();
            nodes.add( root );
            while( !nodes.isEmpty() ) {
                TreeNode node = nodes.pollLast();
                if( node.left != null ) nodes.add( node.left );
                if( node.right != null ) nodes.add( node.right );
                System.out.println( node );
                sb.append( "<" + node.val + "> " );
            }
        }
        return sb.toString();
    }
}
