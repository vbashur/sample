package com.vbashur.math.grid_unique_paths;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vic on 5/9/18.
 */
public class SolutionUnitTest {

    @Test
    public void testSimple() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.uniquePaths(2,2));
        Assert.assertEquals(3, s.uniquePaths(3,2));
        Assert.assertEquals(6, s.uniquePaths(3,3));
        Assert.assertEquals(20058300, s.uniquePaths(14,15));
    }
}
