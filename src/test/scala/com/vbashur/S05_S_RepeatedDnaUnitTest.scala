package com.vbashur

import org.junit.{Assert, Test}

/**
  * Created by victor.bashurov on 14.09.2017.
  */
class S05_S_RepeatedDnaUnitTest {

  @Test
  def simpleTest = {
    var dna = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
    var resList = S05_S_RepeatedDna.findRepeatedDnaSequences(dna)
    Assert.assertEquals(2, resList.size)
    Assert.assertTrue(resList.contains("AAAAACCCCC"))
    Assert.assertTrue(resList.contains("CCCCCAAAAA"))


  }

}
