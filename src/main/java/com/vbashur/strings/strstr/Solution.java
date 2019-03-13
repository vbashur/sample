package com.vbashur.strings.strstr;

/*
 strstr - locate a substring ( needle ) in a string ( haystack ).
 */
/**
 * Created by vic on 3/13/19.
 * https://www.interviewbit.com/problems/implement-strstr/
 */
public class Solution {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int strStr(final String A, final String B) {
        String line = A;
        String word = B;
        if (line.length() == 0 || word.length() == 0 || word.length() > line.length()) {
            return -1;
        }

        for (int iter = 0; iter < A.length() - B.length() + 1; ++iter) {
            if (A.charAt(iter) == B.charAt(0)
                    && A.charAt(iter + B.length() - 1) == B.charAt(B.length() - 1)) {
                String subString = A.substring(iter, iter + B.length());
                if (B.equals(subString)) {
                    return iter;
                }
            }
        }
        return -1;
    }

}
