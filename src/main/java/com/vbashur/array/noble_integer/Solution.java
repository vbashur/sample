package com.vbashur.array.noble_integer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by vic on 4/24/18.
 * https://www.interviewbit.com/problems/noble-integer/?ref=dash-reco
 *
 * Given an integer array, find if an integer p exists in the array such that the number of integers
 * greater than p in the array equals to p
 * If such an integer is found return 1 else return -1.

 */
public class Solution {

    public int solve(ArrayList<Integer> A) {
        if (A==null || A.isEmpty()) {
            return -1;
        }
        Collections.sort(A);
        if (A.get(A.size() - 1) == 0) {
            return 1;
        }
        for (int iter = 0; iter < A.size() - 1; ++iter) {
            if (A.get(iter) >= 0 && A.get(iter + 1) > A.get(iter) && A.get(iter) == A.size() - iter - 1) {
                return 1;
            }
        }
        return -1;
    }
}
