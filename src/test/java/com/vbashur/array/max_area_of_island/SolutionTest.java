package com.vbashur.array.max_area_of_island;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution s = new Solution();

    @Test
    public void maxAreaOfIsland() {

        int[][] grid = {
            {0, 1, 0},
            {0, 1, 1}};
//        assertEquals(3,s.maxAreaOfIsland(grid));

        int[][] grid2 = {
            {0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        assertEquals(6,s.maxAreaOfIsland(grid2));

    }


}
