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
        if (intervals == null || intervals.isEmpty()) return Arrays.asList(newInterval);
        if (newInterval == null) return intervals;
        LinkedList<Interval> intervalList = new LinkedList<>();
        intervalList.addAll(intervals);
        Interval resInterval;
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for (Interval interval : intervalList) {
            if (interval.end >= newInterval.start
                && interval.start < newInterval.start) {
                start = interval.start;
                end = Math.max(newInterval.end, end);
            }
            if (interval.start <= newInterval.end
                    && interval.end > newInterval.end) {
                start = Math.min(start, interval.start);
                end = interval.end;
            }// 1 3 25 6 9
        }
        if (start == Integer.MAX_VALUE && end == Integer.MIN_VALUE) {
            if (newInterval.start < intervalList.get(0).start) {
                intervalList.addFirst(newInterval);
            } else {
                intervalList.add(newInterval);
            }
            return intervalList;
        }
        if (start == Integer.MAX_VALUE) {
            Iterator<Interval> iter = intervalList.iterator();
            while (iter.hasNext()) {
                Interval iv = iter.next();
                if (iv.start < end) iter.remove();
            }
        }
        if (end == Integer.MIN_VALUE) {
            Iterator<Interval> iter = intervalList.iterator();
            while (iter.hasNext()) {
                Interval iv = iter.next();
                if (iv.end > start) iter.remove();
            }
        }

        Iterator<Interval> iter = intervalList.iterator();
        while (iter.hasNext()) {
            Interval iv = iter.next();
            if (iv.end <= end && iv.start >= start) iter.remove();
        }
        if (intervalList.size() > 0 && newInterval.start < intervalList.get(0).start) {
            intervalList.addFirst(new Interval(start, end));
        } else {
            intervalList.add(new Interval(start, end));
        }
        return intervalList;
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
