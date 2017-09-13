package com.vbashur

/**
  * Created by victor.bashurov on 13.09.2017.
  *
  *
https://leetcode.com/problems/rotate-array/description/

Rotate an array of n elements to the right by k steps.
For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
  */
object S04_S_RotateArray {

  def rotate(nums: Array[Int], k: Int): Unit = {

    if (nums.length < 2 || (k % nums.length) == 0) return nums
    reverse(nums, 0, nums.length - 1)
    reverse(nums, 0, (k % nums.length)  - 1)
    reverse(nums, (k % nums.length), nums.length - 1)
  }

  def reverse(nums: Array[Int], start: Int, end : Int): Unit = {
    if (start < end) {
      swap(nums, start, end)
      reverse(nums, start + 1, end - 1)
    }
  }

  def swap(nums: Array[Int], i1: Int, i2: Int): Unit = {
    val tmp = nums(i1);
    nums(i1) = nums(i2)
    nums(i2) = tmp
  }

}
