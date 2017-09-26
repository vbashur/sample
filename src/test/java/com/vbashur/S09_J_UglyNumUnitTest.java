package com.vbashur;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by victor.bashurov on 26.09.2017.
 */
public class S09_J_UglyNumUnitTest {

    @Test
    public void simpleTest() {
        S09_J_UglyNum solution = new S09_J_UglyNum();
        Assert.assertTrue(solution.isUgly(4));
        Assert.assertTrue(solution.isUgly(6));
        Assert.assertFalse(solution.isUgly(14));
    }

}
