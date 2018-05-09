package com.vbashur

/**
  * Created by vic on 9/15/17.
  *
  * https://leetcode.com/submissions/detail/118895710/

  Given an array of integers and an integer k, find out whether there are two distinct indices i and j
  in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
  */
object S07_S_ContainsDuplicate2 {

  def containsNearbyDuplicate(nums: Array[Int], k: Int): Boolean = {
    var uniques = Set[Int]()
    nums.foldLeft(0)((i, num) => {
      if (uniques.contains(num)) return true
      uniques += num
      if (i - k > -1) uniques -= nums(i - k)
      i + 1;
    })
    false

  }

  def expr = {
    val x = {println("x"); 1}
    lazy val y = {println("y"); 2}
    def z = {println("z"); 3}
    z+y+x+z+y+x
  }
}
