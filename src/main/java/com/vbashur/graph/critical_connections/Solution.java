package com.vbashur.graph.critical_connections;

import java.util.*;

/**
 * https://leetcode.com/contest/weekly-contest-154/problems/critical-connections-in-a-network/
 */

public class Solution {

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        Set<Edge> edges = new HashSet<Edge>();
        LinkedList<Integer>[] conns = new LinkedList[n];
        for (int i = 0; i < n; ++i) {
            conns[i] = new LinkedList<>();
        }
        for (List<Integer> conn : connections) {
            conns[conn.get(0)].add(conn.get(1));
            conns[conn.get(1)].add(conn.get(0));
            edges.add(new Edge(conn));
        }

        List<List<Integer>> res = new LinkedList<>();
        for (Edge e : edges) {
            Set<Integer> marked = new HashSet<Integer>();
            marked.add(e.getA());
            List<Integer> adjs = new LinkedList<Integer>();
            for (Integer adj : conns[e.getA()]) {
                if (!adj.equals(e.getB())) {
                    adjs.add(adj);
                }
            }
            if (!isNotCritical(e.getA(), e.getB(), adjs, conns, marked)) {
                res.add(Arrays.asList(e.getA(), e.getB()));
            }
        }
        return res;
    }

    public boolean isNotCritical(Integer a, Integer b, List<Integer> adjs, List<Integer>[] conns, Set<Integer> marked) {
        for (Integer adj : adjs) {
            if (!marked.contains(adj)) {
                if (!adj.equals(b)) {
                    marked.add(adj);
                    if (isNotCritical(adj, b, conns[adj], conns, marked))
                        return true;
                } else {
                    return true;
                }
            }
        }
        return false;

    }

    class Edge {
        private Integer a;
        private Integer b;

        Edge(Integer a, Integer b) {
            this.a = a;
            this.b = b;
        }

        Edge(List<Integer> conn) {
            this.a = conn.get(0);
            this.b = conn.get(1);
        }

        public Integer getA() {
            return this.a;
        }

        public Integer getB() {
            return this.b;
        }

        public List<Integer> toConn() {
            return Arrays.asList(this.a, this.b);
        }



        public int hashCode() {
            return a.hashCode() + b.hashCode();
        }

        public boolean equals(Object other) {
            if (other == null) return false;
            if (!(other instanceof Edge)) return false;
            if (other == this) return true;
            return (((Edge)other).getA().equals(this.getA()) && ((Edge)other).getB().equals(this.getB()))
                    || (((Edge)other).getA().equals(this.getB()) && ((Edge)other).getB().equals(this.getA()));
        }
    }
}
