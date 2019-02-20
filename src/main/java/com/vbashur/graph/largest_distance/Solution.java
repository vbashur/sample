

package com.vbashur.graph.largest_distance;


/*




Find largest distance
Given an arbitrary unweighted rooted tree which consists of N (2 <= N <= 40000) nodes. The goal of the problem is to find largest distance between two nodes in a tree.
Distance between two nodes is a number of edges on a path between the nodes
(there will be a unique path between any pair of nodes since it is a tree). The nodes will be numbered 0 through N - 1.

The tree is given as an array P, there is an edge between nodes P[i] and i (0 <= i < N). Exactly one of the i’s will have P[i] equal to -1, it will be root node.

    Example:
    If given P is [-1, 0, 0, 0, 3], then node 0 is the root and the whole tree looks like this:

          0
       /  |  \
      1   2   3
               \
                4

    One of the longest path is 1 -> 0 -> 3 -> 4 and its length is 3, thus the answer is 3. Note that there are other paths with maximal distance.



 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import scala.Int;

/**
 * Created by vic on 20/02/19.
 * <p>
 * https://www.interviewbit.com/problems/largest-distance-between-nodes-of-a-tree/
 */
public class Solution {

    public int solve( ArrayList<Integer> A ) {

        if( A.size() <= 2 ) return A.size() - 1;

        Graph gr = new Graph();
        for( int iter = 1; iter < A.size(); ++iter ) {
            gr.put( iter, A.get( iter ) );
        }

        Integer root = A.get( 1 );
        Map<Integer, Integer> pathMap = new HashMap<>();
        Set<Integer> marked = new HashSet<>();
        pathMap.put( root, 1 );
        marked.add( root );
        gr.findTheLongestPath( root, pathMap, marked );
        Integer v = getMaxEntry( pathMap );
        if( v == -1 ) return root;
        pathMap.clear();
        marked.clear();

        pathMap.put( v, 1 );
        marked.add( v );
        gr.findTheLongestPath( v, pathMap, marked );
        v = getMaxEntry( pathMap );
        return v;
    }

    public Integer getMaxEntry( Map<Integer, Integer> pathMap ) {
        Integer MAX = 1;
        Integer targetV = -1;
        for( Integer v : pathMap.keySet() ) {
            if( pathMap.get( v ) > MAX ) {
                MAX = pathMap.get( v );
                targetV = v;
            }
        }
        return targetV;
    }


    public class Graph {

        private Map<Integer, List<Integer>> adjacents = new HashMap<>();

        public void put( Integer v1, Integer v2 ) {
            if( !adjacents.containsKey( v1 ) ) {
                List<Integer> adjList = new LinkedList<>();
                adjList.add( v2 );
                adjacents.put( v1, adjList );
            } else {
                adjacents.get( v1 ).add( v2 );
            }

            if( !adjacents.containsKey( v2 ) ) {
                List<Integer> adjList = new LinkedList<>();
                adjList.add( v1 );
                adjacents.put( v2, adjList );
            } else {
                adjacents.get( v2 ).add( v1 );
            }
        }

        public void findTheLongestPath( Integer start, Map<Integer, Integer> pathes, Set<Integer> marked ) {
            for( Integer kid : adjacents.get( start ) ) {
                if( pathes.containsKey( kid ) ) {
                    Integer maxLength = Math.max( pathes.get( kid ), (pathes.get( start ) + 1) );
                    pathes.put( kid, maxLength );
                } else {
                    pathes.put( kid, pathes.get( start ) + 1 );
                }
                if( !marked.contains( kid ) ) {
                    marked.add( kid );
                    findTheLongestPath( kid, pathes, marked );
                }
            }
        }
    }
}
