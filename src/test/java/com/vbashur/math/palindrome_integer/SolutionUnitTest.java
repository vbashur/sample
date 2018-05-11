package com.vbashur.math.palindrome_integer;

import com.vbashur.math.grid_unique_paths.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vic on 5/11/18.
 */
public class SolutionUnitTest {

    @Test
    public void testSimple() {
        Solution s = new Solution();
        Assert.assertEquals(0,s.isPalindrome(1000021));
        Assert.assertEquals(0,s.isPalindrome(10));
        Assert.assertEquals(1,s.isPalindrome(1221));
        Assert.assertEquals(1,s.isPalindrome(121));
        Assert.assertEquals(0,s.isPalindrome(123));
        Assert.assertEquals(0,s.isPalindrome(124));
        Assert.assertEquals(0,s.isPalindrome(1231));
        Assert.assertEquals(1,s.isPalindrome(1));
        Assert.assertEquals(1,s.isPalindrome(122221));
        Assert.assertEquals(1,s.isPalindrome(12221));
        Assert.assertEquals(1,s.isPalindrome(9998999));
        Assert.assertEquals(0,s.isPalindrome(9998799));

    }
}
