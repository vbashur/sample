package com.vbashur.graph.citysmallestnumber;

import java.util.*;


/*
18.02.2020
https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
 */
public class Solution {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, List<int[]>> citiesMap = getCitiesMap(edges, n);
        int resCityId = -1;
        int maxNumCities = Integer.MAX_VALUE;

        for (int city = 0; city < n; ++city) {
            int numReachableCities = getReachableCities(city, citiesMap, distanceThreshold, n);
            if (numReachableCities <= maxNumCities) {
                maxNumCities = numReachableCities;
                resCityId = city;
            }
        }
        return resCityId;

    }


    private Map<Integer, List<int[]>> getCitiesMap(int[][] edges, int n) {
        Map<Integer, List<int[]>> citiesMap = new HashMap<>();
        for (int iter = 0; iter < n; ++iter) {
            citiesMap.put(iter, new LinkedList<int[]>());
        }
        for (int iter = 0; iter < edges.length; ++iter) {
            citiesMap.get(edges[iter][0]).add(new int[]{edges[iter][1], edges[iter][2]});
            citiesMap.get(edges[iter][1]).add(new int[]{edges[iter][0], edges[iter][2]});
        }
        return citiesMap;
    }

    private int getReachableCities(Integer city, Map<Integer, List<int[]>> citiesMap, int distanceThreshold, int n) {
        Map<Integer, Integer> weights = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            if (i == city.intValue()) {
                weights.put(i, 0);
            } else {
                weights.put(i, Integer.MAX_VALUE);
            }
        }
        helper2(city, weights, citiesMap);
        int num = 0;
        for (Integer w : weights.values()) {
            if ( w <= distanceThreshold ) {
                ++num;
            }
        }
        return num;
    }

    private void helper2(Integer city, Map<Integer, Integer> weights, Map<Integer, List<int[]>> citiesMap) {
        List<int[]> dests = citiesMap.get(city);
        int cityWeight = weights.get(city);
        for (int[] d : dests) {
            int targetCity = d[0];
            int targetWeight = d[1];
            if (cityWeight + targetWeight < weights.get(targetCity)) {
                weights.put(targetCity, cityWeight + targetWeight);
                helper2(targetCity, weights, citiesMap);
            }
        }
    }
}
