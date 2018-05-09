package com.vbashur.math.excel_column_number;

import java.util.HashMap;
import java.util.Map;

/*
https://www.interviewbit.com/problems/excel-column-number/

Given a column title as appears in an Excel sheet, return its corresponding column number.

Example:

    A -> 1

    B -> 2

    C -> 3

    ...

    Z -> 26

    AA -> 27

    AB -> 28



 */
public class Solution {

    public int titleToNumber(String A) {
        if (A == null || A.length() == 0) return 0;
        String titles = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int base = titles.length();
        Map<String, Integer> titleMap = new HashMap<>();
        for (int iter = 0; iter < titles.length(); ++iter) {
            titleMap.put(String.valueOf(titles.charAt(iter)), new Integer(iter + 1));
        }
        int res = 0;
        for (int iter = 0; iter < A.length(); ++iter) {
            double curBase = Math.pow(base, A.length() - iter - 1);
            int curValue = titleMap.get(String.valueOf(A.charAt(iter)));
            res += curBase * curValue;
        }
        return res;
    }
}
