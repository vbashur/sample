package com.vbashur.stack_queue.evaluate_expression;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {

        ArrayList<String> A = new ArrayList<>(  Arrays.asList(  "2", "1", "+", "3", "*"));
        Solution s = new Solution();
        Assert.assertEquals(9, s.evalRPN( A ));

        A = new ArrayList<>(  Arrays.asList("4", "13", "5", "/", "+"));
        Assert.assertEquals(6, s.evalRPN( A ));



    }

}