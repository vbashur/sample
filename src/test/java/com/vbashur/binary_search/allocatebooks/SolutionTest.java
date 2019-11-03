package com.vbashur.binary_search.allocatebooks;

import org.junit.Test;

import java.util.ArrayList;

public class SolutionTest {

    @Test
    public void books() {
        Solution s = new Solution()
                ;
        ArrayList<Integer> input = new ArrayList<>();
        input.add(12);
        input.add(34);
        input.add(67);
        input.add(90);
        System.out.println(s.books(input, 2));
    }
}