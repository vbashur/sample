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
        words.push(s);
        boolean isFound = false;
        do {
            List<String> wordsToAdd = new LinkedList<>();
            while (!words.isEmpty()) {
                String w = words.pollFirst();
                if (isValid(w)) {
                    isFound = true;
                    res.add(w);
                } else if (!isFound) {
                    for (int iter = 0; iter < w.length(); ++iter) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(w.substring(0, iter));
                        sb.append(w.substring(iter + 1));
                        wordsToAdd.add(sb.toString());
                    }
                }
            }
            if (!isFound) {
                words.addAll(wordsToAdd);
            }
        } while (!words.isEmpty());
        return new LinkedList<>(res);
    }

    private List<String> getWordsToCheck(List<String> input) {
        return input;
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
