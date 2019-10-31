package com.vbashur.array.mergeoverlapintervals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void merge() {
        Solution.Interval i1 = new Solution.Interval(90,100);
        Solution.Interval i2 = new Solution.Interval(86,86);
        Solution.Interval i3 = new Solution.Interval(1,90);
        Solution.Interval i4 = new Solution.Interval(5,97);
        Solution s  = new Solution();
        s.merge(new ArrayList<>(Arrays.asList(i1, i2, i3, i4)));

    }
}
