package com.vbashur.graph.numswithsameconsecdiff;


import java.util.*;

/**
 * Added on 24/09/19
 * https://leetcode.com/problems/numbers-with-same-consecutive-differences/
 */
public class Solution {

    public int[] numsSameConsecDiff(int N, int K) {
        int[] digits = new int[]{0,1, 2, 3, 4, 5, 6, 7, 8, 9};
        if (N < 2) {
            if (K == 0) {
                return digits;
            }
            return new int[0];
        }
        LinkedList<LinkedList<Integer>> queue = new LinkedList<>();
        for (int iter = 1; iter < 10; ++iter) {
            LinkedList<Integer> ll = new LinkedList<Integer>();
            ll.addLast(iter);
            queue.add(ll);
        }
        for (int i = 2; i <= N; i++) {
            Queue<LinkedList<Integer>> nq = new LinkedList<>();
            while (!queue.isEmpty()) {
                LinkedList<Integer> targetList = queue.poll();

                int numToAdd = targetList.peekLast() + K;
                if (numToAdd < 10) {
                    LinkedList<Integer> newList = new LinkedList<>();
                    newList.addAll(targetList);
                    newList.addLast(numToAdd);
                    nq.add(newList);
                }
                numToAdd = targetList.peekLast() - K;
                if (numToAdd >= 0) {

                    LinkedList<Integer> newList = new LinkedList<>();
                    newList.addAll(targetList);
                    newList.addLast(numToAdd);
                    nq.add(newList);
                }

            }
            queue.addAll(nq);
        }


        return getRes(queue, N);
    }

    private int[] getRes(LinkedList<LinkedList<Integer>> nums, int length) {
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
            }
            ++counter;
        }
        Set<Integer> s= new LinkedHashSet<>();
        for (int i = 0; i < res.length; ++i) {
            s.add(res[i]);
        }

        int[] arr= new int[s.size()];
        Iterator<Integer> iter = s.iterator();
        for (int i = 0 ; i < arr.length; ++i) {
            arr[i] = iter.next();
        }
        return arr;

    }
}
