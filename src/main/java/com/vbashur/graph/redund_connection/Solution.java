package com.vbashur.graph.redund_connection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/redundant-connection
 */
public class Solution {

    public int[] findRedundantConnection(int[][] edges) {
        Set<Integer> marked = new HashSet<>();
        Map<Integer, Integer> unions = new HashMap<>();
        int[] res = new int[2];
        for (int iter = 0; iter < edges.length; ++iter) {
            int u = edges[iter][0];
            int v = edges[iter][1];
            if (isSameGraph(unions, u, v)) {
                res[0] = u;
                res[1] = v;
            }
            if (unions.containsKey(u)) {
                unions.put(v, u);
            } else {
                unions.put(u, v);
            }
        }
        return res;
    }

    private boolean isSameGraph(Map<Integer, Integer> unions, int u, int v) {
        while (unions.containsKey(u)) {
            u = unions.get(u);
        }
        while (unions.containsKey(v)) {
            v = unions.get(v);
        }
        return u == v;
    }
}
