package com.vbashur.binary_search.squareroot;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void sqrt() {
        Solution s = new Solution();
        System.out.println(s.sqrt(4));
        System.out.println(s.sqrt(12));
        System.out.println(s.sqrt(10000));
    }
}