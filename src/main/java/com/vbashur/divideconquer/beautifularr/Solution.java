package com.vbashur.divideconquer.beautifularr;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/beautiful-array/solution/
public class Solution {

    Map<Integer, int[]> memo;
    public int[] beautifulArray(int N) {
        memo = new HashMap();
        return f(N);
    }

    public int[] f(int N) {
        if (memo.containsKey(N))
            return memo.get(N);

        int[] ans = new int[N];
        if (N == 1) {
            ans[0] = 1;
        } else {
            int t = 0;
            for (int x: f((N+1)/2))  // odds
                ans[t++] = 2*x - 1;
            for (int x: f(N/2))  // evens
                ans[t++] = 2*x;
        }
        memo.put(N, ans);
        System.out.println("Printing memo for N=" + N);
        for (int i = 0; i <  memo.get(N).length; ++i) {
            System.out.print(">" + ans[i]);
        }
        System.out.println("");
        return ans;
    }
}
