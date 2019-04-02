package com.vbashur.dynamic.time_to_buy_stocks;

/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example :

Input : [1 2]
Return :  1
 */

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by vic on 4/2/19.
 * https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-i/
 */
public class Solution {

    public int maxProfit(final List<Integer> A) {
        if (A == null || A.size() < 2) return 0;

        // easily to reach without PQ storing min value in a variable
        PriorityQueue<Integer> minPQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            };

        });

        int maxProfit = 0;

        Iterator<Integer> iter = A.iterator();
        Integer firstItem = iter.next();
        minPQ.add(firstItem);
        while (iter.hasNext()) {
            Integer item = iter.next();
            Integer minItem = minPQ.peek();
            if (item - minItem <= 0) minPQ.add(item);
            if (item - minItem > maxProfit) maxProfit = item - minItem;
        }
        return maxProfit;

    }
}
