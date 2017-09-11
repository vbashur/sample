package com.vbashur

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

object S01_S_SearchInsertPosition {

  def searchInsert(nums: Array[Int], target: Int): Int = {
    var i = 0
    while (i < nums.length) {
//      println("i=" + i + " : target=" + target + " : arr=" + nums(i) + " : expression=" + (nums(i) == target))
      if (nums(i) == target) return i
      if (nums(i) < target && i + 1 < nums.length && target < nums(i + 1)) return i + 1
      if (nums(i) < target && i + 1 == nums.length) return nums.length
      i += 1
    }
    0
  }

}
