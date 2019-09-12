package com.vbashur.math.numberoflengthn;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void solve() {
        Solution s  = new Solution();
        ArrayList<Integer> al = new ArrayList<>();
        al.add(0);
        al.add(1);
        al.add(5);
        System.out.println("sol:" + s.solve(al, 1, 2));
        al.clear();
        al.add(0);
        al.add(1);
        al.add(2);
        al.add(5);
        System.out.println("sol:" + s.solve(al, 2, 21));
    }
}