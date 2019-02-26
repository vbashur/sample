package com.vbashur.greedy.highest_product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*



Given an array of integers, return the highest product possible by multiplying 3 numbers from the array

Input:

array of integers e.g {1, 2, 3}

    NOTE: Solution will fit in a 32-bit signed integer

Example:

[0, -1, 3, 100, 70, 50]

=> 70*50*100 = 350000


 */

/**
 *
 * Created by vic on 26/02/19.
 * <p>
 * https://www.interviewbit.com/problems/highest-product/
 */
public class Solution {

    public int maxp3( ArrayList<Integer> A ) {
        // Collections.sort( A );
        // int res = 1;
        // int iter = 1;
        // while (iter < 4) {
        //     res *= A.get( A.size() - iter );
        //     ++iter;
        // }
        // return res;
        Collections.sort( A);
        int n = A.size();
        int mxProduct = A.get(n-1) * A.get(n-2) * A.get(n-3);
        int mxProduct2 = A.get(n-1) * A.get(0) * A.get(1);
        return mxProduct > mxProduct2 ? mxProduct : mxProduct2;
    }
}
