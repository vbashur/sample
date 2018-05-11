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
//        Assert.assertEquals(3,s.isPalindrome(32));
//        Assert.assertEquals(0,s.isPalindrome(323));
//        Assert.assertEquals(0,s.isPalindrome(3223));
//
//        Assert.assertEquals(0,s.isPalindrome(256652));
//        Assert.assertEquals(0,s.isPalindrome(123));
        Assert.assertEquals(0,s.isPalindrome(121));
    }
}
