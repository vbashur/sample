package com.vbashur.graph.critical_connections;

import java.util.*;

/**
 * https://leetcode.com/contest/weekly-contest-154/problems/critical-connections-in-a-network/
 */

public class Solution {

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        LinkedList<Integer>[] conns = new LinkedList[n];

        for (int i = 0; i < n; ++i) {
            conns[i] = new LinkedList<>();
        }
        for (List<Integer> conn : connections) {
            conns[conn.get(0)].add(conn.get(1));
            conns[conn.get(1)].add(conn.get(0));
        }
        List<List<Integer>> res = new LinkedList<>();
        for (List<Integer> inputEdges : connections) {
            boolean[] marked = new boolean[n];
            Integer nodeA = inputEdges.get(0);
            Integer nodeB = inputEdges.get(1);
            marked[nodeA] = true;
            List<Integer> adjs = getAdjacents(conns[nodeA], nodeB);
            if (!isCyclic(nodeA, nodeB, adjs, conns, marked)) {
                res.add(Arrays.asList(nodeA, nodeB));
            }
        }
        return res;
    }

    private List<Integer> getAdjacents(LinkedList<Integer> adjacents, Integer nodeToExclude) {
        List<Integer> adjs = new LinkedList<>();
        for (Integer c : adjacents) {
            if (!c.equals(nodeToExclude)) {
                adjs.add(c);
            }
        }
        return adjs;
    }

    public boolean isCyclic(Integer a, Integer b, List<Integer> adjs, List<Integer>[] conns, boolean[] marked) {
        for (Integer adj : adjs) {
            if (!marked[adj]) {
                if (adj.equals(b)) {
                    return true;
                } else {
                    marked[adj] = true;
                    return isCyclic(adj, b, conns[adj], conns, marked );
                }
            }
        }
        return false;

    }
}
