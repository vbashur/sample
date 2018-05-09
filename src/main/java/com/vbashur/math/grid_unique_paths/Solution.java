package com.vbashur.math.grid_unique_paths;

/**
 * Created by vic on 5/9/18.
 *
 * https://www.interviewbit.com/problems/grid-unique-paths/
 *
 */
public class Solution {

    public int uniquePaths(int A, int B) {
        if (A == 0 || B == 0) return 0;
        if (A == 1 || B == 1) return 1;
        int less = (A < B ? A : B) - 1;
        int combLength = A + B - 2;
//        double maxCombsNum = Math.pow(2, combLength);
//        int counter = 0;
//
//        for (int iter = 1; iter <= maxCombsNum; ++iter) {
//            if (containsPath(iter, less)) {
//                counter += 1;
//            }
//        }
        long c = getFactBound(combLength, combLength - less + 1);
        long b = getFactBound(less,1);
        return (int)(c/b);
//        return (int)(getFact(combLength) / (getFact(less) * getFact(combLength - less)));

    }

    private static boolean containsPath(String path, int pathCount) {
        int counter = 0;
        for (int iter = 0; iter < path.length(); ++iter) {
            if (path.charAt(iter) == '1') {
                ++counter;
            }
            if (counter > pathCount) {
                return false;
            }
        }
        return counter == pathCount;
    }

    private static boolean containsPath(Integer num, int pathCount) {
        int counter = 0;
        while (num != 0 && counter <= pathCount) {
            if ((num & 1) == 1) {
                ++counter;
            }
            num = num >> 1;

        }
        return counter == pathCount;
    }

    private static long getFact(int num) {
        if (num == 1) return 1;
        else return num * getFact(num - 1);
    }

    private static long getFactBound(int num, int bound) {
        if (num == bound) return bound;
        else return num * getFactBound(num - 1, bound);
    }


}
