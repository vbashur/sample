package com.vbashur.greedy.schedule_course;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by vic on 4/2/19.
 * https://leetcode.com/problems/course-schedule-iii/
 */
public class Solution {

    public int scheduleCourse(int[][] courses) {

        if (courses == null) return 0;
        if (courses.length < 2) return courses.length;

        Arrays.sort(courses, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {


                if (o1[1] == o2[1] && o1[0] == o2[0]) return 0;
                if (o1[1] == o2[1] && o1[0] > o2[0]) return 1;
                if (o1[1] > o2[1]) return 1;
                return -1;
            }
        });
        int counter = 1;
        int accuDays = courses[0][0];
        for (int i = 1; i < courses.length; ++i) {
//            System.out.print("[" + courses[i][0] + "-" + courses[i][1] + "]");
//            System.out.println();
            int durationPrev = accuDays;
            int durationCurr = courses[i][0];
            int deadline = courses[i][1];
            if (durationCurr + durationPrev <= deadline) {
                ++counter;
                accuDays += durationCurr;
            }
        }
        return counter;

    }

    private void print(int[][] courses) {
        for (int i = 0; i < courses.length; ++i) {
            System.out.print("[" + courses[i][0] + "-" + courses[i][1] + "]");
            System.out.println();
        }
    }
}
