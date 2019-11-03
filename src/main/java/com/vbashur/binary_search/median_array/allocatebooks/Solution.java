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
        for (int i = 0; i <A.size(); ++i) {
            best = Math.min(best, findBest(B - 1, i, new int[B], A, best));

        }
        return best;

    }

    private int findBest(int step, int index, int[] data, ArrayList<Integer> input, int best) {
        data[data.length - step - 1] = index;
        if (step == 0) {
            best = Math.min(best, findMaxPartition(data, input));
            for (int datum : data) {
                System.out.print(datum +  " ");
            }
            System.out.println();
        } else {
            while(index + 1  < input.size()) {
                best = findBest(step - 1, ++index, data, input, best);

            }
        }
        return best;
    }

    private int findMaxPartition(int[] data, ArrayList<Integer> input) {
        int maxPartition = Integer.MIN_VALUE;
        int[] sums = new int[data.length + 2];

        for (int j = 0; j <= data[0]; ++j) {
            sums[0] += input.get(j);
        }

        for (int i = 1; i < data.length; ++i) {
            for (int j = data[i - 1]; j < data[i]; ++j) {
                sums[i] += input.get(j);
            }
        }

        for (int j = data[data.length - 1]; j < input.size(); ++j) {
            sums[sums.length - 1] += input.get(j);
        }

        for (int sum : sums) {
            if (sum > maxPartition) {
                maxPartition = sum;
            }
        }
        return maxPartition;
    }

}
