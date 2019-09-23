package com.vbashur.strings.removeinvalidparenthesis;

import java.util.*;

/*
Created by vic on 22/09/19.
https://leetcode.com/problems/remove-invalid-parentheses/

 */
public class Solution {

    public List<String> removeInvalidParentheses(String s) {

        Deque<String> words = new LinkedList<>();
        Set<String> res = new HashSet<>();
        boolean isFound = false;
        words.addFirst(s);
        while(!words.isEmpty() && !isFound) {

            List<String> wordsToConsider = new LinkedList<>();
            for (String w: words) {
                if (isValid(w)) {
                    isFound = true;
                    res.add(w);
                }
            }
            if (!isFound) {
                while (!words.isEmpty()) {
                    String w = words.pollFirst();
                    for (int iter = 0; iter < w.length(); ++iter) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(w.substring(0, iter));
                        sb.append(w.substring(iter + 1));
                        wordsToConsider.add(sb.toString());
                    }
                }
                words.addAll(wordsToConsider);
            }
        }
        return new LinkedList<>(res);
    }




    public boolean isValid(String s) {
        int counter = 0;
        for (int iter = 0; iter < s.length(); ++iter) {
            char curChar = s.charAt(iter);
            if (curChar == '(') {
                ++counter;
            } else if (curChar == ')') {
                if (counter <= 0) {
                    return false;
                } else {
                    --counter;
                }
            }
        }
        return counter == 0;
    }
}
