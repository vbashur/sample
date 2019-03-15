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
        if (a.isEmpty()) return 0;
        int counter = 1;
        Iterator<Integer> iter = a.iterator();
        Integer prev = iter.next();
        Integer curr = null;
        while( iter.hasNext() ) {
            curr = iter.next();
//            System.out.println( "a.get( prev ) = " + prev + " _ a.get( curr ) = " + curr);
            if (curr.equals(prev)) {
                iter.remove( );
            }
            prev = curr;

        }
        return a.size();
    }

    public int removeDuplicatesNotEfficient( ArrayList<Integer> a ) {
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
