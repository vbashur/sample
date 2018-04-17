package com.vbashur.array.ib_array_multiply

/**
  * Created by vic on 4/17/18.
  */
class Solution {

  def solve(A: Array[Int], B: Array[Int]): Array[Int]  = {

    println(A.zip(B) map { case (ax, by) => ax  +  by })
    A
  }

}
