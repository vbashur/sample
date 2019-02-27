package com.vbashur.bits.single_number_2;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;


public class SolutionTest {

    @Test
    public void singleNumber() {
        com.vbashur.bits.single_number_2.Solution s = new com.vbashur.bits.single_number_2.Solution();
        Assert.assertEquals( 3, s.singleNumber( Arrays.asList( 1, 2, 3, 2, 2, 1, 1 ) ) );
        Assert.assertEquals( 9, s.singleNumber( Arrays.asList( 5, 5, 4, 8, 4, 5, 8, 9, 4, 8 ) ) );
//        Assert.assertEquals( 2, s.singleNumber( Arrays.asList( 1, 2, 3, 3, 1 ) ) );
//        Assert.assertEquals( 1, s.singleNumber( Arrays.asList( 2, 3, 3, 2, 1 ) ) );
    }
}