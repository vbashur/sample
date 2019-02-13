package com.vbashur.tree.least_common_ancestor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import com.vbashur.common.TreeNode;


/*
 * Created by vic on 13/02/19.
 * <p>
 * https://www.interviewbit.com/problems/least-common-ancestor/
 */
public class Solution {

    public int lca( TreeNode A, int B, int C ) {
        Map<Integer, Integer> ancestors = getAncestors( A );
        LinkedHashSet<Integer> chainB = getChain( B, ancestors );
        LinkedHashSet<Integer> chainC = getChain( C, ancestors );
        for( Integer nodeVal : chainB ) {
            if( chainC.contains( nodeVal ) ) {
                return nodeVal;
            }
        }
        return -1;
    }


    private LinkedHashSet<Integer> getChain( int target, Map<Integer, Integer> ancestors ) {
        LinkedHashSet<Integer> chain = new LinkedHashSet<>();
        if( ancestors.containsKey( target ) ) {
            chain.add( target );
        }
        while( target != 0 && ancestors != null && ancestors.containsKey( target ) ) {
            target = ancestors.get( target );
            chain.add( target );
        }
        return chain;
    }

    private Map<Integer, Integer> getAncestors( TreeNode treeNode ) {
        Map<Integer, Integer> ancestorsMap = new HashMap<>();
        ancestorsMap.put( treeNode.val, 0 );
        initAncestorsChildren( treeNode, ancestorsMap );
        return ancestorsMap;

    }

    private void initAncestorsChildren( TreeNode treeNode, Map<Integer, Integer> ancestorsMap ) {
        TreeNode left = treeNode.left;
        TreeNode right = treeNode.right;
        if( left != null ) {
            ancestorsMap.put( left.val, treeNode.val );
            initAncestorsChildren( left, ancestorsMap );
        }
        if( right != null ) {
            ancestorsMap.put( right.val, treeNode.val );
            initAncestorsChildren( right, ancestorsMap );
        }
    }
}
