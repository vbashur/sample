package com.vbashur.greedy.gas_station;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void canCompleteCircuitBase() {

        Solution s = new Solution();
        List<Integer> gas = Arrays.asList( 1, 4, 1 );
        List<Integer> costs = Arrays.asList( 2, 1, 3 );
        int res = s.canCompleteCircuit( gas, costs );
        Assert.assertEquals( 1, res );

    }

    @Test
    public void canCompleteCircuitZeros() {

        Solution s = new Solution();
        List<Integer> gas = Arrays.asList( 0 );
        List<Integer> costs = Arrays.asList( 0 );
        int res = s.canCompleteCircuit( gas, costs );
        Assert.assertEquals( 0, res );

    }
}