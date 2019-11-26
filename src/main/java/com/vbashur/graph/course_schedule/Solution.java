package com.vbashur.graph.course_schedule;

import java.util.*;

// https://leetcode.com/problems/course-schedule/submissions/
public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = getCourseGraph(prerequisites);
        Map<Integer, Boolean> marked = new HashMap<>();
        Set<Integer> passed = new HashSet<>();
        if (prerequisites != null && prerequisites.length > 0) {
            for (int iter = 0; iter < prerequisites.length; ++iter) {
                if (isCyclic(prerequisites[iter][1], graph, marked, passed)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isCyclic(Integer courseToPass, Map<Integer, List<Integer>> graph, Map<Integer, Boolean> marked, Set<Integer> passed) {
        marked.put(courseToPass, true);
        if (passed.contains(courseToPass)) {
            return true;
        }
        passed.add(courseToPass);
        List<Integer> courses = graph.get(courseToPass);
        if (courses != null) {
            for (Integer key : courses) {

                if (isCyclic(key, graph, marked, passed)) {
                    return true;
                }

            }
        }
        passed.remove(courseToPass);
        return false;
    }

    private Map<Integer, List<Integer>> getCourseGraph(int[][] p) {
        Map<Integer, List<Integer>> gr = new HashMap<>();
        for (int i = 0; i < p.length; ++i) {
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
