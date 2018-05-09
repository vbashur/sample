package com.vbashur.math.grid_unique_paths;

import com.vbashur.math.excel_column_number.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vic on 5/9/18.
 */
public class SolutionUnitTest {

    @Test
    public void testSimple() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.uniquePaths(3,2));
        Assert.assertEquals(6, s.uniquePaths(3,3));
    }
}
