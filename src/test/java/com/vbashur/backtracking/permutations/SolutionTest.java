package com.vbashur.backtracking.permutations;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void permute() {
        Solution s = new Solution();
        System.out.print( s.permute( new ArrayList<>( Arrays.asList(1, 2,3, 4 ) ) ));
    }


    @Test
    public void permuteMy() {
        Solution s = new Solution();
        int[] input = new int[] {1, 2, 3, 4};
        List<int[]> resList = s.getPermutations(input);
        Set<String> permsSet = new HashSet<>();
        for (int []r : resList) {
            StringBuilder sb = new StringBuilder();
            for (int iter = 0; iter < r.length;++iter) {
                sb.append(r[iter]);
            }
            String res = sb.toString();
            System.out.println(res);
            if (permsSet.contains(res)) {
                fail();
            }
            permsSet.add(res);
        }
        Assert.assertEquals(getFactorial(input.length),  resList.size());
    }

    private int getFactorial(int n) {
        if (n == 1) return 1;
        return n * getFactorial(n - 1);

    }


    @Test
    public void permuteIterative() {
        Solution<Integer> s = new Solution<>();
        Integer[] arr = new Integer[]{1, 2,3, 4};
        s.iterativeApproach(arr, 4 );
    }

}