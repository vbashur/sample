package com.vbashur.hashing.points_straight_line;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {


    Solution s = new Solution();

    @Test
    public void testAngle() {
        int y2 = 9;
        int x2 = 0;
        int y1 = -1;
        int x1 = 0;
        Double rad = s.angleOf( y2, y1, x2, x1 );
        Assert.assertEquals( Double.valueOf( 90d ), rad );

        y2 = -1;
        x2 = -1;
        y1 = 1;
        x1 = 1;
        rad = s.angleOf( y2, y1, x2, x1 );
        Assert.assertEquals( Double.valueOf( 45d ), rad );

        y2 = 1;
        x2 = 1;
        y1 = -1;
        x1 = -1;
        rad = s.angleOf( y2, y1, x2, x1 );
        Assert.assertEquals( Double.valueOf( 45d ), rad );
    }

    @Test
    public void testTwoPoints() {
        int y2 = 9;
        int x2 = 0;
        int y1 = -1;
        int x1 = 0;
        ArrayList<Integer> xs = new ArrayList<>();
        xs.add( x1 );
        xs.add( x2 );

        ArrayList<Integer> ys = new ArrayList<>();
        ys.add( y1 );
        ys.add( y2 );
        int actualMax = s.maxPoints( xs, ys );
        Assert.assertEquals( 2, actualMax );

    }

    @Test
    public void testMorePoints() {

        int y4 = 3;
        int x4 = 3;

        int y3 = 0;
        int x3 = 3;

        int y2 = -1;
        int x2 = -1;

        int y1 = 1;
        int x1 = 1;
        ArrayList<Integer> xs = new ArrayList<>();
        xs.add( x1 );
        xs.add( x2 );
        xs.add( x3 );
        xs.add( x4 );

        ArrayList<Integer> ys = new ArrayList<>();
        ys.add( y1 );
        ys.add( y2 );
        ys.add( y3 );
        ys.add( y4 );

        int actualMax = s.maxPoints( xs, ys );
        Assert.assertEquals( 3, actualMax );

    }

}