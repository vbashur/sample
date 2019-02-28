package com.vbashur.backtracking.nqueen;
/*
Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens’ placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]


 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by vic on 28/02/19.
 * <p>
 * https://www.interviewbit.com/problems/nqueens/
 */
public class Solution {

    private final static String Q = "Q";
    private final static String X = ".";

    public ArrayList<ArrayList<String>> solveNQueens( int a) {

        ArrayList<ArrayList<String>> combinationsStr = new ArrayList<>(  );
//
//
//        System.out.println(Math.atan2( 5 - 3, 2 -4 ));
//        System.out.println(Math.atan2( 6 - 3, 1 -4 ));
//
//        System.out.println(Math.toDegrees(Math.atan2( 6 - 3, 1 -4 )) % 45);
//        System.out.println(Math.toDegrees(Math.atan2( 2 - 3, 5 -4 )) % 45);
//        System.out.println(Math.toDegrees(Math.atan2( 3- 2 , 4 - 5 )) % 45);
//        System.out.println(Math.toDegrees(Math.atan2( 6 - 3, 1 -4 )));

        if (a == 0) {
            return combinationsStr;
        }
        ArrayList<ArrayList<Cell>> combinations = new ArrayList<ArrayList<Cell>>();
        if (a==1) {
            ArrayList<Cell> singleList = new ArrayList<>(  );
            singleList.add( new Cell(1, 1) );
            combinations.add( singleList );
        }

        for (int iter = 1; iter <= a; ++iter) {
            int step = 1;
            Cell firstCell = new Cell( iter, step );
            ArrayList<Cell> recordedCells = new ArrayList<>(  );
            recordedCells.add( firstCell );
            updateCombinations( a, recordedCells, step + 1, combinations );
        }
        for (ArrayList<Cell> cells : combinations) {
            ArrayList<String> comb = new ArrayList<>(  );
            for (Cell c : cells) {
                StringBuilder row = new StringBuilder();
                for( int i = 1; i <= a; ++i ) {
                    if( i == c.col ) {
                        row.append( Q );
                    } else {
                        row.append( X );
                    }

                }
                comb.add( row.toString() );
            }
            combinationsStr.add( comb );
        }
        return combinationsStr;
    }

    public void updateCombinations(int nQueens, ArrayList<Cell> recordedCells, int step, ArrayList<ArrayList<Cell>> combinations) {
        if (step < nQueens) {
            for (int iter = 1; iter <= nQueens; ++iter) {
                Cell currentCell = new Cell(iter, step);
                if (!isIntersection( currentCell, recordedCells )) {
                    recordedCells.add( currentCell );
                    updateCombinations( nQueens, recordedCells, step + 1, combinations );
                }

            }
        } else {
            for (int iter = 1; iter <= nQueens; ++iter) {
                Cell currentCell = new Cell(iter, step);
                if (!isIntersection( currentCell, recordedCells )) {
                    recordedCells.add( currentCell );
                    combinations.add( recordedCells );
                }
            }
        }
    }

    public boolean isIntersection(Cell cell,  List<Cell> recordedCells) {
        for (Cell recCell : recordedCells) {
            int Y = cell.row - recCell.row;
            int X = cell.col - recCell.col;
            if ((Math.toDegrees(Math.atan2( Y, X )) % 45) == 0)
                return true;
        }
        return false;
    }

    public class Cell {
        int col, row;
        Cell(int col, int row) {
            this.col = col;
            this.row = row;
        }
    }
}
