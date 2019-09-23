package com.vbashur.strings.removeinvalidparenthesis;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void removeInvalidParentheses() {
        Solution s = new Solution();
        System.out.println(s.removeInvalidParentheses("()(((((((()"));
        System.out.println(s.removeInvalidParentheses("()())()"));
    }
}