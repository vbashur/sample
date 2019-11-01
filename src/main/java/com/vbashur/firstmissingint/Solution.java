package com.vbashur.firstmissingint;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/first-missing-integer/

public class Solution {

    public int firstMissingPositive(ArrayList<Integer> A) {
        int targetSum = 0;
        int positiveSum = 0;
        int negativesNum = 0;
        for (int i = 0; i < A.size(); ++i) {
            targetSum += (i + 1);
            if (A.get(i) > 0) {
                positiveSum += A.get(i);
            } else {
                ++negativesNum;
            }
        }

        int negativeDeductive = 0;
        for (int iter = 0; iter < (negativesNum - 1); ++iter) {
            negativeDeductive += (A.size() - iter);
        }
        return targetSum - positiveSum - negativeDeductive;
    }
}
