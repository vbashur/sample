package com.vbashur

import org.junit.{Assert, Test}

/**
  * Created by victor.bashurov on 13.09.2017.
  */
class S04_S_RotateArrayUnitTest {

  @Test
  def simpleTest = {

    var arr = Array(1,2,3,4);
    S04_S_RotateArray.rotate(arr, 0)
    Assert.assertEquals(1, arr(0))
    Assert.assertEquals(2, arr(1))
    Assert.assertEquals(3, arr(2))
    Assert.assertEquals(4, arr(3))

    S04_S_RotateArray.rotate(arr, 3)
    Assert.assertEquals(2, arr(0))
    Assert.assertEquals(3, arr(1))
    Assert.assertEquals(4, arr(2))
    Assert.assertEquals(1, arr(3))

    arr = Array(1,2,3,4, 5);
    S04_S_RotateArray.rotate(arr, 2)
    Assert.assertEquals(4, arr(0))
    Assert.assertEquals(5, arr(1))
    Assert.assertEquals(1, arr(2))
    Assert.assertEquals(2, arr(3))
    Assert.assertEquals(3, arr(4))

    arr = Array(1);
    S04_S_RotateArray.rotate(arr, 1)
    Assert.assertEquals(1, arr(0))

    arr = Array(1, 2);
    S04_S_RotateArray.rotate(arr, 3)
    Assert.assertEquals(2, arr(0))
    Assert.assertEquals(1, arr(1))

    arr = Array(1, 2);
    S04_S_RotateArray.rotate(arr, 4)
    Assert.assertEquals(1, arr(0))
    Assert.assertEquals(2, arr(1))

  }

}
