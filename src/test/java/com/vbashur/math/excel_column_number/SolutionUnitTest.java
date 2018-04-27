package com.vbashur.math.excel_column_number;

import org.junit.Assert;
import org.junit.Test;

public class SolutionUnitTest {

    @Test
    public void testSimple() {
        Solution s = new Solution();
        Assert.assertEquals(27, s.titleToNumber("AA"));
        Assert.assertEquals(29, s.titleToNumber("AC"));
        Assert.assertEquals(1, s.titleToNumber("A"));
    }
}
