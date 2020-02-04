package com.vbashur.heaps_maps.top_k_frequent;

import java.util.*;

public class Solution {

    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> numFreqMap = getNumFreqMap(nums);
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((e1,e2) -> e2.getValue() - e1.getValue());
        pq.addAll(numFreqMap.entrySet());
        List<Integer> resList = new LinkedList<>();
        int iter = 0;
        while (iter < k && !pq.isEmpty()) {
            resList.add(pq.poll().getKey());
            ++iter;
        }
        return resList;
    }

    private Map<Integer,Integer> getNumFreqMap(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int iter = 0; iter < nums.length; ++iter) {
            int key = nums[iter];
            if (freqMap.containsKey(key)) {
                int counter = freqMap.get(key) + 1;
                freqMap.put(key, counter);
            } else {
                freqMap.put(key, 0);
            }
        }
        return freqMap;
    }
}
