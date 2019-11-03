package com.vbashur.binary_search.squareroot;

public class Solution {

    public int sqrt(int a) {
        if (a == 0) return 0;
        if (a < 4) return 1;
        return binarySearch(0, a, a);

    }

    private int binarySearch(int start, int end, int target) {
        int mid = (start + end) / 2;
        int sqres = mid * mid;
        int sqres2 = (mid + 1) * (mid +1);
        while (sqres != target && !(sqres < target && sqres2 > target)) {
            if (sqres > target) {
                end = mid;
            } else {
                start = mid;
            }
            mid = (start + end) / 2;
            sqres = mid * mid;
            sqres2 = (mid + 1) * (mid +1);
        }
        return mid;
    }
}
