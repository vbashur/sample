package com.vbashur.binary_search.median_array.allocatebooks;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/allocate-books/
// https://www.geeksforgeeks.org/painters-partition-problem/
public class Solution {

    public int books(ArrayList<Integer> A, int B) {
        if (B == 0 || A.size() == 0) {
            return -1;
        }
        if (A.size() == 1) {
            return A.get(0);
        }

        int best = Integer.MAX_VALUE;
        for (int i = 0; i <A.size() - B; ++i) {
            best = Math.min(best, findBest(B - 1, i, new int[B], A, best));

        }
        return best;

    }

    private int findBest(int step, int index, int[] data, ArrayList<Integer> input, int best) {
        data[data.length - step - 1] = index;
        if (step == 0) {
            best = Math.min(best, findMaxPartition(data, input));
        } else {
            while(index++  < input.size()) {
                best = findBest(step - 1, index, data, input, best);

            }
        }
        return best;
    }

    private int findMaxPartition(int[] data, ArrayList<Integer> input) {
        int maxPartition = Integer.MIN_VALUE;
        int[] sums = new int[data.length];

        for (int i = 1; i < data.length; ++i) {
            int sum = 0;
            for (int j = data[i - 1]; j < data[i]; ++j) {
                sum += input.get(j);
            }
            sums[i-1] = sum;
            if (i + 1 == data.length) {
                sum = 0;
                for (int j = data[i]; j < input.size(); ++j) {
                    sum += input.get(j);
                }
                sums[i] = sum;
            }
        }
        for (int sum : sums) {
            if (sum > maxPartition) {
                maxPartition = sum;
            }
        }
        return maxPartition;
    }

}
