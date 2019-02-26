package com.vbashur.greedy.majority_element;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*


Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example :

Input : [2, 1, 2]
Return  : 2 which occurs 2 times which is greater than 3/2.


 */

/**
 * Created by vic on 26/02/19.
 * <p>
 * https://www.interviewbit.com/problems/majority-element/
 */
public class Solution {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int majorityElement(final List<Integer> A) {
        int floor = A.size() / 2;
        Map<Integer, Integer> counts = new HashMap<>(  );
        for (Integer element : A) {
            if (counts.containsKey( element )) {
                Integer counter = counts.get( element ) + 1;
                counts.put( element, counter );
            } else {
                counts.put( element, Integer.valueOf( 1 ) );
            }
        }
        for (Integer elt : counts.keySet()) {
            if (counts.get( elt ) >= floor ) {
                return elt;
            }
        }
        return 0;
    }
}
