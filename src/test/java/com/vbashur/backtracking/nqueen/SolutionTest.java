package com.vbashur.backtracking.nqueen;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void solveNQueens() {
        Solution s = new Solution();
        System.out.println(s.solveNQueens( 4 ));
    }
}