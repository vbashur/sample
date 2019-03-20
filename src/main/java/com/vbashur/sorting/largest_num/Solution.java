package com.vbashur.sorting.largest_num;

/*
Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"

Example 2:

Input: [3,30,34,5,9]
Output: "9534330"

Note: The result may be very large, so you need to return a string instead of an integer.
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/*
 * Created by vic on 19/03/19.
 * <p>
 * https://leetcode.com/problems/largest-number/
 */
public class Solution {


    public String largestNumber( int[] nums ) {
        PriorityQueue<Integer> pq = new PriorityQueue<>( new Comparator<Integer>() {
            @Override
            public int compare( Integer o1, Integer o2 ) {
//                int basis1 = getLength( o1 );
//                int basis2 = getLength( o2 );
//                Integer num1 = o1 * Double.valueOf( Math.pow( 10, basis2 )).intValue() + o2;
//                Integer num2 = o2 * Double.valueOf( Math.pow( 10, basis1 )).intValue() + o1;
                String num1 = o1.toString() + o2.toString();
                String num2 = o2.toString() + o1.toString();
                return num2.compareTo( num1 );
            }
        } );
        for( int i = 0; i < nums.length; ++i ) {
            pq.add( nums[i] );
        }
        StringBuilder res = new StringBuilder();
        while( !pq.isEmpty() ) {
            res.append( pq.poll() );
        }
        boolean allZeros = true;
        for (int iter = 0; iter < res.length() && allZeros; ++iter ){
            if (res.charAt( iter ) != '0') {
                allZeros = false;
            }
        }
        if (allZeros) return "0";
        return res.toString();
    }

    public String sophisticatedComparatorSolution(int[] nums ) {
        PriorityQueue<Integer> pq = new PriorityQueue<>( new Comparator<Integer>() {
            @Override
            public int compare( Integer o1, Integer o2 ) {
                int normalizationBasis1 = getLength( o1 );
                int normalizationBasis2 = getLength( o2 );
                if( normalizationBasis1 > normalizationBasis2 ) {
                    Integer normVal = o2 * Double.valueOf( Math.pow( 10, normalizationBasis1 - normalizationBasis2 ) ).intValue();
                    return (-1) * o1.compareTo( normVal );
                }
                if( normalizationBasis1 < normalizationBasis2 ) {
                    Integer normVal = o1 * Double.valueOf( Math.pow( 10, normalizationBasis2 - normalizationBasis1 ) ).intValue();
                    return (-1) * normVal.compareTo( o2 );
                }
                return (-1) * o1.compareTo( o2 );
            }
        } );
        for( int i = 0; i < nums.length; ++i ) {
            pq.add( nums[i] );
        }

        StringBuilder res = new StringBuilder();
        while( !pq.isEmpty() ) {
            res.append( pq.poll() );
        }
        return res.toString();

    }

    public int getLength( int num ) {
        if( num < 10 ) return 1;
        int counter = 1;
        counter += getLength( num / 10 );
        return counter;
    }
}
