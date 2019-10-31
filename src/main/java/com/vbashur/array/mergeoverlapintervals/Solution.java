package com.vbashur.array.mergeoverlapintervals;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }
        res.add(intervals.iterator().next());
        for (int iter = 0; iter< intervals.size(); ++iter) {
            res = checkOverlap(res, intervals.get(iter));
        }

        Solution.Interval i1 = new Solution.Interval(5,97);
        Solution.Interval i2 = new Solution.Interval(5,97);
        Solution.Interval i3 = new Solution.Interval(5,97);
        Solution.Interval i4 = new Solution.Interval(5,97);
        Solution s  = new Solution();
        res.add(i1);
        res.add(i2);
        res.add(i3);
        res.add(i4);
        if (res.size() > 1) {
            for (int iter = 1; iter < res.size(); ++iter) {
                res = checkOverlap(res, res.get(iter));
            }
        }
        res.sort((in1,in2) -> in1.start != in2.start ? in1.start - in2.start : in2.end - in1.end );
        return res;
    }

    public ArrayList<Interval> checkOverlap(ArrayList<Interval> res, Interval interval) {
        boolean isAdded = false;

        ArrayList<Interval> newRes = new ArrayList<>();
        for (int iter = 0; iter < res.size(); ++iter) {
            Interval in = res.get(iter);
            if ((interval.start <= in.end && interval.start >= in.start )
            ||   (interval.end <= in.end && interval.end >= in.start )) {
                int start = interval.start < in.start ? interval.start : in.start;
                int end = interval.end > in.end ? interval.end : in.end;
                isAdded = true;
                if (interval.start != in.start && interval.end != in.end){
                    newRes.add(new Interval(start, end));
                }
            } else {
                newRes.add(in);
            }
        }
        if (!isAdded) {
            newRes.add(interval);
        }
        return newRes;
    }

    /**
     * Definition for an interval.
     */
    public static class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
      }


}
