package com.vbashur;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by victor.bashurov on 15.09.2017.
 *
 * https://leetcode.com/problems/contains-duplicate-ii/description/
 *

 Given an array of integers and an integer k,
 find out whether there are two distinct indices i and j in the array
 such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 */
public class S07_J_ContainsDuplicate2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> indiciesMap = new HashMap<Integer, List<Integer>>();
        for (int iter = 0; iter < nums.length; ++iter) {
            if (indiciesMap.containsKey(nums[iter])) {
                List<Integer> inds = indiciesMap.get(nums[iter]);
                if (inds.get(inds.size() -1) + k >= iter)
                for (Integer i : inds) {
                    Integer absDiff = Math.abs(iter - i);
                    if (absDiff == k) return true;
                }
                inds.add(iter);
            } else {
                List<Integer> indicies = new LinkedList<Integer>();
                indicies.add(iter);
                indiciesMap.put(nums[iter], indicies);
            }
        }
        return false;
    }
}
