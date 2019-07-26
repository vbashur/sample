package com.vbashur.array.max_area_of_island;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {


    public int maxAreaOfIsland(int[][] grid) {
        List<Set<String>> islands = new LinkedList<>();
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                String pointId = getPointId(i, j);
                if (!isVisitedPoint(pointId, islands)) {
                    getIslandArea(i, j, grid, islands);
                }
            }
        }
        return getMaxIslandArea(islands);
    }

    private String getPointId(int i, int j) {
        return String.valueOf(i) + String.valueOf(j);
    }

    private boolean isIslandPart(int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length
            && j >= 0 && j < grid[i].length
            && grid[i][j] == 1) {
            return true;
        }
        return false;
    }

    private int getMaxIslandArea(List<Set<String>> islands) {
        int maxArea = 0;
        for (Set<String> island : islands) {
            maxArea = Math.max(maxArea, island.size());
        }
        return maxArea;
    }


    private boolean isVisitedPoint(String pointId, List<Set<String>> visitedPoints) {
        for (Set<String> points : visitedPoints) {
            if (points.contains(pointId)) {
                return true;
            }
        }
        return false;
    }

    private void getIslandArea(int i, int j, int[][] grid, List<Set<String>> visitedPoints) {
        Set<String> island = new HashSet<>();
        exploreIsland(i, j, grid, island);
        if (island.size() > 0) {
            visitedPoints.add(island);
        }
    }

    private void exploreIsland(int i, int j, int[][] grid, Set<String> island) {
        String pointId = getPointId(i, j);
        if (isIslandPart(grid, i, j) && !island.contains(pointId)) {
            island.add(pointId);
            exploreIsland(i + 1, j, grid, island);
            exploreIsland(i, j + 1, grid, island);
            exploreIsland(i - 1, j, grid, island);
            exploreIsland(i, j - 1, grid, island);
        }
    }
}
