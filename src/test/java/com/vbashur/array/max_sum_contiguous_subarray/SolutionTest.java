package com.vbashur.array.max_sum_contiguous_subarray;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    Solution s = new Solution();

    @Test
    public void maxSubArray() {
        List<Integer> input = Arrays.asList( -2, 1, -3, 4, -1, 2, 1, -5, 4 );
        int res = s.maxSubArray( input );
        Assert.assertEquals( 6, res );
    }

    @Test
    public void maxSubArrayPositives() {
        List<Integer> input = Arrays.asList( 1, 2, 3, 4, 5, 6 );
        int res = s.maxSubArray( input );
        Assert.assertEquals( 21, res );
    }

    @Test
    public void maxSubArrayNegativeInMiddle() {
        List<Integer> input = Arrays.asList( 56, -451, -222, 80, -57, -85, -304, -108, 95, -377, -282, -260, -497, -471, -97, -350, -147, 62, -447, -229, 78, -165, -333, -427, -59, -338, 60, -207, -247, -431, -54, -240, -426, -123, -209, 57, -74, -287, -70, -292, 45, -278, -408, -129, -35, 65, -77, -230, -426, 20, -402, -375, -449, -280, -125, -15, -21, -327, -366, 64, -211, -414, -307 );
        int res = s.maxSubArray( input );
        Assert.assertEquals( 95, res );
    }


    @Test
    public void maxSubArraySingleNegative() {
        List<Integer> input = Arrays.asList( -300 );
        int res = s.maxSubArray( input );
        Assert.assertEquals( -300, res );
    }
}