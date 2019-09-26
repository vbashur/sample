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
        int[] digits = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        if (N < 2) {
            if (K == 0) {
                return digits;
            }
            return new int[0];
        }
        // OMG https://leetcode.com/problems/numbers-with-same-consecutive-differences/discuss/370543/Java-Using-Queue
        List<LinkedList<Integer>> nums = new LinkedList<>();
        for (int min = 9; min >= 0; --min) {
            if (min - K >= 0) {

                LinkedList<Integer> combs = new LinkedList<>();
                if (min - K > 0) {
                    combs.add(min - K);
                    combs.add(min);
                    nums.add(combs);
                    System.out.println("->" + combs);
                    combs.clear();
                }
                combs.add(min);
                combs.add(min - K);
                nums.add(combs);
                System.out.println("->" + combs);

            }
        }
//        for (int i = 1; i < 10; ++i) {
//            int numToAdd = i + K;
//            if (i + K < 10) {
//                LinkedList<Integer> combs = new LinkedList<>();
//                combs.add(i);
//                combs.add(K - i);
//                nums.add(combs);
//            }
//            if ()
//        }
        int counter = 3;
        while (counter <= N) {
            for (int i = 0; i < nums.size(); ++i) {
                LinkedList<Integer> targetList = nums.get(i);
                int numToAdd = targetList.peekLast() + K;
                boolean firstDetected = false;
                if (numToAdd < 10) {
                    targetList.addLast(numToAdd);
                }
                numToAdd = targetList.peekLast() - K;
                if (numToAdd >= 0) {
                    targetList.addLast(numToAdd);
                }

                System.out.println("->" + targetList);
            }
            ++counter;
        }
        return getRes(nums, N);
    }

    private int[] getRes(List<LinkedList<Integer>> nums, int length) {
//        int limit = (int) Math.pow(10, length) - 1;
        int[] res = new int[nums.size()];
        for (int i = 0; i < res.length; ++i) {
            res[i] = 0;
        }
        int counter = 1;
        while (counter <= length) {
            for (int i = 0; i < nums.size(); ++i) {
                List<Integer> arr = nums.get(i);
                int curNum = (int) Math.pow(10, counter - 1) * arr.get(arr.size() - counter);
                res[i] = res[i] + curNum;
//                System.out.print(res[i]);
//                System.out.println(":"+curNum);
            }
            ++counter;
        }
        return res;

    }
}
