package com.vbashur.binary_search.median_array;

/*
There are two sorted arrays A and B of size m and n respectively.

Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

The overall run time complexity should be O(log (m+n)).

Sample Input

A : [1 4 5]
B : [2 3]

Sample Output

3

 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by vic on 4/3/19.
 * https://www.interviewbit.com/problems/median-of-array/
 */
public class Solution {

    // DO NOT MODIFY BOTH THE LISTS
    public double findMedianSortedArrays( final List<Integer> a, final List<Integer> b ) {
        return notOptimizedVersionOfAlgorithm( a, b );

    }


    public double notOptimizedVersionOfAlgorithm( final List<Integer> a, final List<Integer> b ) {
        List<Integer> mergedList = new ArrayList<>( a );
        mergedList.addAll( b );
        Collections.sort( mergedList );
        if( mergedList.size() == 0 ) {
            return 0;
        }
        if( mergedList.size() % 2 == 0 ) {
            int arg1 = mergedList.get( mergedList.size() / 2 - 1 );
            int arg2 = mergedList.get( mergedList.size() / 2 );
            return (arg1 + arg2) / 2;
        } else {
            return mergedList.get( mergedList.size() / 2 );
        }
    }

    public double worstOptimizedVersionOfAlgorithm( final List<Integer> a, final List<Integer> b ) {
        int size = a.size() + b.size();
        List<Integer> mergedList = new ArrayList<>();

        int iterMerged = 0, iterA = 0, iterB = 0;
        while( iterMerged < size ) {
            if( iterA < a.size() ) {
                if( iterB < b.size() ) {
                    if( a.get( iterA ) < b.get( iterB ) ) {
                        mergedList.add( a.get( iterA ) );
                        iterA++;
                    } else {
                        mergedList.add( b.get( iterB ) );
                        iterB++;
                    }
                } else {
                    mergedList.add( a.get( iterA ) );
                    iterA++;
                }
            } else if( iterB < b.size() ) {
                mergedList.add( b.get( iterB ) );
                iterB++;
            }
            iterMerged++;
        }
        if( mergedList.size() % 2 == 0 ) {
            int arg1 = mergedList.get( mergedList.size() / 2 - 1 );
            int arg2 = mergedList.get( mergedList.size() / 2 );
            return ((double) (arg1 + arg2) / 2);
        } else {
            return (double) mergedList.get( mergedList.size() / 2 );
        }
    }
}
