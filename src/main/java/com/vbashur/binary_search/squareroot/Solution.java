package com.vbashur.binary_search.squareroot;

// https://www.interviewbit.com/problems/square-root-of-integer/
public class Solution {

    public int sqrt(int a) {
        if (a == 0) return 0;
        if (a < 4) return 1;
        if (a < 9) return 2;
        return binarySearch(0, a/2, a);

    }

    private int binarySearch(int start, int end, int a) {
        int mid = (start + end) / 2;
        while ((mid != a / mid)
                && !(mid < (a / mid)
                    && (mid + 1) > (a / (mid + 1)))) {
            if (mid > a / mid) {
                end = mid;
            } else {
                start = mid;
            }
            mid = (start + end) / 2;
        }
        return mid;
    }
}
