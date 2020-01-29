package com.vbashur.graph.network_delay_time;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/network-delay-time/
 */
public class Solution {

    /*

    There are N network nodes, labelled 1 to N.

    Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node,
    and w is the time it takes for a signal to travel from source to target.

    Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.



    Example 1:

    Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
    Output: 2

     */
    public int networkDelayTime(int[][] times, int N, int K) {

        Map<Integer, List<int[]>> graphMap = new HashMap<>();

        for (int iter = 0; iter < times.length; ++iter) {

            if (graphMap.containsKey(times[iter][0])) {
                graphMap.get(times[iter][0]).add(new int[]{times[iter][1], times[iter][2]});
            } else {
                List<int[]> list = new LinkedList();
                list.add(new int[]{times[iter][1], times[iter][2]});
                graphMap.put(times[iter][0], list);
            }

        }
        Map<Integer, Integer> routes = new HashMap<>();
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addFirst(K);
        routes.put(K, 0);
        while (!queue.isEmpty()) {
            int nodeId = queue.pollFirst();
            if (graphMap.containsKey(nodeId)) {
                for (int[] nodeRoute : graphMap.get(nodeId)) {
                    int key = nodeRoute[0];
                    int routeValue = nodeRoute[1] + routes.get(nodeId);
                    if (routes.containsKey(key)) {
                        int newRouteValue = routes.get(key) + routes.get(nodeId);
                        routes.put(key, Math.min(routeValue, newRouteValue));
                    } else {
                        routes.put(key, nodeRoute[1]);
                        queue.addLast(nodeRoute[0]);
                    }
                }
            }

        }
        if (routes.size() != N) {
            return -1;
        }
        int max = Integer.MIN_VALUE;
        for (Integer key : routes.keySet()) {
            max = Math.max(routes.get(key), max);
        }
        return max;


    }
}
