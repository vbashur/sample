package com.vbashur.hashing.window_string;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minWindow("ADOBECODEBANC", "ABC"));

    }

    public String minWindow(String A, String B) {
        if (A.length() < 2) {
            return B.equals(A) ? A : "";
        }
        Map<String, Integer> window = new HashMap<>();
        for (int iter = 0; iter < B.length(); ++iter) {
            String symb = B.substring(iter, iter + 1);
            if (window.containsKey(symb)) {
                int counter = window.get(symb);
                window.put(symb, counter + 1);
            } else {
                window.put(symb, Integer.valueOf(1));
            }
        }
        int c1 = 0,c2 = 0;

        int minWindowSize = Integer.MAX_VALUE;
        String res = "";
        while (c1 < (A.length() - 1)) {
            String symb = A.substring(c1, c1 + 1);
            if (window.containsKey(symb)) {
                if (B.length() == 1) {
                    return B;
                }
                int counter = window.get(symb);
                window.put(symb, counter - 1);
                if (c2 == 0) c2 = c1 + 1;
                while (getSum(window) > 0 && c2 < A.length()) {
                    String s = A.substring(c2, c2 + 1);
                    if (window.containsKey(s)) {
                        counter = window.get(s);
                        window.put(s, counter - 1);
                    }
                    ++c2;
                }
                if (getSum(window) == 0) {
                    int curLength = c2 - c1;
                    if (curLength < minWindowSize) {
                        minWindowSize = curLength;
                        res = A.substring(c1, c2);
                    }
                }
                counter = window.get(symb);
                window.put(symb, counter + 1);
            }
            ++c1;
        }
        return res;
    }

    private int getSum(Map<String, Integer> window) {
        for (String s : window.keySet()) {
            if (window.get(s) > 0) {
                return 1;
            }
        }
        return 0;
    }
}
