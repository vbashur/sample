package com.vbashur.strings.maxnumbaloons;

import java.util.*;

/*
https://leetcode.com/problems/maximum-number-of-balloons/
 */
class Solution {

    public int maxNumberOfBalloons(String text)
    {
        int[] map = new int[26];
        for (int i = 0; i < text.length(); ++i)
        {
            map[text.charAt(i) - 'a']++;
        }

        String balon = "balon";
        int textLength = text.length();
        for (char c : balon.toCharArray())
        {
            if (c == 'l' || c == 'o') {
                textLength = Math.min(textLength, map[c - 'a'] / 2);
            }
            else {
                textLength = Math.min(textLength, map[c - 'a']);
            }
        }
        return textLength;
    }


    /*
    public int maxNumberOfBalloons(String text) {

        Set<Character> baloon = new HashSet<>(Arrays.asList('b', 'a', 'l', 'o', 'n'));
        Map<Character, Integer> counters = new HashMap<>();
        for (Character sym : baloon) {
            counters.put(sym, Integer.valueOf(0));
        }

        int occurence = 0;
        for (int iter = 0; iter < text.length(); ++iter) {
            Character currentSymbol = Character.valueOf(text.charAt(iter));
            if (baloon.contains(Character.valueOf(text.charAt(iter)))) {
                int incr = 1;
                int counter = counters.get(currentSymbol);
                counters.put(currentSymbol, counter + incr);
                ++occurence;
            }
        }
        int targetSum = 7;
        int resCounter = 0;

        while (occurence > 0) {
            int sum = 0;
            for (Character sym : counters.keySet()) {
                Integer counterVal = counters.get(sym);
                int tmpDecr = 0;
                if (counters.get(sym) > 0) {
                    tmpDecr += 1;
                    if (sym.charValue() == 'o' || sym.charValue() == 'l') {
                        tmpDecr += 1;
                    }
                    int substr = counterVal  - tmpDecr;
                    counters.put(sym, substr);
                    if (substr >= 0) {
                        sum += tmpDecr;
                    }
                }
                --occurence;
            }
            if (sum == targetSum) {
                ++resCounter;
            }
        }
        return resCounter;
    }
    */

}
