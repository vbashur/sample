package com.vbashur.heaps_maps.distinct_nums;


/**


 You are given an array of N integers, A1, A2 ,…, AN and an integer K. Return the of count of distinct numbers in all windows of size K.

 Formally, return an array of size N-K+1 where i’th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,…, Ai+k-1.

 Note:

 If K > N, return empty array.

 For example,

 A=[1, 2, 1, 3, 4, 3] and K = 3

 All windows of size K are

 [1, 2, 1]
 [2, 1, 3]
 [1, 3, 4]
 [3, 4, 3]

 So, we return an array [2, 3, 3, 2].


 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by vic on 15/02/19.
 * <p>
 * https://www.interviewbit.com/problems/distinct-numbers-in-window/
 */
public class Solution {

    public ArrayList<Integer> dNums( ArrayList<Integer> A, int B) {

        int iter = 0;
        ArrayList<Integer> res = new ArrayList<>(  );
        while (iter + B <= A.size()) {
            int j = iter;
            Set<Integer> windowSet = new HashSet<>(  );
            while( j < iter + B ) {
                windowSet.add( A.get( j ) );
                ++j;
            }
            res.add( windowSet.size());
            ++iter;
        }
        return res;
    }
}
