package com.vbashur.array.findduplicate;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void repeatedNumber() {

        Solution s = new Solution();
        System.out.println(s.repeatedNumber(Arrays.asList(3,4,1,1,4)));
    }
}
