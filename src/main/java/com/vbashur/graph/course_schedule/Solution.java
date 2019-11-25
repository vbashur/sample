package com.vbashur.graph.course_schedule;

import java.util.*;

// https://leetcode.com/problems/course-schedule/submissions/
public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = getCourseGraph(prerequisites);
        Map<Integer,Boolean> marked = new HashMap<>();
        Set<Integer> passed = new HashSet<>();
        LinkedList<Integer> q = new LinkedList<>();
        int counter = 0;
        if (prerequisites != null && prerequisites.length > 0) {
            q.offerFirst(prerequisites[0][1]);
        } else {
            return true;
        }
        while(!q.isEmpty()) {
            int courseToPass = q.pollFirst();
            ++counter;
            marked.put(courseToPass, true);
            List<Integer> courses = graph.get(courseToPass);
            if (courses != null) {
                for (Integer key : courses) {
                    if (!marked.containsKey(key)) {
                        q.offerFirst(key);
                    }
                }

            }
            if (passed.contains(courseToPass)) return false;
            passed.add(courseToPass);

        }
        return true;

    }

    private Map<Integer, List<Integer>> getCourseGraph(int[][] p) {
        Map<Integer, List<Integer>> gr = new HashMap<>();
        for(int i = 0; i < p.length; ++i) {
            if (gr.containsKey(p[i][1])) {
                List<Integer> list = gr.get(p[i][1]);
                list.add(p[i][0]);
            } else {
                List<Integer> courses = new LinkedList<>();
                courses.add(p[i][0]);
                gr.put(p[i][1], courses);
            }
        }
        return gr;
    }
}
