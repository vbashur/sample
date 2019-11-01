package com.vbashur.firstmissingint;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void firstMissingPositive() {
        ArrayList<Integer> input = new ArrayList<>();
        input.addAll(Arrays.asList(-3,-4,-1,-1));
        System.out.println(new Solution().firstMissingPositive(input));
    }
}