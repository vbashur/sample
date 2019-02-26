package com.vbashur.greedy.highest_product;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void maxp3() {
        Solution s = new Solution();
        int res = s.maxp3( new ArrayList<>( Arrays.asList(-1, -1, -2, -3)) );
        Assert.assertEquals(-2, res);
        res = s.maxp3( new ArrayList<>( Arrays.asList(-50, -1, 0, 4)) );
        Assert.assertEquals(0, res);

        res = s.maxp3( new ArrayList<>( Arrays.asList(-5, -1, 0, 4, 3, 2)) );
        Assert.assertEquals(20, res);
    }
}