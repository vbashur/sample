package com.vbashur.graph.numswithsameconsecdiff;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void numsSameConsecDiff() {
        Solution s = new Solution();
        int[] arr = s.numsSameConsecDiff(3, 2);
        System.out.println("__");
        for (int i =0; i < arr.length; ++i) {
            System.out.println(arr[i]);
        }
//
//        Stream.of(s.numsSameConsecDiff(2, 7)).forEach(System.out::println);
    }
}
