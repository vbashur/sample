package com.vbashur.dynamic.permutation;


import java.util.HashSet;
import java.util.Set;

/**
 * Created by vic on 12/2/20    .
 *https://leetcode.com/problems/permutation-in-string/
 */
public class Solution {


    public static void main(String[] args) {
        Solution s  = new Solution();
        boolean inclusion = s.checkInclusion("bol", "abaloss");
        System.out.println("args = " + inclusion);

    }

    public boolean checkInclusion(String s1, String s2) {

        Set<String> perms = getPermutations(s1);
        int windowSize = s1.length();
        for (int iter = 0; iter + windowSize - 1 < s2.length(); ++iter) {
            String window = s2.substring(iter, iter + windowSize);
            if (perms.contains(window)) {
                return true;
            }
        }
        return false;

    }

    Set<String> getPermutations(String s) {
        Set<String> resSet = new HashSet<>();
        for (int iter = 0; iter < s.length(); ++iter) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(iter, iter+1));
            getPerms(iter,sb, s, resSet);

        }
        return resSet;
    }

    private void getPerms(int index, StringBuilder sb, String s, Set<String> res) {
        String truncatedString = removeAt(index, s);
        if (truncatedString.isEmpty()) {
            res.add(sb.toString());
        } else {
            for (int iter = 0; iter < truncatedString.length(); ++iter) {
                StringBuilder sbNew = new StringBuilder(sb.toString());
                sbNew.append(truncatedString.substring(iter, iter+1));
                getPerms(iter, sbNew, truncatedString, res);
            }
        }
    }

    private String removeAt(int index, String s) {
        StringBuilder build = new StringBuilder(s);
        build.deleteCharAt(index);
        return build.toString();
    }
}
