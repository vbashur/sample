package com.vbashur.backtracking.permutations;

import java.util.ArrayList;

/*
Given a collection of numbers, return all possible permutations.

Example:

[1,2,3] will have the following permutations:

[1,2,3]
[1,3,2]
[2,1,3]
[2,3,1]
[3,1,2]
[3,2,1]

    NOTE

        No two entries in the permutation sequence should be the same.
        For the purpose of this problem, assume that all the numbers in the collection are unique.


 */

/**
 * Created by vic on 28/02/19.
 * <p>
 * https://www.interviewbit.com/problems/permutations/
 */
public class Solution {


    public ArrayList<ArrayList<Integer>> permute( ArrayList<Integer> num ) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> permItem = new ArrayList<Integer>();

        result.add( new ArrayList<Integer>() );

        for( int i = 0; i < num.size(); i++ ) {
            //list of list in current iteration of the array num
            ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();

            for( ArrayList<Integer> l : result ) {
                // # of locations to insert is largest index + 1
                for( int j = 0; j < l.size() + 1; j++ ) {
                    // + add num[i] to different locations
                    l.add( j, num.get( i ) );

                    ArrayList<Integer> temp = new ArrayList<Integer>( l );
                    current.add( temp );

                    //System.out.println(temp);

                    // - remove num[i] add
                    l.remove( j );
                }
            }

            result = new ArrayList<ArrayList<Integer>>( current );
        }

        return result;
    }

    public void updatePermutationList( ArrayList<Integer> A, ArrayList<Integer> permItem, ArrayList<ArrayList<Integer>> permutations ) {
        if( permItem.size() == A.size() ) {
            permutations.add( permItem );
        } else {
            for( int i = 0; i < A.size(); ++i ) {

            }
        }
    }
}
