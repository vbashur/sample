package com.vbashur.array.min_steps_in_grid;

import java.util.ArrayList;

/**
 * Created by vic on 4/19/18.
 * https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
 *
 * You are in an infinite 2D grid where you can move in any of the 8 directions :

 (x,y) to
 (x+1, y),
 (x - 1, y),
 (x, y+1),
 (x, y-1),
 (x-1, y-1),
 (x+1,y+1),
 (x-1,y+1),
 (x+1,y-1)
 You are given a sequence of points and the order in which you need to cover the points. Give the minimum number of steps in which you can achieve it. You start from the first point.

 Example :

 Input : [(0, 0), (1, 1), (1, 2)]
 Output : 2
 */
public class Solution {
    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A.isEmpty() || B.isEmpty() || A.size() < 2 || B.size() < 2)
            return 0;
        int xPointsNum = A.size() - 1;
        int yPointsNum = B.size() - 1;
        int steps = 0;
        int iterX = 0, iterY = 0;
        while (iterX < xPointsNum && iterY < yPointsNum) {
            double distance = Math.max(Math.abs(A.get(iterX + 1) - A.get(iterX)), Math.abs(B.get(iterY + 1) - B.get(iterY)));
            ++iterX;
            ++iterY;
            steps += distance;
        }
        return steps;
    }
}
