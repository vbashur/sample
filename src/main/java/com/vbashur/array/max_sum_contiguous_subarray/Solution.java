package com.vbashur.array.max_sum_contiguous_subarray;

import java.util.Iterator;
import java.util.List;

/*
 * Created by vic on 15/4/19.
 * https://www.interviewbit.com/problems/max-sum-contiguous-subarray/

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example:

Given the array [-2,1,-3,4,-1,2,1,-5,4],

the contiguous subarray [4,-1,2,1] has the largest sum = 6.

For this problem, return the maximum sum.

 */
public class Solution {

    public int maxSubArray(final List<Integer> A) {
        if (A.size() == 0) return 0;
        Iterator<Integer> iter = A.iterator();
        int max = iter.next();
        int currSum = max;
        while(iter.hasNext()) {
            int current = iter.next();
            currSum = Math.max( currSum + current, current );
            max = Math.max( currSum, max );
        }
        return max;
    }
}
