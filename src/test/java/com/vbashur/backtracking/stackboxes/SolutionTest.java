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


    @Test
    public void getStackedBoxesDinaTest() {
        Solution.Box matches = new Solution.Box("matches", 5, 2, 1 );
        Solution.Box microwave = new Solution.Box("microwave", 50, 40, 30 );
        Solution.Box tv = new Solution.Box("tv", 150, 20, 100 );
        Solution.Box ski = new Solution.Box("ski", 300, 40, 20 );
        Solution.Box ipad = new Solution.Box("ipad", 30, 20, 1 );
        int res = s.getStackedBoxes( Arrays.asList(ipad, ski, matches, tv, microwave) );
        Assert.assertEquals( 2, res );
    }

    @Test
    public void getStackedBoxesDina2Test() {
        Solution.Box matches = new Solution.Box("matches", 5, 2, 1 );
        Solution.Box microwave = new Solution.Box("microwave", 50, 40, 30 );
        Solution.Box owen = new Solution.Box("owen", 51, 41, 31 );
        Solution.Box tv = new Solution.Box("tv", 150, 20, 100 );
        Solution.Box ski = new Solution.Box("ski", 300, 40, 20 );
        Solution.Box ipad = new Solution.Box("ipad", 30, 20, 1 );
        int res = s.getStackedBoxes( Arrays.asList(ipad, ski, owen, matches, tv, microwave) );
        Assert.assertEquals( 2, res );
    }
}