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
        int less = A < B ? A : B;
        int combLength = A + B - 2;
        double maxCombsNum = Math.pow(2, combLength);
        int counter = 0;
        for (int iter = 1; iter <= maxCombsNum; ++iter) {
            String binString = Integer.toBinaryString(iter);
            if (containsPath(binString, less - 1)) {
                counter += 1;
            }
        }
        return counter;

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


}
