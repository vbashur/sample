package com.vbashur;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by victor.bashurov on 11.09.2017.
 */
public class S02_J_RestoreIpUnitTest {

    @Test
    public void simpleTest() {
        S02_J_RestoreIp solution = new S02_J_RestoreIp();
        List<String> ips = solution.restoreIpAddresses("25525511135");
        Assert.assertEquals(2, ips.size());
        Assert.assertTrue(ips.contains("255.255.11.135"));
        Assert.assertTrue(ips.contains("255.255.111.35"));


        ips = solution.restoreIpAddresses("0000");
        Assert.assertEquals(1, ips.size());
        Assert.assertTrue(ips.contains("0.0.0.0"));

    }
}
