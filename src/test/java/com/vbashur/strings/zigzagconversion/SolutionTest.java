package com.vbashur.strings.zigzagconversion;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution s= new Solution();


    @Test
    public void convert() {
        String input = "PAYPALISHIRING";
        System.out.println(s.convert(input, 3));

    }
}