package com.vbashur.stack_queue.sliding_win_max;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
/*


A long array A[] is given to you. There is a sliding window of size w which is moving from the very left of the array to the very right. You can only see the w numbers in the window. Each time the sliding window moves rightwards by one position. You have to find the maximum for each window. The following example will give you more clarity.

Example :

The array is [1 3 -1 -3 5 3 6 7], and w is 3.
Window position 	Max

[1 3 -1] -3 5 3 6 7 	3
1 [3 -1 -3] 5 3 6 7 	3
1 3 [-1 -3 5] 3 6 7 	5
1 3 -1 [-3 5 3] 6 7 	5
1 3 -1 -3 [5 3 6] 7 	6
1 3 -1 -3 5 [3 6 7] 	7

Input: A long array A[], and a window width w
Output: An array B[], B[i] is the maximum value of from A[i] to A[i+w-1]
Requirement: Find a good optimal way to get B[i]

    Note: If w > length of the array, return 1 element with the max of the array.


 */
/**
 * Created by vic on 12/03/19.
 * <p>
 * https://www.interviewbit.com/problems/sliding-window-maximum/
 */
public class Solution {

    public ArrayList<Integer> slidingMaximum( final List<Integer> A, int B ) {
        if( B > A.size() ) {
            return new ArrayList<>( Arrays.asList( findMax( A, 0, A.size() - 1 ) ) );
        }
        LinkedList<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>( new Comparator<Integer>() {
            @Override
            public int compare( Integer o1, Integer o2 ) {
                return (-1) * o1.compareTo( o2 );
            }
        } );

        for( int iter = 0; iter < B; ++iter ) {
            queue.add( A.get( iter ) );
            pq.add( A.get( iter ) );
        }

        ArrayList<Integer> res = new ArrayList<>();
        for( int i = B; i < A.size(); ++i ) {
            res.add( pq.peek() );
            Integer removedElement = queue.pollFirst();
            pq.remove( removedElement );
            pq.add( A.get( i ) );
            queue.add( A.get( i ) );
        }
        res.add( pq.peek() );
        return res;
    }

    public Integer findMax( List<Integer> A, int start, int end ) {
        Integer[] arr = new Integer[end - start + 1];
        int index = 0;
        for( int iter = start; iter <= end; ++iter ) {
            arr[index] = A.get( iter );
            ++index;
        }
        Arrays.sort( arr );

        return arr[arr.length - 1];
    }

    /* naive solution with the worst performance
    public ArrayList<Integer> slidingMaximum( final List<Integer> A, int B) {
        if (B > A.size()) {
            return new ArrayList<>( Arrays.asList( findMax(A, 0, A.size() - 1) ) );
        }
        ArrayList<Integer> res = new ArrayList<>(  );
        for (int iter = 0; iter <= A.size() - B; ++iter) {
            res.add( findMax( A, iter, iter + B - 1) );
        }
        return res;
    }

    public Integer findMax(List<Integer> A, int start, int end) {
        Integer[] arr = new Integer[end - start + 1];
        int index = 0;
        for (int iter = start; iter <=end; ++iter) {
            arr[index] = A.get( iter );
            ++index;
        }
        Arrays.sort( arr );

        return arr[arr.length - 1];
    }
    */
}
