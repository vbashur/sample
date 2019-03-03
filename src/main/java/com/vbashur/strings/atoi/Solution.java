package com.vbashur.strings.atoi;


/*
Implement atoi to convert a string to an integer.

Example :

Input : "9 2704"
Output : 9
 */

import java.util.LinkedList;
import java.util.List;

/**
 * Created by vic on 3/3/19.
 * https://www.interviewbit.com/problems/atoi/
 */
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int atoi(final String A) {
        List<String> numsList = fetchNum(A);
        if (numsList.size() < 2) return 0;
        boolean isNegative = numsList.get(0).equals("-");
        boolean isOverflow = false;
        int iter = 0; long res = 0;
        while (numsList.size() - iter - 1 > 0) {
            double base = Math.pow(10, iter);
            res += (base * Integer.valueOf(numsList.get(numsList.size() - iter - 1)));
            if (res > Integer.MAX_VALUE) {
                if (isNegative) return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }
            ++iter;
        }
        if(isNegative) {
            res *= -1;
        }
        return (int)res;

    }

    public List<String> fetchNum(String s) {
        LinkedList<String> numList = new LinkedList<>();
        int firstIndex = -1;
        for (int i = 0; i < s.length(); ++i) {
            Character ch = Character.valueOf(s.charAt(i));
            while (Character.isDigit(ch) && i < s.length() - 1) {
                numList.add(ch.toString());
                if (firstIndex < 0) firstIndex = i;
                i += 1;
                ch = Character.valueOf(s.charAt(i));
            }
            if (i == s.length() - 1 && Character.isDigit(ch)) {
                numList.add(ch.toString());
                if (firstIndex < 0) firstIndex = i;
            }
            if (!Character.isDigit(ch)) {
                if (!numList.isEmpty() && Character.isSpaceChar(ch.charValue())) {
                    break;
                } else {
                    numList.clear();
                    firstIndex = -1;
                    if (ch.charValue() != '-' && ch.charValue() != '+') {
                        while (i < s.length() - 1 && !Character.isSpaceChar(ch.charValue())) {
                            ++i;
                            ch = Character.valueOf(s.charAt(i));
                        }
                    }
                }
            }
        }
        if (firstIndex > 0 && s.charAt(firstIndex - 1) == '-') {
            numList.addFirst("-");
        } else {
            numList.addFirst("+");
        }
        return numList;
    }
}
