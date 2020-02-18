package com.vbashur.graph.citysmallestnumber;

import java.util.*;


/*
18.02.2020
https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
 */
public class Solution {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, List<int[]>> citiesMap = getCitiesMap(edges);
        int resCityId = -1;
        int maxNumCities = Integer.MAX_VALUE;

        for (Integer city : citiesMap.keySet()) {
            int numReachableCities = getReachableCities(city, citiesMap, distanceThreshold);
            if (numReachableCities <= maxNumCities && numReachableCities > 0) {
                maxNumCities = numReachableCities;
                resCityId = city;
            }
        }
        return resCityId;

    }


    private Map<Integer, List<int[]>> getCitiesMap(int[][] edges) {
        Map<Integer, List<int[]>> citiesMap = new HashMap<>();
        for (int iter = 0; iter < edges.length; ++iter) {
            if (!citiesMap.containsKey(edges[iter][0])) {
                List<int[]> list = new LinkedList<int[]>();
                list.add(new int[]{edges[iter][1], edges[iter][2]});
                citiesMap.put(edges[iter][0], list);
            } else {
                citiesMap.get(edges[iter][0]).add(new int[]{edges[iter][1], edges[iter][2]});
            }

            if (!citiesMap.containsKey(edges[iter][1])) {
                List<int[]> list = new LinkedList<int[]>();
                list.add(new int[]{edges[iter][0], edges[iter][2]});
                citiesMap.put(edges[iter][1], list);
            } else {
                citiesMap.get(edges[iter][1]).add(new int[]{edges[iter][0], edges[iter][2]});
            }
        }
        return citiesMap;
    }

    private int getReachableCities(Integer city, Map<Integer, List<int[]>> citiesMap, int distanceThreshold) {
        List<int[]> dests = citiesMap.get(city);
        int num = 0;
        for (int[] dest : dests) {
            if (dest[1] <= distanceThreshold) {
                ++num;
                Set<Integer> markedCities = new HashSet<>();
                markedCities.add(city);
                markedCities.add(dest[1]);
                if (distanceThreshold - dest[1] > 0) {
                    num += helper(markedCities, dest[0], citiesMap, distanceThreshold - dest[1]);
                }
            }
        }
        return num;
    }

    private int helper(Set<Integer> markedCities, Integer source, Map<Integer, List<int[]>> citiesMap, int threshold) {
        int num = 0;
        for (int[] dest : citiesMap.get(source)) {
            if (!markedCities.contains(dest[0]) && dest[1] <= threshold) {
                ++num;
                markedCities.add(source);
                if (threshold - dest[1] > 0) {
                    num += helper(markedCities, dest[0], citiesMap, threshold - dest[1]);
                }
            }
        }
        return num;


    }


}
