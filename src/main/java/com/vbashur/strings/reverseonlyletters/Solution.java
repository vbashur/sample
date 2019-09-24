package com.vbashur.strings.reverseonlyletters;

/**
 * created on 24/09/19
 * https://leetcode.com/problems/reverse-only-letters/
 */
public class Solution {

    public String reverseOnlyLetters(String S) {
        char[] cs = S.toCharArray();
        int left = 0;
        int right = cs.length - 1;
        while (left < right) {
            if (isLetter(cs[left])){
                if (isLetter(cs[right])){
                    swap(left, right, cs);
                    --right;
                    ++left;
                } else {
                    --right;
                }
            } else {
                ++left;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i =0; i < cs.length; ++i) {
            res.append(cs[i]);
        }
        return res.toString();
    }

    boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') ;
    }

    void swap(int l, int r, char[] cs) {
        char tmp = cs[l];
        cs[l] = cs[r];
        cs[r] = tmp;
    }
}
