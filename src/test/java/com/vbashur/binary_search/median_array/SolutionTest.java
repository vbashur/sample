package com.vbashur.binary_search.median_array;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void findMedianSortedArrays() {
        Solution s = new Solution();
        List<Integer> a = Arrays.asList();
        List<Integer> b = Arrays.asList(20);
        Assert.assertEquals(Double.valueOf(20), Double.valueOf(s.findMedianSortedArrays( a, b )));


        a = Arrays.asList(1,2,3);
        b = Arrays.asList(4,5);
        Assert.assertEquals(Double.valueOf(3), Double.valueOf(s.findMedianSortedArrays( a, b )));

        a = Arrays.asList(0,23);
        b = Arrays.asList();
        Assert.assertEquals(Double.valueOf(11.5), Double.valueOf(s.findMedianSortedArrays( a, b )));
    }
}