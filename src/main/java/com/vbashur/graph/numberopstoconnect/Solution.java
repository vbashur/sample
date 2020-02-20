package com.vbashur.graph.numberopstoconnect;


import java.util.List;
import java.util.Map;

/*
20.02.2020
https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 */
public class Solution {
/*
    public int makeConnected(int n, int[][] connections) {
        Component[] connComps = getComponents(connections);
        int compsWithoutCycles = getCompsWithoutCycles(connComps);
        int counter = 0;
        while(getCompWithCycle() != null && compWithoutCycles > 1) {
            Component cycled = getCompWithCycle();
            cycled.breakCycle();
            --compWithoutCycles;
            counter++;
        }
        if (compWithoutCycles > 1) return -1;
        return counter;

    }


    class Component {
        private Map<Integer, List<Integer>> graph;
        int cycles;

        public Component() {

        }

        boolean hasCycles() {
            return cycles > 0;
        }

        int breakCycle() {
            --cycles;
            return cycles;
        }


    }


 */
}
