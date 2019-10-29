package com.vbashur.array.findpermut;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.interviewbit.com/problems/find-permutation/
public class Solution {

    public ArrayList<Integer> findPerm(final String A, int B) {
        int min = 1;
        int max = B;
        ArrayList<Integer> res = new ArrayList<Integer>(B);
        for (int i = 0; i < A.length(); ++i) {
            String s = A.substring(i, i + 1);
            if (s.equals("D")) {
                res.add(i, max--);
            } else if (s.equals("I")) {
                res.add(i, min++);
            }
        }
        int lastAdded = A.substring(A.length() - 1).equals("D") ? max : min;
        res.add(lastAdded);
        return res;
    }
}
