package com.vbashur.graph.clone;

/*
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.vbashur.common.UndirectedGraphNode;


/**
 * Created by vic on 1/03/19.
 * <p>
 * https://www.interviewbit.com/problems/clone-graph/
 */
public class Solution {

    public UndirectedGraphNode cloneGraph( UndirectedGraphNode node ) {
        LinkedHashMap<Integer, ArrayList<Integer>> graphMap = new LinkedHashMap<>();
        LinkedList<UndirectedGraphNode> processedNodes = new LinkedList<>();
        processedNodes.add( node );
        getNodes( graphMap, processedNodes );
//        Stack<Map.Entry<Integer, ArrayList<Integer>>> nodeStack = new Stack<Map.Entry<Integer, ArrayList<Integer>>>();
//        for( Map.Entry<Integer, ArrayList<Integer>> entry : graphMap.entrySet() ) {
//            nodeStack.push( entry );
//        }
        Map<Integer, UndirectedGraphNode> resMap = new HashMap<>();
        initNodeMap2( graphMap, resMap, node.label );
//        while( !nodeStack.empty() ) {
//            Map.Entry<Integer, ArrayList<Integer>> lastProcesed = nodeStack.pop();
//            initNodeMap( lastProcesed, resMap );
//        }
        return resMap.get( node.label );
    }

    private void initNodeMap( Map.Entry<Integer, ArrayList<Integer>> entry, Map<Integer, UndirectedGraphNode> resMap ) {
        UndirectedGraphNode ugn = new UndirectedGraphNode( entry.getKey().intValue() );
        resMap.put( ugn.label, ugn );
        for( Integer neighId : entry.getValue() ) {
            if( resMap.containsKey( neighId ) ) {
                resMap.get( ugn.label ).neighbors.add( resMap.get( neighId ) );
            }
        }
    }

    private UndirectedGraphNode initNodeMap2( LinkedHashMap<Integer, ArrayList<Integer>> graphMap, Map<Integer, UndirectedGraphNode> resMap, Integer root ) {

        if( !resMap.containsKey( root ) ) {
            UndirectedGraphNode ugn = new UndirectedGraphNode( root );
            resMap.put( root, ugn );
            for( Integer n : graphMap.get( root ) ) {
                ugn.neighbors.add( initNodeMap2( graphMap, resMap, n ) );
            }
        } else if( graphMap.get( root ) != null ) {
            UndirectedGraphNode ugn = resMap.get( root );
            for( Integer n : graphMap.get( root ) ) {
                ugn.neighbors.add( resMap.get( n ) );
            }
        }
        return resMap.get( root );
    }

    private void getNodes( LinkedHashMap<Integer, ArrayList<Integer>> graphMap, LinkedList<UndirectedGraphNode> processedNodes ) {
        UndirectedGraphNode procNode = processedNodes.pollFirst();
        if( procNode != null && !graphMap.containsKey( procNode.label ) ) {
            ArrayList<Integer> neighbors = new ArrayList<>();
            for( UndirectedGraphNode n : procNode.neighbors ) {
                neighbors.add( n.label );
                processedNodes.add( n );
            }
            graphMap.put( procNode.label, neighbors );
            getNodes( graphMap, processedNodes );
        }
    }
}
