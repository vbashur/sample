package com.vbashur.math.power_of_two_integers;

/**
 * Created by vic on 4/30/18.
 *
 * https://www.interviewbit.com/problems/power-of-two-integers/
 *
 * Given a positive integer which fits in a 32 bit signed integer, find if it can be expressed as A^P where P > 1 and A > 0. A and P both should be integers.

 Example

 Input : 4
 Output : True
 as 2^2 = 4.
 */
public class Solution {

    public int isPower(int A) {
        double sqrt = Math.sqrt(A);
        if (sqrt * sqrt == A) return 1;
        return 0;
    }
}
