package com.vbashur.graph.largest_distance;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {


    Solution s  = new Solution();

    @Test
    public void solveSimple() {
        ArrayList<Integer> arr = new ArrayList<>(  );
        arr.addAll( Arrays.asList(-1, 0, 0, 0, 3) );
        Assert.assertEquals( s.solve( arr ), 3 );

        arr.clear();
        arr.addAll( Arrays.asList(-1, 0, 0, 0, 3, 4) );
        Assert.assertEquals( s.solve( arr ), 4 );
    }
}