package com.vbashur

import org.junit.{Assert, Test}

/**
  * Created by victor.bashurov on 11.09.2017.
  */
class AppHelloWorldScalaUnitTest {

  @Test
  def simpleTest = {
    val app = AppHelloWorldScala.simpleTest
    Assert.assertEquals("scala", app)
    Assert.assertNotEquals("java", app)
  }

}
