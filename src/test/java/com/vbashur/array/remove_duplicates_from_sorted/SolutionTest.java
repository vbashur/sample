package com.vbashur.array.remove_duplicates_from_sorted;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    Solution s = new Solution();

    @Test
    public void test() {

        ArrayList<Integer> input = new ArrayList<>( Arrays.asList( 5000, 5000, 5000 ) );
        Assert.assertEquals( 1, s.removeDuplicates( input ) );

        input = new ArrayList<>( Arrays.asList( 1, 1, 2 ) );
        Assert.assertEquals( 2, s.removeDuplicates( input ) );

        input = new ArrayList<>( Arrays.asList( 1, 1, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 ) );
        Assert.assertEquals( 3, s.removeDuplicates( input ) );
    }

    @Test
    public void removeDuplicates() {
//        List<Integer> input = Arrays.asList(  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3  );
        List<Integer> input = Arrays.asList(  0, 0, 1, 1, 2, 2, 3, 3 );
        Assert.assertEquals( 4, s.removeDuplicates( new ArrayList<>( input) ) );
        System.out.println( input );

    }
}