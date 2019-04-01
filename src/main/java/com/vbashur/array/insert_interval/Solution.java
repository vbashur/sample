package com.vbashur.array.insert_interval;

/**
 * Created by vic on 4/1/19.
 * <p>
 * https://leetcode.com/problems/insert-interval/
 */

import com.vbashur.common.Interval;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
        if (intervals.isEmpty()) return intervals;
        ArrayList<Integer> intervalsArr = initIntervalList(intervals);
        int end = newInterval.end ; //intervalsArr.size() <= newInterval.end ? newInterval.end : intervalsArr.size() - 1;
        int newIntervalStartValue = newInterval.start;
        if (!intervalsArr.get(newInterval.start).equals(Integer.valueOf(0))) {
            newIntervalStartValue = intervalsArr.get(newInterval.start);
        }
        boolean isOverlap = false;
        for (int iter = newInterval.start; iter <= end; ++iter) {
            if ((iter == end) && intervalsArr.size() > end && !intervalsArr.get(iter).equals(Integer.valueOf(0))) {
                if ((iter + 1 < intervalsArr.size() )
                        && intervalsArr.get(iter).equals(intervalsArr.get(iter + 1))) {
                    isOverlap = true;
                }
            }
            if (iter < intervalsArr.size()) {
                intervalsArr.set(iter, newIntervalStartValue);
            } else {
                intervalsArr.add(newIntervalStartValue);
            }
        }
        if (intervalsArr.size() <= end) {
            int iter = intervalsArr.size();
            while (iter <= end) {
                intervalsArr.add(newIntervalStartValue);
                ++iter;
            }
        } else if (isOverlap) {
            int iter = end + 1;
            while (iter < intervalsArr.size() && !intervalsArr.get(iter).equals(Integer.valueOf(0))) {
                intervalsArr.set(iter, newIntervalStartValue);
                ++iter;
            }
        }
        List<Interval> resIntervals = getIntervals(intervalsArr);
        return resIntervals;
    }

    private ArrayList<Integer> initIntervalList(List<Interval> intervals) {
        ArrayList<Integer> intervalList = new ArrayList<>();
        int index = 0;
        for (Interval interval : intervals) {
            do {
                intervalList.add(0);
                ++index;
            } while (index < interval.start);
            do {
                intervalList.add(interval.start);
                ++index;
            } while (index <= interval.end);
        }
        return intervalList;
    }

    private List<Interval> getIntervals(ArrayList<Integer> intsArr) {
        List<Interval> intervalList = new LinkedList<>();
        for (int iter = 1; iter < intsArr.size(); ++iter) {
            if (!intsArr.get(iter).equals(Integer.valueOf(0))) {
                int start = intsArr.get(iter);
                while (iter < intsArr.size() - 1 && intsArr.get(iter).equals(intsArr.get(iter + 1))) {
                    ++iter;
                }
                int end = iter;
                Interval newInterval = new Interval(start, end);
                intervalList.add(newInterval);
            }
        }
        return intervalList;
    }
}
