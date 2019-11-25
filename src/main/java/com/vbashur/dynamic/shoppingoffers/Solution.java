package com.vbashur.dynamic.shoppingoffers;

import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/shopping-offers/
public class Solution {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int res = getCostWithoutDiscount(price, needs);
        for (List<Integer> offer : special) {
            List<Integer> delta = getDeltaAfterOffer(offer, needs);
            int minLocal = offer.get(2);
            if (isDeltaPositive(delta)) {
                res = Math.min( res, minLocal  + shoppingOffers(price, special, delta));
            }
        }
        return res;
    }

    private boolean isDeltaPositive(List<Integer> delta) {
        for (Integer val : delta) {
            if (val < 0) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> getDeltaAfterOffer(List<Integer> offer, List<Integer> needs) {
        List<Integer> delta = new LinkedList<>();
        for (int i = 0; i < needs.size(); i++) {
            delta.add(needs.get(i) - offer.get(i));
        }
        return delta;
    }

    private int getCostWithoutDiscount(List<Integer> price, List<Integer> needs) {
        int sum = 0;
        for (int i = 0; i < needs.size(); ++i) {
            sum += (needs.get(i) * price.get(i));
        }
        return sum;
    }
}
