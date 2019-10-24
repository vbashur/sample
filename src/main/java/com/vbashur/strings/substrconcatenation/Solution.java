package com.vbashur.strings.substrconcatenation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * added on 24/10/19
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 */
public class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList<>();
        if (s == null || s.isEmpty() || words.length == 0 || words[0].length() > s.length()) {
            return res;
        }
        int wordLength = words[0].length();
        List<String> wSet = new LinkedList<>();
        wSet.addAll(Arrays.asList(words));
        for (int iter = 0; iter <= (s.length() - wordLength); ++iter) {
            int index = iter;
            String word = s.substring(index, index + wordLength);
            while (index <= (s.length() - wordLength) && wSet.contains(word)) {
                wSet.remove(word);
                if (wSet.isEmpty()) {
                    res.add(iter);
                }
                index += wordLength;
                if (index + wordLength <= s.length()) {
                    word = s.substring(index, index + wordLength);
                }
            }
            if (wSet.size() != words.length) {
                wSet.clear();
                wSet.addAll(Arrays.asList(words));
            }
        }
        return res;
    }
}
