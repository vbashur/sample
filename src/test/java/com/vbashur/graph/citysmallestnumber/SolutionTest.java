package com.vbashur.graph.citysmallestnumber;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution s;

    @Test
    public void test() {
        s = new Solution();
        int[] arr1 = new int[] {0,1,3};
        int[] arr2 = new int[] {1,2,1};
        int[] arr3 = new int[] {1,3,4};
        int[] arr4 = new int[] {2,3,1};
        int[][] arr = new int[][]{arr1, arr2, arr3, arr4};
        System.out.println(">>>>>>>>>>>>>>>>>" + s.findTheCity(4, arr,4));
    }

}