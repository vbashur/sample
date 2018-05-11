package com.vbashur.math.palindrome_integer;

/**
 * Created by vic on 5/11/18.
 * <p>
 * https://www.interviewbit.com/problems/palindrome-integer/
 */
public class Solution {

    public int isPalindrome(int A) {

        if (A == 0) return 1;
        int size = 0;
        int degree = 0;
        while (Math.pow(10, degree) <= A) {
            ++size;
            ++degree;
        }

        while (size > 0 && A > 9) {
            double base = Math.pow(10, size - 1);
            int digitFirst = (int) (A / base);
            int digitLast = A % 10;
            if (digitFirst != digitLast) {
                return 0;
            }
            A -= (digitFirst * base + digitLast);
            A = A / 10;
            size -= 2;
        }
        return 1;

    }
}
