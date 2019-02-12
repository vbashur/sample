package com.vbashur.array.remove_duplicates_from_sorted;

import java.util.ArrayList;
import java.util.Iterator;



/**
 * Created by vic on 12/2/19.
 * <p>
 * https://www.interviewbit.com/problems/remove-duplicates-from-sorted-array/
 */
public class Solution {


    public int removeDuplicates( ArrayList<Integer> a ) {
        for( int iter = 1, j = 0; iter < a.size(); ++iter ) {
//            System.out.print( "a.get( iter )" + a.get( iter ) );
//            System.out.println( " : a.get( j )" + a.get( j )  + " iter: " + iter + " [a.get( iter ) == a.get( j )]=" + (a.get( iter ).equals( a.get( j ))));
            while( iter < a.size() && a.get( iter ).equals( a.get( j ) ) ) {
                a.remove( iter );
            }
            j = iter;
        }
        return a.size();
    }
}
