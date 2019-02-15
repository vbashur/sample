package com.vbashur.tree.convertlist_to_bst;


import java.util.ArrayList;

import com.vbashur.common.ListNode;
import com.vbashur.common.TreeNode;


/*
 * Created by vic on 15/02/19.
 * <p>
 * https://www.interviewbit.com/problems/convert-sorted-list-to-binary-search-tree/
 */
/*



Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

    A height balanced BST : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example :


Given A : 1 -> 2 -> 3
A height balanced BST  :

      2
    /   \
   1     3


 */
public class Solution {

    public TreeNode sortedListToBST( ListNode a ) {
        ArrayList<Integer> nodesArr = getNodesArr( a );
        int centerIndex = nodesArr.size() / 2;
        TreeNode tn = buildTree( new TreeNode( nodesArr.get( centerIndex ) ), nodesArr, centerIndex, 1, nodesArr.size() );
        return tn;
    }

    private TreeNode buildTree( TreeNode currentNode, ArrayList<Integer> nodesArr, int curIndex, int lo, int hi ) {
        int leftIndex = (curIndex + lo) / 2;
        int rightIndex = (curIndex + hi) / 2;
        if( Math.abs( leftIndex - rightIndex ) > 0 ) {
            if( nodesArr.get( leftIndex ) != currentNode.val ) {
                currentNode.left = new TreeNode( nodesArr.get( leftIndex ) );
            }
            if( nodesArr.get( rightIndex ) != currentNode.val ) {
                currentNode.right = new TreeNode( nodesArr.get( rightIndex ) );
            }
            buildTree( currentNode.left, nodesArr, leftIndex, lo, curIndex );
            buildTree( currentNode.right, nodesArr, rightIndex, curIndex + 1, hi );
        }
        return currentNode;
    }

    private ArrayList<Integer> getNodesArr( ListNode node ) {
        ArrayList<Integer> nodes = new ArrayList<Integer>();
        nodes.add( Integer.MIN_VALUE );
        while( node != null ) {
            nodes.add( node.val );
            node = node.next;
        }
        return nodes;
    }

/*
    //    That's better
    public TreeNode sortedListToBST( ListNode a ) {
        List elements = new ArrayList<>();
        ListNode temp = a;
        while( temp != null ) {
            elements.add( temp.val );
            temp = temp.next;
        }

        return generateBalancedTree( 0, elements.size() - 1, elements );
    }

    TreeNode generateBalancedTree( int start, int end, List<Integer> elements ) {
        if( start > end ) {
            return null;
        }
        int rootIndex = (start + end) / 2;
        TreeNode root = new TreeNode( elements.get( rootIndex ) );
        TreeNode left = generateBalancedTree( start, rootIndex - 1, elements );
        TreeNode right = generateBalancedTree( rootIndex + 1, end, elements );
        root.left = left;
        root.right = right;
        return root;

    }
*/
}
