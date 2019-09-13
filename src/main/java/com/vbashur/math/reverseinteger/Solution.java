package com.vbashur.math.reverseinteger;


/*
https://www.interviewbit.com/problems/reverse-integer/
created on: 13/09/2019
 */

public class Solution {

    public int reverse(int A) {
        int basis = A < 0 ? -1 : 1;
        A = Math.abs(A);
        if (Math.abs(A) < 10) {
            return A;
        }
        int numorder = 1;
        int res = 0;
        int divider = (int) Math.pow(10, numorder);
        while (divider <= A) {
            divider = (int) Math.pow(10, numorder);
            System.out.println("A % divider: " + (A % divider));
            int resPlus = A % divider;
            res = (res * divider) + resPlus;
            A -= res;
            System.out.println("res:" +res);
            System.out.println("A:" +A);
            ++numorder;

        } ;
        return res * basis / (divider/10);
    }
}
