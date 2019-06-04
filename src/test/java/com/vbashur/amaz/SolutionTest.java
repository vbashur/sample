package com.vbashur.amaz;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution s  = new Solution();

    @Test
    public void IDsOfPackages() {
        int truckSpace = 190;
        ArrayList<Integer> packs = new ArrayList<>();
        packs.addAll(Arrays.asList(50, 100, 180, 190));
        ArrayList<Integer>  res = s.IDsOfPackages(truckSpace, packs);
        Assert.assertTrue(res.contains(0));
        Assert.assertTrue(res.contains(1));

        truckSpace = 110;
        packs.clear();
        packs.addAll(Arrays.asList(20, 70, 90, 30, 60, 110));
        res = s.IDsOfPackages(truckSpace, packs);
        System.out.println(res);
        Assert.assertTrue(res.contains(0));
        Assert.assertTrue(res.contains(4));


        truckSpace = 250;
        packs.clear();
        packs.addAll(Arrays.asList(100, 180, 40, 120, 10));
        res = s.IDsOfPackages(truckSpace, packs);
        System.out.println(res);
        Assert.assertTrue(res.contains(1));
        Assert.assertTrue(res.contains(2));

        truckSpace = 250;
        packs.clear();
        packs.addAll(Arrays.asList(100, 180, 40, 120, 10));
        res = s.IDsOfPackages(truckSpace, packs);
        System.out.println(res);
        Assert.assertTrue(res.contains(1));
        Assert.assertTrue(res.contains(2));

        truckSpace = 50;
        packs.clear();
        packs.addAll(Arrays.asList(100, 180, 40, 120, 10));
        res = s.IDsOfPackages(truckSpace, packs);
        System.out.println(res);
        Assert.assertTrue(res.contains(-1));
        Assert.assertTrue(res.contains(-1));

    }


    @Test
    public void removeObstacle() {

        List<List<Integer>> lot = Arrays.asList(Arrays.asList(1,0,0), Arrays.asList(1,0,0), Arrays.asList(1,9,1));
        Assert.assertEquals(3, s.removeObstacle(3,3,lot));

    }
}