package com.vbashur.binary_search.median_array;

/*
There are two sorted arrays A and B of size m and n respectively.

Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

The overall run time complexity should be O(log (m+n)).

Sample Input

A : [1 4 5]
B : [2 3]

Sample Output

3

 */

import java.util.*;

/**
 * Created by vic on 4/3/19.
 * https://www.interviewbit.com/problems/median-of-array/
 */
public class Solution {

    // DO NOT MODIFY BOTH THE LISTS
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        return optimizedVersionOfAlgorithm(a, b);

    }

    public double optimizedVersionOfAlgorithm(final List<Integer> a, final List<Integer> b) {
        if (a == null || b == null) return 0.0;

        PriorityQueue<Integer> minPQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (-1) * o1.compareTo(o2);
            }
        });
        for (Integer aEntry : a) {
            if (maxPQ.size() > 0 && aEntry > maxPQ.peek()) {
                minPQ.add(aEntry);
            } else {
                maxPQ.add(aEntry);
            }
            repackQueues(minPQ, maxPQ);
        }
        for (Integer bEntry : b) {
            if (maxPQ.size() > 0 && bEntry > maxPQ.peek()) {
                minPQ.add(bEntry);
            } else {
                maxPQ.add(bEntry);
            }
            repackQueues(minPQ, maxPQ);
        }
        if (maxPQ.size() == minPQ.size()) {
            if (maxPQ.size() == 0) return 0.0;
            return Double.valueOf(maxPQ.peek() + minPQ.peek()) / 2;
        }
        if (maxPQ.size() > minPQ.size()) {
            return maxPQ.peek();
        } else {
            return minPQ.peek();
        }
    }

    private void repackQueues(PriorityQueue<Integer> minPQ, PriorityQueue<Integer> maxPQ) {
        if (maxPQ.size() - minPQ.size() >= 2) {
            Integer top = maxPQ.poll();
            minPQ.add(top);
        } else if (minPQ.size() - maxPQ.size() >= 2) {
            Integer top = minPQ.poll();
            maxPQ.add(top);
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> a = new LinkedList<>();
        for (int i = 0; i < nums1.length; ++i) {
            a.add(nums1[i]);
        }
        List<Integer> b = new LinkedList<>();
        for (int i = 0; i < nums2.length; ++i) {
            b.add(nums2[i]);
        }
        return optimizedVersionOfAlgorithm(a, b);

    }

    public double notOptimizedVersionOfAlgorithm(final List<Integer> a, final List<Integer> b) {
        List<Integer> mergedList = new ArrayList<>(a);
        mergedList.addAll(b);
        Collections.sort(mergedList);
        if (mergedList.size() == 0) {
            return 0;
        }
        if (mergedList.size() % 2 == 0) {
            int arg1 = mergedList.get(mergedList.size() / 2 - 1);
            int arg2 = mergedList.get(mergedList.size() / 2);
            return (arg1 + arg2) / 2;
        } else {
            return mergedList.get(mergedList.size() / 2);
        }
    }

    public double worstOptimizedVersionOfAlgorithm(final List<Integer> a, final List<Integer> b) {
        int size = a.size() + b.size();
        List<Integer> mergedList = new ArrayList<>();

        int iterMerged = 0, iterA = 0, iterB = 0;
        while (iterMerged < size) {
            if (iterA < a.size()) {
                if (iterB < b.size()) {
                    if (a.get(iterA) < b.get(iterB)) {
                        mergedList.add(a.get(iterA));
                        iterA++;
                    } else {
                        mergedList.add(b.get(iterB));
                        iterB++;
                    }
                } else {
                    mergedList.add(a.get(iterA));
                    iterA++;
                }
            } else if (iterB < b.size()) {
                mergedList.add(b.get(iterB));
                iterB++;
            }
            iterMerged++;
        }
        if (mergedList.size() % 2 == 0) {
            int arg1 = mergedList.get(mergedList.size() / 2 - 1);
            int arg2 = mergedList.get(mergedList.size() / 2);
            return ((double) (arg1 + arg2) / 2);
        } else {
            return (double) mergedList.get(mergedList.size() / 2);
        }
    }
}
