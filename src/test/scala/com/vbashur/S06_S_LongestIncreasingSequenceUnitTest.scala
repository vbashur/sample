package com.vbashur

import org.junit.{Assert, Test}

/**
  * Created by victor.bashurov on 14.09.2017.
  */
class S06_S_LongestIncreasingSequenceUnitTest {

  @Test
  def simpleTest = {

    var sequence = Array[Int](9, 2, 6, 3, 7, 8)
    Assert.assertEquals(4, S06_S_LongestIncreasingSequence.lengthOfLIS(sequence))

    sequence = Array[Int](2, 5, 3, 7)
    Assert.assertEquals(3, S06_S_LongestIncreasingSequence.lengthOfLIS(sequence))

    sequence = Array[Int](10, 9, 2, 5, 3, 7, 101, 18)
    Assert.assertEquals(4, S06_S_LongestIncreasingSequence.lengthOfLIS(sequence))

  }

}
