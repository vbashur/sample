package com.vbashur.math.gcd;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vic on 2/16/19.
 */
public class SolutionTest {

    Solution s = new Solution();


    @Test
    public void test() {
        int res = s.gcd(8, 4);
        Assert.assertEquals(4, res);
        res = s.gcd( 4, 8);
        Assert.assertEquals(4, res);

        res = s.gcd( 4, 1);
        Assert.assertEquals(1, res);

        res = s.gcd( 1, 4);
        Assert.assertEquals(1, res);

        res = s.gcdMutant( 4, 8);
        Assert.assertEquals(4, res);

        res = s.gcdMutant( 4, 0);
        Assert.assertEquals(4, res);


        res = s.gcdMutant( 0, 4);
        Assert.assertEquals(4, res);


        res = s.gcdMutant( 4, 41);
        Assert.assertEquals(1, res);

        res = s.gcdMutant( 39, 41);
        Assert.assertEquals(1, res);

        res = s.gcdMutant( 2, 4);
        Assert.assertEquals(2, res);

        res = s.gcdMutant( 4, 40);
        Assert.assertEquals(4, res);
    }

}