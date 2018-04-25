package com.vbashur.array.repeat_and_missing;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by vic on 4/25/18.
 */
public class SolutionUnitTest {

    @Test
    public void test() {
        List<Integer> list = Arrays.asList(1,1,3,4);
        Solution s = new Solution();
        s.gcd(48, 24);
        Assert.assertEquals(Long.valueOf(24), s.gcd(24, 48));
        Assert.assertEquals(Long.valueOf(24), s.gcd(48, 24));
        Assert.assertEquals(1, s.repeatedNumber(list));
    }
}
