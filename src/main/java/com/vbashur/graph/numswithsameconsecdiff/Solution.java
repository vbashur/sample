package com.vbashur.graph.numswithsameconsecdiff;


/**
 * Added on 24/09/19
 * https://leetcode.com/problems/numbers-with-same-consecutive-differences/
 */
public class Solution {

    public int[] numsSameConsecDiff(int N, int K) {
        if (N < 2) {
            if (K == 0) {
                return new int[] {1,2,3,4,5,6,7,8,9};
            }
            return new int[0];
        }
        return new int[0];
    }
}
