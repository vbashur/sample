package com.vbashur.backtracking.permutations;

import java.util.ArrayList;
import java.util.Arrays;

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
public class Solution<T> {


    public ArrayList<ArrayList<Integer>> permute( ArrayList<Integer> num ) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

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


    public void iterativeApproach(T[] elements, int n) {
        int[] indexes = new int[n];
        Arrays.fill(indexes, 0);
        printArray(elements);
        int i = 0;
        while (i < n) {
            if (indexes[i] < i) {
                int indexToSwap = i % 2 == 0 ? 0 : indexes[i];
                swap(elements, indexToSwap , i);
                printArray(elements);
                indexes[i]++;
//                System.out.println();
//                for (int h = 0; h < indexes.length; ++h ) {  System.out.print(indexes[h]); }
                i = 0;
            } else {
                indexes[i] = 0;
                i++;
            }
        }
    }

    private void swap(T[] input, int a, int b) {
        T tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    private void printArray(T[] input) {
        System.out.print('\n');
        for(int i = 0; i < input.length; i++) {
            System.out.print(input[i]);
        }
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
