package com.vbashur.array.prettyprint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by vic on 11/2/19.
 * <p>
 * https://www.interviewbit.com/problems/prettyprint/
 */
public class Solution {


    public ArrayList<ArrayList<Integer>> prettyPrint( int A) {
        int size = A + A - 1;
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
        for (int i = 0;  i< size; ++i) {
            ArrayList<Integer> list1 = new ArrayList<>();
            for (int j = 0;  j< size; ++j) {
                int index = getRowColIndex( i,j,A );
                list1.add( index );

            }
            listAll.add( list1 );
        }
        return listAll;
    }

    public int getRowColIndex(int x, int y, int A) {

        int centralIndex = A - 1;
        int distV = Math.abs(centralIndex - x);
        int distH = Math.abs(centralIndex - y);
        double distVAll = Math.sqrt((distV * distV));
        double distHAll = Math.sqrt((distH * distH));
        if (distVAll > distHAll) {
            y = centralIndex;
        } else {
            x = centralIndex;
        }
        int distX = Math.abs(centralIndex - x);
        int distY = Math.abs(centralIndex - y);
//        double dist = Math.sqrt((distY * distY) + (distX * distX));
//        double dist = Math.hypot(x - centralIndex, y - centralIndex);
        double dist = Math.hypot(centralIndex - x , centralIndex - y);
        return (int)dist + 1;
    }
}