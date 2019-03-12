package com.vbashur.stack_queue.sliding_win_max;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void slidingMaximum() {
        List<Integer> tList = new ArrayList<>(  );
        tList.addAll( Arrays.asList(1, 3, -1, -3, 5, 3, 6, 7) );
        Solution s  = new Solution();
        List<Integer>  res = s.slidingMaximum( tList, 3 );
        Integer[] expectedArr = new Integer[]{3,3,5,5,6,7};
        assertArrayEquals( expectedArr, res.toArray() );
    }

    @Test
    public void slidingMaximumWithOne() {
        List<Integer> tList = new ArrayList<>(  );
        tList.addAll( Arrays.asList(1, 3, -1, -3, 5, 3, 6, 7) );
        Solution s  = new Solution();
        List<Integer>  res = s.slidingMaximum( tList, 1 );
        assertArrayEquals( tList.toArray(), res.toArray() );
    }
}