package com.vbashur.array.pascal_triangle;

import java.util.ArrayList;
import java.util.List;
/*
https://www.interviewbit.com/problems/pascal-triangle/

Given numRows, generate the first numRows of Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Given numRows = 5,

Return

[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]



 */
public class Solution {

    public ArrayList<ArrayList<Integer>> generate(int A) {

        ArrayList<ArrayList<Integer>> resList = new ArrayList<>(A);
        int i = 1;
        while (i<=A) {
            ArrayList<Integer> row = new ArrayList<>(i);
            for (int iter = 0; iter < i; ++iter) {
                if ((iter == 0) || (iter == i-1)) {
                    row.add(1);
                } else {
                    List<Integer> prevRow = resList.get(i - 2);
                    row.add(prevRow.get(iter - 1) + prevRow.get(iter));
                }
            }
            resList.add(row);
            ++i;
        }
        return resList;

    }
}
