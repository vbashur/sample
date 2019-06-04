package com.vbashur.amaz;

import java.util.*;

public class Solution {

    private static final int TRUCK_FREE_SPACE = 30;
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    ArrayList<Integer> IDsOfPackages(int truckSpace,
                                     ArrayList<Integer> packagesSpace)
    {
        List<Integer> sortedPackages = new ArrayList<>(packagesSpace.size());
        sortedPackages.addAll(packagesSpace);
        Collections.sort(sortedPackages);
        int upperBound = truckSpace - TRUCK_FREE_SPACE;
        int loIter = 0;
        int hiIter = packagesSpace.size() - 1;
        Integer lo = new Integer(sortedPackages.get(loIter));
        Integer hi = new Integer(sortedPackages.get(loIter));
        Integer max = new Integer(sortedPackages.get(loIter));
        while (sortedPackages.get(hiIter) > upperBound ) {
            --hiIter;
        }
        while (loIter < hiIter) {
            int sum = sortedPackages.get(loIter) + sortedPackages.get(hiIter);
            if (sum > max && sum <= upperBound) {
                max = sum;
                lo = sortedPackages.get(loIter);
                hi = sortedPackages.get(hiIter);
            } else if (sum > upperBound) {
                --hiIter;
            } else {
                ++loIter;
            }
        }
        int loIndex = -1;
        int hiIndex = -1;
        for (int i = 0; i < packagesSpace.size(); ++i) {
            if (packagesSpace.get(i) == lo && loIndex < 0) {
                loIndex = i;
            } else if (packagesSpace.get(i) == hi && hiIndex < 0) {
                hiIndex = i;
            }
        }
        ArrayList<Integer> resList = new ArrayList<>();
        resList.add(loIndex);
        resList.add(hiIndex);
        return resList;
    }



    int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot)
    {
        int obstX = -1;
        int obstY = -1;
        for (int i = 0; i < lot.size() && obstX < 0; ++i) {
            for (int j = 0; j < lot.get(i).size() && obstY < 0; ++ j) {
                if (lot.get(i)!= null && lot.get(i).get(j) != null && lot.get(i).get(j) != 0 && lot.get(i).get(j) != 1) {
                    obstX = i;
                    obstY = j;
                }
            }
        }
        Boolean[][] marked = new Boolean[lot.size()][];
        for (int i = 0; i < lot.size(); ++i) {

            Boolean[] markedY = new Boolean[lot.get(i).size()];
            for (int j = 0; j < lot.get(i).size(); ++ j) {
                markedY[j] = false;
            }
            marked[i] = markedY;
        }
        int minPrice = Integer.MAX_VALUE;
        return dfsToTop(minPrice, 0, obstX, obstY, numRows, numColumns, lot, marked);


    }

    private int dfsToTop(int minPrice, int pathPrice, int xStart, int yStart, int numRows, int numColumns, List<List<Integer>> lot,
                         Boolean[][] marked) {

        if (xStart == 0 && yStart == 0) {
            if (pathPrice < minPrice) {
                minPrice = pathPrice;
            }
            return minPrice;
        }
        else {
            // go up
            if (xStart - 1 >= 0 && lot.get(xStart - 1).get(yStart) == 1 && !isVisited(xStart -1, yStart, marked )) {
                markVisited(xStart -1, yStart, marked);
                minPrice = dfsToTop(minPrice, pathPrice + 1, xStart - 1, yStart, numRows, numColumns, lot, marked);
            }
            // go left
            if (yStart - 1 >= 0 && lot.get(xStart).get(yStart - 1) == 1 && !isVisited(xStart, yStart - 1, marked )) {
                markVisited(xStart, yStart - 1, marked);
                minPrice = dfsToTop(minPrice, pathPrice + 1, xStart, yStart - 1, numRows, numColumns, lot, marked);
            }

            // go down
            if (xStart + 1 < numColumns && lot.get(xStart + 1).get(yStart) == 1  && !isVisited(xStart + 1, yStart, marked )) {
                markVisited(xStart + 1, yStart , marked);
                minPrice = dfsToTop(minPrice, pathPrice + 1, xStart + 1, yStart, numRows, numColumns, lot, marked);
            }
            // go right
            if (yStart + 1 < numRows && lot.get(xStart).get(yStart + 1) == 1  && !isVisited(xStart , yStart + 1, marked )) {
                markVisited(xStart, yStart + 1, marked);
                minPrice = dfsToTop(minPrice, pathPrice + 1, xStart, yStart + 1, numRows, numColumns, lot, marked);
            }
        }
        return minPrice;
    }

    boolean isVisited(int x, int y, Boolean[][] marked) {
        return marked[x][y];
    }

    void markVisited(int x, int y, Boolean[][] marked) {
        marked[x][y] = true;
    }
}
