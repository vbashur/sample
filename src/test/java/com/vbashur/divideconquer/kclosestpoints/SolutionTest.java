package com.vbashur.divideconquer.kclosestpoints;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void kClosest() {
        int[][] input = new int[2][];
//        input[0] = new int[]{3,3};
//        input[1] = new int[]{5,-1};
//        input[2] = new int[]{-2,4};
//        input[3] = new int[]{16, 0};
        Solution s  = new Solution();
//        int[][] res = s.kClosest(input, 4);
//        for (int i = 0; i < res.length; ++i) {
//            System.out.println();
//            System.out.print(res[i][0] + " " + res[i][1]);
//        }

        input[0] = new int[]{1,3};
        input[1] = new int[]{-2,2};
        int[][] res = s.kClosest(input, 1);
        for (int i = 0; i < res.length; ++i) {
            System.out.println();
            System.out.print(res[i][0] + " " + res[i][1]);
        }

    }
}