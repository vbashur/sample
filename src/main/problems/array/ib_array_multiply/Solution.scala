package array.ib_array_multiply

/**
  * Created by vic on 4/17/18.
  */
object Solution {

  def solve(A: Array[Int], B: Array[Int]): Array[Int]  = {

//    A.zip(B) map { case (ax, by) => ax  +  by } foreach(println)
    A.flatMap(ai => (B.map(bj => bj + ai ))).sorted (Ordering[Int].reverse) take (A.size) foreach(print)

    A
  }

}

