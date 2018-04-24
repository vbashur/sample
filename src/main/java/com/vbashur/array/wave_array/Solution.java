package com.vbashur.array.wave_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by vic on 4/24/18.
 * https://www.interviewbit.com/problems/wave-array/
 *
 * Given an array of integers, sort the array into a wave like array and return it,
 In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....

 Example

 Given [1, 2, 3, 4]

 One possible answer : [2, 1, 4, 3]
 Another possible answer : [4, 1, 3, 2]
 */

public class Solution {
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        if (A == null || A.isEmpty() || A.size() == 1) {
            return A;
        }
        Collections.sort(A);
        Integer[] arr = new Integer[A.size()];
        A.toArray(arr);
        for (int iter = 0; iter < A.size() -1; iter+=2) {
            arr[iter] =  A.get(iter + 1);
            arr[iter + 1] =  A.get(iter);
        }
        return new ArrayList<Integer>(Arrays.asList(arr));
    }

}
