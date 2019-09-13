package com.vbashur.math.reverseinteger;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void reverse() {
        Solution s  = new Solution();
        assertEquals(87, s.reverse(78));
        assertEquals(1, s.reverse(100));
        assertEquals(1, s.reverse(1000));
        assertEquals(201, s.reverse(102));
    }
}
