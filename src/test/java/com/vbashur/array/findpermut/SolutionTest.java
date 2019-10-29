package com.vbashur.array.findpermut;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void findPerm() {
        Solution s = new Solution();
        System.out.println(s.findPerm("DDII", 5));
        System.out.println(s.findPerm("DIDI", 5));
    }
}
