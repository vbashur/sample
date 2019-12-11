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
        Map<Integer, Integer> unions = new HashMap<>();
        int[] res = new int[2];
        for (int iter = 0; iter < edges.length; ++iter) {
            int u = edges[iter][0];
            int v = edges[iter][1];
            if (isSameGraph(unions, u, v)) {
                res[0] = u;
                res[1] = v;
            } else {
                if (unions.containsKey(u)) {
                    Integer root = getRoot(unions, u);
                    unions.put(v, root);
                } else {
                    Integer root = getRoot(unions, v);
                    unions.put(u, root);
                }
            }
        }
        return res;
    }

    private boolean isSameGraph(Map<Integer, Integer> unions, int u, int v) {
        return getRoot(unions, u) == getRoot(unions, v);
    }

    private Integer getRoot(Map<Integer, Integer> unions, int u) {
        while (unions.containsKey(u)) {
            u = unions.get(u);
        }
        return u;
    }
}
