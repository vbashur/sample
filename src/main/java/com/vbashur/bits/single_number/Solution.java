package com.vbashur.bits.single_number;

import java.util.List;

/*


Given an array of integers, every element appears twice except for one. Find that single one.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example :

Input : [1 2 2 3 1]
Output : 3
 */

/**
 * Created by vic on 27/02/19.
 * <p>
 * https://www.interviewbit.com/problems/single-number/
 */
public class Solution {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int singleNumber( final List<Integer> A ) {
        if( A == null || A.size() < 1 ) {
            return 0;
        }
        Integer res = A.get( 0 );
        for( int iter = 1; iter < A.size(); ++iter ) {
            res = res ^ A.get( iter );
        }
        return res;
    }
}
