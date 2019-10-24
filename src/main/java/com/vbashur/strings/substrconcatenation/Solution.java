package com.vbashur.strings.substrconcatenation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * added on 24/10/19
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 *
 */
public class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList<>();
        if (s == null || s.isEmpty() || words.length == 0) {
            return res;
        }
        int wordLength = words[0].length();
        int wholeWordLength = wordLength * words.length;
        List<String> wSet = new LinkedList<>();
        wSet.addAll(Arrays.asList(words));
        for (int iter = 0; iter < s.length() - wordLength; ++iter) {
            String word = s.substring(iter, wordLength);
            if (wSet.contains(word)) {
                int index = iter;
                while(index >= 0 && !wSet.isEmpty()) {
                    wSet.remove(word);
                    if (wSet.isEmpty()) {
                        res.add(index);
                    }


                }
            }

        }
    }
}
