package com.vbashur.backtracking.stackboxes;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    Solution s = new Solution();
    @Test
    public void getStackedBoxes() {

        Solution.Box b1 = new Solution.Box( 1, 2, 3 );
        Solution.Box b2 = new Solution.Box( 2, 3, 4 );
        Assert.assertTrue( b1.less( b2 ) );

        int res = s.getStackedBoxes( Arrays.asList(b1, b2) );
        Assert.assertEquals( 2, res );
    }

    @Test
    public void getStackedBoxesComplex() {
        Solution.Box b1 = new Solution.Box( 1, 2, 3 );
        Solution.Box b2 = new Solution.Box( 2, 3, 4 );
        Solution.Box b3 = new Solution.Box( 5, 3, 4 );
        Solution.Box b4 = new Solution.Box( 4, 4, 7 );
        Solution.Box b5 = new Solution.Box( 3, 9, 2 );
        int res = s.getStackedBoxes( Arrays.asList(b1, b2, b3, b4, b5) );
        Assert.assertEquals( 2, res );
    }
}