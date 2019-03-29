package com.vbashur.backtracking.stackboxes;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void getStackedBoxes() {

        Solution.Box b1 = new Solution.Box( 1, 2, 3 );
        Solution.Box b2 = new Solution.Box( 2, 3, 4 );
        Assert.assertTrue( b1.less( b2 ) );
    }

}