package com.vbashur.sorting.largest_num;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    Solution s = new Solution();

    @Test
    public void largestNumber() {
        int[] nums = new int[] {3,30,34,5,9};
        Assert.assertEquals("9534330",s.largestNumber2( nums ));
    }

    @Test
    public void largestNumber2() {
        int[] nums = new int[] {128,12};
        Assert.assertEquals("12812",s.largestNumber2( nums ));
    }

    @Test
    public void largestNumber3() {
        int[] nums = new int[] {128,12, 1};
        Assert.assertEquals("128121",s.largestNumber2( nums ));
    }

    @Test
    public void largestNumber4() {
        int[] nums = new int[] {999999998,999999997,999999999};
        Assert.assertEquals("999999999999999998999999997", s.largestNumber2( nums ));
    }

    @Test
    public void largestNumber5() {
        int[] nums = new int[] {0,0,0};
        Assert.assertEquals("0", s.largestNumber2( nums ));
    }

    @Test
    public void getLength() {
        Assert.assertEquals( 1, s.getLength( 3 ));
        Assert.assertEquals( 2, s.getLength( 10 ));
        Assert.assertEquals( 3, s.getLength( 100 ));
        Assert.assertEquals( 6, s.getLength( 986543 ));
    }
}