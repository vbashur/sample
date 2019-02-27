package com.vbashur.bits.single_number_2;


import java.util.List;

/*
Given an array of integers, every element appears thrice except for one which occurs once.

Find that element which does not appear thrice.

Note: Your algorithm should have a linear runtime complexity.

Could you implement it without using extra memory?

Example :

Input : [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
Output : 4

 */

/**
 * Created by vic on 27/02/19.
 * <p>
 * https://www.interviewbit.com/problems/single-number-ii/
 */
/*
The algorithm comes from
https://www.quora.com/Given-an-integer-array-such-that-every-element-occurs-3-times-except-one-element-which-occurs-only-once-how-do-I-find-that-single-element-in-O-1-space-and-O-n-time-complexity

DOESN'T WORK!!
 */
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int singleNumber( final List<Integer> A ) {
        if( A == null || A.size() < 1 ) {
            return 0;
        }
        String accu = Integer.toBinaryString( A.get( 0 ) );
        for( int iter = 1; iter < A.size(); ++iter ) {
            String target = Integer.toBinaryString( A.get( iter ) );
            if( accu.length() > target.length() ) {
                target = normalizeString( target, accu.length() );
            } else if( accu.length() < target.length() ) {
                accu = normalizeString( accu, target.length() );
            }
            StringBuilder thenewAccu = new StringBuilder();
            for( int i = 0; i < accu.length(); ++i ) {
                int a = Character.digit( accu.charAt( i ), 10 );
                int b = Character.digit( target.charAt( i ), 10 );
                int c = a + b > 9 ? a + b % 3 : a + b;
                thenewAccu.append( c );
            }
            accu = thenewAccu.toString();
        }
        int res = 0;
        for( int i = 0; i < accu.length(); ++i ) {
            int a = Character.digit( accu.charAt( i ), 10 ) % 3;
            res += a * Math.pow( 2, accu.length() - 1 - i );
        }
        return res;
    }

    public String normalizeString( String normalizedString, int length ) {
        StringBuilder sb = new StringBuilder();
        for( int iter = 0; iter < length - normalizedString.length(); ++iter ) {
            sb.append( '0' );
        }
        return sb.append( normalizedString ).toString();

    }
}
