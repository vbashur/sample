package com.vbashur.backtracking.stackboxes;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by vic on 3/31/19.
 */
public class Solution2Test {

    Solution2 s = new Solution2();

    @Test
    public void getStackedBoxesDinaTest() {
        Solution2.Box matches = new Solution2.Box("matches", 5, 2, 1 );
        Solution2.Box microwave = new Solution2.Box("microwave", 50, 40, 30 );
        Solution2.Box tv = new Solution2.Box("tv", 150, 20, 100 );
        Solution2.Box ski = new Solution2.Box("ski", 300, 40, 20 );
        Solution2.Box ipad = new Solution2.Box("ipad", 30, 20, 1 );
        int res = s.getStackedBoxes(new Solution2.Box[]{ipad, ski, matches, tv, microwave} );
        Assert.assertEquals( 2, res );
    }

    @Test
    public void getStackedBoxesDina2Test() {
        Solution2.Box matches = new Solution2.Box("matches", 5, 2, 1 );
        Solution2.Box microwave = new Solution2.Box("microwave", 50, 40, 30 );
        Solution2.Box owen = new Solution2.Box("owen", 51, 41, 31 );
        Solution2.Box tv = new Solution2.Box("tv", 150, 20, 100 );
        Solution2.Box ski = new Solution2.Box("ski", 300, 40, 20 );
        Solution2.Box ipad = new Solution2.Box("ipad", 30, 20, 1 );
        int res = s.getStackedBoxes( new Solution2.Box[]{ipad, ski, owen, matches, tv, microwave} );
        Assert.assertEquals( 2, res );
    }

}