package com.vbashur.strings.generate_parenthesis;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by vic on 25/07/19.
 * https://leetcode.com/problems/generate-parentheses/solution/
 */
public class Solution {

    public List<String> generateParenthesis(int n) {

        int lo = 0, hi = 0;
        int iter = 1;
        while (iter <= n) {
            lo = hi + 1;
            hi = lo + 1;
            ++iter;
        }
        List<Integer> numericResults = new LinkedList<>();
        int lowBound =  Double.valueOf(Math.pow(2, lo)).intValue();
        for (int i = lowBound; i < Math.pow(2, hi); ++i) {
            int counter = 0;
            int iterStr = 0;
            String binaryString =Integer.toBinaryString(i);
            while (counter >= 0 && iterStr < binaryString.length()) {
                if (binaryString.charAt(iterStr) == '0') {
                    --counter;
                } else {
                    ++counter;
                }
                ++iterStr;
            }
            if (counter == 0) {
                numericResults.add(i);
            }
        }
        return convertToStringRes(numericResults);
    }

    public List<String> convertToStringRes(List<Integer> numericResults) {
        List<String> stringResults = new LinkedList<>();

        for (Integer num : numericResults) {
            String binaryString =Integer.toBinaryString(num);
            StringBuilder sb = new StringBuilder();
            for(int i =0; i < binaryString.length(); ++i) {
                if (binaryString.charAt(i) == '1') {
                    sb.append("(");
                } else {
                    sb.append(")");
                }
            }
            stringResults.add(sb.toString());
        }

        return stringResults;
    }
}
