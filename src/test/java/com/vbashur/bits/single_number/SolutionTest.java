package com.vbashur.bits.single_number;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void singleNumber() {
        Solution s = new Solution();
        Assert.assertEquals( 3, s.singleNumber( Arrays.asList( 1, 2, 3, 2, 1 ) ) );
        Assert.assertEquals( 2, s.singleNumber( Arrays.asList( 1, 2, 3, 3, 1 ) ) );
        Assert.assertEquals( 1, s.singleNumber( Arrays.asList( 2, 3, 3, 2, 1 ) ) );
    }
}