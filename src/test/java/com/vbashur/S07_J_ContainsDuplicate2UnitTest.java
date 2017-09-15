package com.vbashur;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by victor.bashurov on 15.09.2017.
 */
public class S07_J_ContainsDuplicate2UnitTest {

    @Test
    public void simpleTest() {
        int[] arr = {1,2,1};
        int k = 1;
        S07_J_ContainsDuplicate2 app = new S07_J_ContainsDuplicate2();
        Assert.assertFalse(app.containsNearbyDuplicate(arr, k));
    }
}
