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
        Map<Integer, ArrayList<Integer>> subarrMap = new HashMap();
        Integer startIndex = START_INDEX_DEFAULT_VALUE;
        for (int iter = 0; iter < A.size(); ++iter) {
            if (isNonNegative(A.get(iter))) {
                if (startIndex == START_INDEX_DEFAULT_VALUE) {
                    startIndex = iter;
                }
            } else if (isNonNegative(startIndex)) {
                subarrMap.put(startIndex, new ArrayList<>(A.subList(startIndex, iter)));
                startIndex = START_INDEX_DEFAULT_VALUE;
            }
        }

        Map<Integer, Pair<Integer, Integer>> sumsSegentsMap = new HashMap<Integer, Pair<Integer, Integer>>();
        for (Integer ind : subarrMap.keySet()) {
            List<Integer> segment = subarrMap.get(ind);
            Pair<Integer, Integer> sumSegm = new Pair<Integer, Integer>(segment.stream().mapToInt(Integer::intValue).sum(),
                    segment.size());
            sumsSegentsMap.put(ind, sumSegm);
        }
        Integer MAX_SUM = Integer.MIN_VALUE;
        Integer MAX_LENGTH = Integer.MIN_VALUE;
        Integer MIN_INDEX = Integer.MAX_VALUE;
        for (Integer ind : sumsSegentsMap.keySet()) {
            Pair<Integer, Integer> sumSegm = sumsSegentsMap.get(ind);
            if (sumSegm.getKey() > MAX_SUM) {
                MAX_SUM = sumSegm.getKey();
                MAX_LENGTH = sumSegm.getValue();
                MIN_INDEX = ind;
            }
            if (sumSegm.getKey() == MAX_SUM) {
                if (sumSegm.getValue() > MAX_LENGTH) {
                    MAX_LENGTH = sumSegm.getValue();
                    MIN_INDEX = ind;
                }
                if (sumSegm.getValue() == MAX_LENGTH) {
                    if (ind < MIN_INDEX) {
                        MIN_INDEX = ind;
                    }
                }
            }
        }
        if (MIN_INDEX < Integer.MAX_VALUE) {
            return subarrMap.get(MIN_INDEX);
        } else {
            return null;
        }

    }

    private static boolean isNonNegative(int num) {
        return num > -1;
    }

}
