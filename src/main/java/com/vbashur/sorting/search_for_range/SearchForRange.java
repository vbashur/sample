package com.vbashur.sorting.search_for_range;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Created by vic on 11/02/19.
 * <p>
 * https://www.interviewbit.com/problems/search-for-a-range/
 */
public class SearchForRange {

    // DO NOT MODIFY THE LIST
    public ArrayList<Integer> searchRangeMy( final List<Integer> a, int b) {
        int firstIndex = getFirstIndex( a, b, 0, a.size() -1 );
        if (a.get( firstIndex ) > b) return new ArrayList<>( Arrays.asList( -1, -1));
        int lastIndex = getLastIndex(  a, b, 0, a.size() -1  );
        return new ArrayList<>( Arrays.asList( firstIndex, lastIndex));
    }

    private int getFirstIndex(final List<Integer> a, int b, int lo, int hi) {
        if (Math.abs( hi - lo ) <= 1) return lo;
        int mid = lo + (hi - lo) / 2;
        if (a.get( mid ) >= b ) return getFirstIndex( a, b, lo, mid / 2 );
        if (a.get( mid ) < b )  return getFirstIndex( a, b, mid, hi);
        return mid;
    }

    private int getLastIndex(final List<Integer> a, int b, int lo, int hi) {
        if (Math.abs( hi - lo ) <= 1) return lo;
        int mid = lo + (hi - lo) / 2;
        if (a.get( mid ) > b ) return getLastIndex( a, b, lo, mid / 2 );
        if (a.get( mid ) <= b )  return getLastIndex( a, b, mid, hi);
        return mid;
    }

    public ArrayList<Integer> searchRangeApproved( final List<Integer> a, int b) {
        int lo = 0, hi = a.size() - 1;
        Integer[] res = { -1, -1 };

        while (lo < hi) {
            int mid  = (lo + hi) / 2;
            if (a.get( mid ) < b)
                lo = mid + 1;
            else
                hi = mid;
        }
        if (a.get( lo ) != b) return  new ArrayList<Integer>( Arrays.asList( res));
        else res[0] =  lo ;
        hi = a.size() -1 ;
        while (lo < hi) {
            int mid = (lo + hi) / 2 + 1;
            if (a.get( mid ) > b) hi = mid - 1;
            else lo = mid;
        }
        res[1]= hi;
        return  new ArrayList<Integer>( Arrays.asList( res));
    }
}
