package com.vbashur.bits.hamming_weight;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void hammingWeight() {
        Solution s  = new Solution();
        Assert.assertEquals(s.hammingWeight( 11 ), 3);
        Assert.assertEquals(s.hammingWeight( 15 ), 4);
        Assert.assertEquals(s.hammingWeight( 31 ), 5);
        Assert.assertEquals(s.hammingWeight( 32 ), 1);
//        Assert.assertEquals(s.hammingWeight( 4294967293), 31);
    }

    @Test
    public void hammingWeight2() {
        Solution s  = new Solution();
        System.out.print( 7 & 1 );
        Assert.assertEquals(s.hammingWeight2( 15 ), 4);
        Assert.assertEquals(s.hammingWeight2( 11 ), 3);
        Assert.assertEquals(s.hammingWeight2( 31 ), 5);
        Assert.assertEquals(s.hammingWeight2( 32 ), 1);

    }
}