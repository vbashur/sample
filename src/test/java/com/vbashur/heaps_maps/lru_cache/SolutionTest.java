package com.vbashur.heaps_maps.lru_cache;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    Solution s;

    @Test
    public void testSingle() {
        s = new Solution( 1 );

        s.set( 2, 1 );
        s.set( 2, 2 );
        Assert.assertEquals(2,  s.get( 2 ) );
        s.set( 1, 1 );
        s.set( 4, 1 );
        Assert.assertEquals(-1,  s.get( 2 ) );


    }

    @Test
    public void testtriple() {
        s = new Solution( 3 );

        s.set( 2, 1 );
        s.set( 2, 2 );
        s.set( 3, 2 );
        Assert.assertEquals(2,  s.get( 2 ) );
        s.set( 1, 1 );
        s.set( 4, 1 );
        Assert.assertEquals(-1,  s.get( 2 ) );
        s.set( 5, 1 );
        Assert.assertEquals(-1,  s.get( 3 ) );

    }

    /*
    7 2 G 2 S 2 6 G 1 S 1 5 S 1 2 G 1 G 2

    Your function returned the following :
-1 -1 2 -1
The expected returned value :
-1 -1 2 6
     */


    @Test
    public void testProd() {
        s = new Solution( 7 );
        Assert.assertEquals(-1,  s.get( 2 ) );
        s.set( 2, 6 );
        Assert.assertEquals(-1,  s.get( 1 ) );
        s.set( 1, 5 );
        s.set( 1, 2 );
        Assert.assertEquals(2,  s.get( 1 ) );
        Assert.assertEquals(6,  s.get( 2 ) );
    }

    @Test
    public void testProd2() {
        s = new Solution( 2 );
        Assert.assertEquals(-1,  s.get( 2 ) );
        s.set( 2, 6 );
        Assert.assertEquals(-1,  s.get( 1 ) );
        s.set( 1, 5 );
        s.set( 1, 2 );
        Assert.assertEquals(2,  s.get( 1 ) );
        Assert.assertEquals(6,  s.get( 2 ) );
    }
}