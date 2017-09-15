package com.vbashur

import org.junit.{Assert, Test}

/**
  * Created by vic on 9/15/17.
  */
class S07_S_ContainsDuplicate2UnitTest {

  @Test
  def simpleTest = {

    Assert.assertTrue(S07_S_ContainsDuplicate2.containsNearbyDuplicate(Array(1,2,1), 2))
    Assert.assertFalse(S07_S_ContainsDuplicate2.containsNearbyDuplicate(Array(1,2,1), 1))

    Assert.assertFalse(S07_S_ContainsDuplicate2.containsNearbyDuplicate(Array(1,2,3,4,1,5,6,1), 1))
  }

}
