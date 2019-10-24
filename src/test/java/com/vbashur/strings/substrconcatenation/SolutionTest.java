package com.vbashur.strings.substrconcatenation;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {


    @Test
    public void testSolution() {
        Solution s  = new Solution();

        List<Integer> res = s.findSubstring("barfoothefoobarman", new String[] {"bar", "foo"});

        System.out.println(res);
    }

}