package com.vbashur.dynamic.shoppingoffers;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution s = new Solution();
    @Test
    public void shoppingOffers() {

        List<Integer> price = Arrays.asList(2,5);
        List<Integer> needs = Arrays.asList(3,2);
        List<Integer> offer1 = Arrays.asList(3,0,5);
        List<Integer> offer2 = Arrays.asList(1,2,10);
        List<List<Integer>> offers = Arrays.asList(offer1, offer2);

        System.out.println(s.shoppingOffers(price, offers, needs));


    }
}