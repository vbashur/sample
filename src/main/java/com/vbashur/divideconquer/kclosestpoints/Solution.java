package com.vbashur.divideconquer.kclosestpoints;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/k-closest-points-to-origin/
public class Solution {

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
                (int[] arr1, int[] arr2) -> getDistForPoint(arr1) < getDistForPoint(arr2) ? -1 : 1);
        for (int iter = 0; iter < points.length; ++iter) {
            pq.offer(points[iter]);
        }

        int[][] res = new int[K][];
        int iter = 0;
        while (iter < K) {
            res[iter] = pq.poll();
            ++iter;
        }
        return res;
    }

    double getDistForPoint(int[] point) {
        int xsq = point[0] * point[0];
        int ysq = point[1] * point[1];
        System.out.println("point = " + Math.sqrt(xsq + ysq) + " p0:" + point[0] + " p1:" + point[1]);
        return Math.sqrt(xsq + ysq);
    }
}
