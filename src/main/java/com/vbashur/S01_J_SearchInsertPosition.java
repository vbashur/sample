package com.vbashur;

/**
 * Created by victor.bashurov on 11.09.2017.
 *
 * https://leetcode.com/problems/search-insert-position/description/
 *
 Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0
 */

public class S01_J_SearchInsertPosition {


    public int searchInsert(int[] nums, int target) {
        for (int iter = 0; iter < nums.length; ++iter) {
            if (target == nums[iter]) {
                return iter;
            }
            if (target > nums[iter] && iter + 1 < nums.length && target < nums[iter + 1]) {
                return iter + 1;
            }
            if (target > nums[iter] && iter + 1 == nums.length) {
                return nums.length;
            }
        }
        return 0;
    }

}
