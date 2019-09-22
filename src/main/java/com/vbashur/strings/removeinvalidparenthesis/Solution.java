package com.vbashur.strings.removeinvalidparenthesis;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
Created by vic on 22/09/19.
https://leetcode.com/problems/remove-invalid-parentheses/

 */
public class Solution {

    public List<String> removeInvalidParentheses(String s) {
        return Collections.emptyList();

    }

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int iter = 0; iter < s.length(); ++iter) {
            char curChar = s.charAt(iter);
            if (curChar == '(') {
                stack.push(Character.valueOf(curChar));
            } else if (curChar == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
