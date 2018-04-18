package com.vbashur.array.max_non_negative;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vic on 4/18/18.
 * https://www.interviewbit.com/problems/max-non-negative-subarray/?ref=dash-reco
 */
public class Solution {

    private static final Integer START_INDEX_DEFAULT_VALUE = -1;

    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
            long maxSum = 0;
            long maxSeq = 0;
            ArrayList<Integer> res = new ArrayList<>();
            long seq = 0, sum = 0;
            int index = -1;
            for (int iter = 0; iter < A.size(); ++iter) {
                int curVal = A.get(iter);
                if (isNonNegative(curVal)) {
                    if (!isNonNegative(index)) {
                        index = iter;
                    }
                    sum += curVal;
                    seq +=1;
                } else {
                    if (sum > maxSum) {
                        res.clear();
                        res.addAll(A.subList(index, iter));
                        maxSum = sum;
                    }
                    if (sum == maxSum && sum >= 0) {
                        if (seq > maxSeq) {
                            res.clear();
                            res.addAll(A.subList(index, iter));
                            maxSeq = seq;
                        }
                    }
                    sum = 0;
                    index = -1;
                    seq = 0;
                }
            }
            if (sum > maxSum) {
                res.clear();
                res.addAll(A.subList(index, A.size()));
                maxSum = sum;
            }
            if (sum == maxSum && sum >= 0) {
                if (seq > maxSeq) {
                    res.clear();
                    res.addAll(A.subList(index, A.size()));
                }
            }
            return res;

        }

        private static boolean isNonNegative(long num) {
            return num > -1;
        }

}
