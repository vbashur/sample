package com.vbashur.heaps_maps.top_k_frequent;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution s = new Solution();

    @Test
    public void test() {
        int[] arr = new int[] {1,1,1,1,1,5,5,5,5,5,5,4,8,8,9};
        List<Integer> kFrequent = s.topKFrequent(arr, 2);
        System.out.println(kFrequent);
    }

}