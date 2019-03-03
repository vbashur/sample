package com.vbashur.strings.atoi;

import com.vbashur.array.repeat_and_missing.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by vic on 3/3/19.
 */
public class SolutionTest {
    @Test
    public void atoi() throws Exception {
        Solution s = new Solution();
        String str =  "-1";
        Assert.assertEquals(-1, s.atoi(str));


        str =  "-1 ";
        Assert.assertEquals(-1, s.atoi(str));

        str =  "b28 ";
        Assert.assertEquals(0, s.atoi(str));

        str =  "b 28 ";
        Assert.assertEquals(28, s.atoi(str));

        str =  "+7 ";
        Assert.assertEquals(7, s.atoi(str));

        for (int i = 0; i < 10; ++i)
        System.out.print((Integer.MAX_VALUE + i* Integer.MAX_VALUE) < Integer.MAX_VALUE);

    }

    @Test
    public void fetch() {
        Solution s = new Solution();
        String str =  "-1";
        Assert.assertEquals(Arrays.asList("-","1"), s.fetchNum(str));
        str =  "-1bn";
        Assert.assertEquals(Arrays.asList("+"), s.fetchNum(str));
        str =  "bh 28";
        Assert.assertEquals(Arrays.asList("+", "2", "8"), s.fetchNum(str));
        str =  "bh -28 ";
        Assert.assertEquals(Arrays.asList("-", "2", "8"), s.fetchNum(str));
        str =  "+1";
        Assert.assertEquals(Arrays.asList("+","1"), s.fetchNum(str));
        str =  "- 28 ";
        Assert.assertEquals(Arrays.asList("+", "2", "8"), s.fetchNum(str));
    }

}