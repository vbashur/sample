package com.vbashur.math.palindrome_integer;

import javax.swing.text.MutableAttributeSet;

/**
 * Created by vic on 5/11/18.
 *
 * https://www.interviewbit.com/problems/palindrome-integer/
 *
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

        while (size > 0) {
            double base = Math.pow(10, size - 1);
            int digit = (int)(A / base);
            A = A - (int)(base * digit) - digit;
            --size;
        }

        return A;

    }
}
