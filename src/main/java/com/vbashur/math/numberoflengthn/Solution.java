package com.vbashur.math.numberoflengthn;

import java.util.ArrayList;

/*
 added on 12/09/19
 numbers-of-length-n-and-value-less-than-k interviewbit: https://www.interviewbit.com/problems/numbers-of-length-n-and-value-less-than-k/
 */
public class Solution {

    public int solve(ArrayList<Integer> A, int B, int C) {
        int res = 0;

        for (int iter = 0; iter < A.size(); ++iter) {
            int basis = 0;
            int inputBasisUpperBound = (int) Math.pow(10, B);
            int inputBasisLowerBound = ((int) Math.pow(10, B - 1)) - 1;
            if (inputBasisLowerBound == 0) inputBasisLowerBound -= 1;
            int num = A.get(iter);
            while (num < C && num < inputBasisUpperBound && basis < B) {
                if (num > inputBasisLowerBound) {
                    res += 1;
                }
                for (int i = 0; i < A.size(); ++i) {
                    num = getNum(A.get(i) , basis  + 1, A.get(iter));
                    int resNumb = makeNumber(A, B, C, num, inputBasisUpperBound, inputBasisLowerBound, basis + 1);
                    res += resNumb;
                }
            }
        }
        return res;
    }

    public int makeNumber(ArrayList<Integer> A, int B, int C, int num, int inputBasisUpperBound, int inputBasisLowerBound, int basis) {
        while (num < C && num < inputBasisUpperBound && basis < B) {
            if (num > inputBasisLowerBound) {
                return 1;
            }
            for (int i = 0; i < A.size(); ++i) {
                int newNum = A.get(i) * (int) Math.pow(10, basis) + num;
                return makeNumber(A, B, C, newNum, inputBasisUpperBound, inputBasisLowerBound, basis + 1);
            }

        }
        return 0;
    }

    private int getNum (int curNum, int basis, int num) {
        return curNum * (int) Math.pow(10, basis) + num;
    }

}
