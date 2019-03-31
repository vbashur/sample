package com.vbashur.backtracking.permutations;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void permute() {
        Solution s = new Solution();
        System.out.print( s.permute( new ArrayList<>( Arrays.asList(1, 2,3, 4 ) ) ));
    }


    @Test
    public void permuteIterative() {
        Solution<Integer> s = new Solution<>();
        Integer[] arr = new Integer[]{1, 2,3, 4};
        s.iterativeApproach(arr, 4 );
    }

}