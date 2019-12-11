package com.vbashur.graph.redund_connection;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void findRedundantConnection() {
        List<int[]> input = new LinkedList<>();
        input.add(new int[]{3,7});
        input.add(new int[]{1,4});
        input.add(new int[]{2,8});
        input.add(new int[]{1,6});
        input.add(new int[]{7,9});
        input.add(new int[]{6,10});
        input.add(new int[]{1,7});
        input.add(new int[]{2,3});
        input.add(new int[]{8,9});
        input.add(new int[]{5,9});
        Solution s = new Solution();
        int[][] conns = new int[input.size()][];
        for (int i = 0; i < input.size(); i++) {
            conns[i] = input.get(i);


        }
        int[] redundantConnection = s.findRedundantConnection(conns);
        for (int i = 0; i < redundantConnection.length; i++) {

            System.out.println(redundantConnection[i]);
        }



    }
}