package com.vbashur

/**
  * Created by victor.bashurov on 14.09.2017.
  */
object S06_S_LongestIncreasingSequence {

  def lengthOfLIS(nums: Array[Int]): Int = {
    val numsMap = getNumsMap(0,nums)
    val sortedNums = nums.sortBy(num => num)
    getLongest(numsMap, sortedNums)
  }

  def getNumsMap(index: Int, nums: Array[Int]) : Map[Int, Int] = {
    if (index < nums.length) {
      return getNumsMap(index + 1, nums) + (nums(index) -> index)
    }
    Map()
  }

  def getLongest(numsMap: Map[Int, Int], nums: Array[Int]) : Int = {
    var MAX = 0
    var tmpIndex = -1
    var tmpMax = 0
    for(n <- nums) {
      val index = numsMap(n)
      if (index > tmpIndex) {
        tmpMax += 1
        tmpIndex = index
      } else {
        if (tmpMax > MAX) {
          MAX = tmpMax
        }
        tmpIndex = -1
        tmpMax = 0
      }
    }
    MAX
  }

}
