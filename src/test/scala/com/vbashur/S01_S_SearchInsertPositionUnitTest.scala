package com.vbashur

import org.junit.{Assert, Test}

/**
  * Created by victor.bashurov on 11.09.2017.
  */
class S01_S_SearchInsertPositionUnitTest {



  @Test
  def simpleTest = {

    val arr = Array(1,3,5,6);
    Assert.assertEquals(2, S01_S_SearchInsertPosition.searchInsert(arr, 5))
    Assert.assertEquals(1, S01_S_SearchInsertPosition.searchInsert(arr, 2))
    Assert.assertEquals(4, S01_S_SearchInsertPosition.searchInsert(arr, 7))
    Assert.assertEquals(0, S01_S_SearchInsertPosition.searchInsert(arr, 0))

  }

}
