package com.vbashur.bits.hamming_weight;


/*
Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).



Example 1:

Input: 00000000000000000000000000001011
Output: 3
Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.

Example 2:

Input: 00000000000000000000000010000000
Output: 1
Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.

Example 3:

Input: 11111111111111111111111111111101
Output: 31
Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 */

/**
 * Created by vic on 18/03/19.
 * <p>
 * https://leetcode.com/problems/number-of-1-bits/
 */
public class Solution {

    // you need to treat n as an unsigned value
    public int hammingWeight( int n ) {
        int counter = 0;
        if( n < 2 ) {
            return n % 2;
        } else {
            counter += n % 2;
            counter += hammingWeight( n / 2 );
        }
        return counter;
    }


    public int hammingWeight2( int n ) {
        int counter = 0;
        while( n > 0 ) {
            counter += (n & 1);
            n >>= 1;
        }
        return counter;
    }

    public int hammingWeightAcceptedNotMine( int n ) {
        int count = 0;
        while(n != 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }


}
