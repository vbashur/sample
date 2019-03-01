package com.vbashur.graph.clone;

import static org.junit.Assert.*;

import org.junit.Test;

import com.vbashur.common.UndirectedGraphNode;

public class SolutionTest {

    @Test
    public void cloneValidGraph() {
        Solution s = new Solution();
        UndirectedGraphNode c = new UndirectedGraphNode( 4 );
        UndirectedGraphNode b = new UndirectedGraphNode( 3 );
        UndirectedGraphNode a = new UndirectedGraphNode( 2 );
        a.neighbors.add( b );
        a.neighbors.add( c );
        s.cloneGraph( a );
    }

    @Test
    public void cloneCyclicGraph() {
        Solution s = new Solution();
        UndirectedGraphNode c = new UndirectedGraphNode( 49 );
        UndirectedGraphNode b = new UndirectedGraphNode( 279 );
        UndirectedGraphNode a = new UndirectedGraphNode( 703 );
        a.neighbors.add( b );
        a.neighbors.add( c );
        b.neighbors.add( a );
        b.neighbors.add( c );
        c.neighbors.add( a );
        c.neighbors.add( b );
        s.cloneGraph( a );
    }
}