package com.vbashur.array.insert_interval;

/**
 * Created by vic on 4/1/19.
 * <p>
 * https://leetcode.com/problems/insert-interval/
 */

import com.vbashur.common.Interval;

import java.util.*;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.isEmpty() || newInterval == null) return intervals;
        Integer[] intervalsArr = initIntervalList(intervals, newInterval);

        int start = newInterval.start;
        int end = newInterval.end;
        if (intervalsArr[start] > 0) {
            int index = start;
            do {
                intervalsArr[index] = intervalsArr[start];
                ++index;
            } while (index < end);
        }
        if (intervalsArr[end] > 0) {
            int index = end;
            do {
                intervalsArr[index] = intervalsArr[start];
                ++index;
            } while (index < intervalsArr.length && intervalsArr[index] != 0);
        } else {
            intervalsArr[end] = intervalsArr[start];
        }
        List<Interval> resIntervals = getIntervals(intervalsArr);
        return resIntervals;
    }

    private Integer[] initIntervalList(List<Interval> ints, Interval newInterval) {
        int bound = Math.max(ints.get(ints.size() - 1).end, newInterval.end) + 1;
        Integer[] intervalArr = new Integer[bound];
        Arrays.fill(intervalArr, 0);

        int index = newInterval.start;
        do {
            intervalArr[index] = newInterval.start * (-1);
            ++index;
        } while (index <= newInterval.end);

        for (Interval interval : ints) {
            index = interval.start;
            do {
                intervalArr[index] = interval.start;
                ++index;
            } while (index <= interval.end);
        }
        return intervalArr;
    }

    private List<Interval> getIntervals(Integer[] intsArr) {
        List<Interval> intervalList = new LinkedList<>();
        for (int iter = 1; iter < intsArr.length; ++iter) {
            if (!intsArr[iter].equals(Integer.valueOf(0))) {
                int start = intsArr[iter];
                while (iter < intsArr.length
                        && !intsArr[iter].equals(Integer.valueOf(0))
                        && intsArr[iter].equals(start)) {
                    ++iter;
                }
                int end = iter - 1;
                Interval newInterval = new Interval(Math.abs(start), Math.abs(end));
                intervalList.add(newInterval);
            }
        }
        return intervalList;
    }
}
