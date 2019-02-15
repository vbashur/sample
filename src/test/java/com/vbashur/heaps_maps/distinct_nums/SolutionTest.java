
package com.vbashur.heaps_maps.distinct_nums;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class SolutionTest {


    Solution s = new Solution();

    @Test
    public void test() {
        ArrayList<Integer> input = new ArrayList<>();
        input.addAll( Arrays.asList(1, 2, 1, 3, 4, 3) );
        ArrayList<Integer> output = s.dNums( input, 3 );
        System.out.println( output );


    }
}