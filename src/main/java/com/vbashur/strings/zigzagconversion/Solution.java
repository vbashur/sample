package com.vbashur.strings.zigzagconversion;

import java.util.LinkedList;
import java.util.List;

/*
Created by vic on 22/08/19.
https://leetcode.com/problems/zigzag-conversion/solution/
 */
public class Solution {

    public String convert(String s, int numRows) {
        int iter = 0;
        List<String[]> res = new LinkedList<>();
        while (iter < s.length()) {
            res.add(writeCol(iter, s, numRows));
            iter += numRows;
            for (int j = numRows - 1; j > 1 && iter < s.length(); --j) {
                res.add(writeDiag(j - 1, s, iter, numRows));
                ++iter;
            }
        }
        return getRes(res, numRows);

    }

    String[] writeCol(int iter, String s, int numRows) {
        String[] r = new String[numRows];
        int j = 0;
        for (int i = iter; i < s.length() && i < iter + numRows; ++i) {
            String ss = String.valueOf(s.charAt(i));
            r[j] = ss;
            ++j;
        }
        return r;

    }

    String[] writeDiag(int index, String s, int iter, int numRows) {
        String[] r = new String[numRows];
        if (iter < s.length()) {
            String ss = String.valueOf(s.charAt(iter));
            r[index] = ss;
        }
        return r;
    }

    String getRes(List<String[]> res, int numRows) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; ++i) {
            for (String[] list : res) {
                if (list[i] != null) {
                    sb.append(list[i]);
                }

            }
        }
        return sb.toString();

    }
}
