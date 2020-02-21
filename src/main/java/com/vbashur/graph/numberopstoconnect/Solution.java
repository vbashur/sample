package com.vbashur.graph.numberopstoconnect;


/*
20.02.2020
https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 */
public class Solution {

    /*
    isn't done by myself
     */
    public int makeConnected(int n, int[][] connections) {
        int conns[] = new int[n];
        for (int i = 0; i < n; ++i) {
            conns[i] = i;
        }
        int extra = 0;
        for (int[] a : connections) {
            if (union(a[0], a[1], conns))
                extra++;
        }
        int group = 0;
        for (int i = 0; i < n; i++) {
            if (find(i, conns) == i)
                group++;
        }
        return extra >= group - 1 ? group - 1 : -1;
    }

    boolean union(int a, int b, int[] c) {
        if (find(a, c) != find(b, c)) {
            c[c[a]] = c[b];
            return false;
        }
        return true;
    }

    int find(int a, int[] c) {
        if (c[a] != a)
            c[a] = find(c[a], c);
        return c[a];
    }


}
