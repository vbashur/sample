package com.vbashur.graph.numswithsameconsecdiff;


import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Added on 24/09/19
 * https://leetcode.com/problems/numbers-with-same-consecutive-differences/
 */
public class Solution {

    public int[] numsSameConsecDiff(int N, int K) {
        int[] digits = new int[] {1,2,3,4,5,6,7,8,9};
        if (N < 2) {
            if (K == 0) {
                return digits;
            }
            return new int[0];
        }
        List<int[]> nums = new LinkedList<>();
        for (int i = 0; i < digits.length; ++i) {
            int newNum = K - i;
            if (newNum >= 0) {
                int[] arr = new int[]{i, K-i};
                System.out.print(arr[0]);
                System.out.println(arr[1]);
                nums.add(new int[]{i, K-i});
            }
        }

        return getRes(nums, N);
    }

    private int[] getRes(List<int[]> nums, int length) {
        int limit = (int)Math.pow(10, length) - 1;
        int[] res = new int[nums.size()];
        for (int i = 0; i < res.length; ++i) {
            res[i] = 0;
        }
        int counter = 1;
        while (counter <= length) {
            for (int i = 0 ; i < nums.size(); ++i) {
                int[] arr = nums.get(i);
                int curNum = (int)Math.pow(10, counter - 1) * arr[arr.length - counter];
                res[i] = res[i] + curNum;
                System.out.print(res[i]);
                System.out.println(":"+curNum);
            }
            ++counter;
        }
        return res;

    }
}
