package com.vbashur.array.mergeoverlapintervals;

import java.util.*;

public class Solution {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Set<IntervalExt> res = new TreeSet<IntervalExt>((in1,in2) -> in1.start != in2.start ?
                in1.start - in2.start : in2.end - in1.end);
        if (intervals == null || intervals.size() == 0) {
            return new ArrayList<>(res);
        }
        res.add(new IntervalExt(intervals.iterator().next()));
        for (int iter = 1; iter< intervals.size(); ++iter) {
            res = checkOverlap(res, new IntervalExt(intervals.get(iter)));
        }

//        res.stream().sorted((in1,in2) -> in1.start != in2.start ? in1.start - in2.start : in2.end - in1.end );

        ArrayList<Interval> arl = new ArrayList<>(res);
        arl.sort((in1,in2) -> in1.start != in2.start ?
                in1.start - in2.start : in2.end - in1.end);
        return arl;
    }

    public Set<IntervalExt> checkOverlap(Set<IntervalExt> res, IntervalExt interval) {
        boolean isAdded = false;

        Set<IntervalExt> newRes = new HashSet<>();
        for (Interval in : res) {
            if (! (Math.max(interval.start, in.start) >Math.min(interval.end, in.end))) {
                int start = Math.min(interval.start, in.start);
                int end = Math.max(interval.end, in.end);
                isAdded = true;
                interval = new IntervalExt(start, end);
                newRes.add(interval);
            } else {
                newRes.add(new IntervalExt(in));
            }
        }
        if (!isAdded) {
            newRes.add(new IntervalExt(interval));
        }
        return newRes;
    }

    class IntervalExt extends Interval {

        IntervalExt(Interval i) {
            super(i.start, i.end);
        }

        IntervalExt(int start, int end) {
            super(start, end);
        }
        @Override
        public int hashCode() {
            return super.start + super.end;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj != null && obj instanceof Interval) {
                if (obj == this) {
                    return true;
                }
                Interval in = ((Interval) obj);
                return in.start == this.start && in.end == this.end;
            }
            return false;
        }
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
