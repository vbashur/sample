package com.vbashur.graph.critical_connections;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SolutionTest {

    @Test
    public void criticalConnections() {

        int n = 4;
        List<java.util.List<Integer>> connections = new LinkedList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));

        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList(Arrays.asList(1, 3)), s.criticalConnections(n, connections));

    }
}
