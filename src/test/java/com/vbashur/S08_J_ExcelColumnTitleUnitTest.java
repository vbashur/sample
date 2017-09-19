package com.vbashur;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by victor.bashurov on 19.09.2017.
 */
public class S08_J_ExcelColumnTitleUnitTest {

    @Test
    public void simpleTest() {
        S08_J_ExcelColumnTitle solution = new S08_J_ExcelColumnTitle();
        Assert.assertEquals("I", solution.convertToTitle(9));
        Assert.assertEquals("Z", solution.convertToTitle(26));
        Assert.assertEquals("AA", solution.convertToTitle(27));
        Assert.assertEquals("AB", solution.convertToTitle(28));
    }
}
