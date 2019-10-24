package com.vbashur.strings.substrconcatenation;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {


    @Test
    public void testSolution() {
        Solution s  = new Solution();

        List<Integer> res = s.findSubstring("wordgoodgoodgoodbestword", new String[] {"word","good","best","good"});
        res = s.findSubstring("a", new String[] {"a"});

        System.out.println(res);
    }

}