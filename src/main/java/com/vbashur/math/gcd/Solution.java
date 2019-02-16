package com.vbashur.math.gcd;

/**
 * Created by vic on 16/2/19.
 *
 * https://www.interviewbit.com/problems/greatest-common-divisor/
 */
public class Solution {

    public int gcd(int A, int B) {
        if (A == B) return A;

        int first = A > B ? A : B;
        int second = A < B  ? A : B;
        if (second == 0) return first;
        int rest = first % second;
        if (rest == 0) return second;
        return gcd(second, rest);
    }

    public int gcdMutant(int A, int B) {
//        if (A == B) return A;
        if (B == 0) return A;
        return gcdMutant(B, A%B);
    }
}
