package com.vbashur.array.repeatednum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//https://www.interviewbit.com/problems/repeat-and-missing-number-array/
public class Solution {

    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {

        Set<Integer> nonUniques = new HashSet<>();
        List<Integer> nu = A.stream().filter(el -> !nonUniques.add(el)).collect(Collectors.toList());
        int counter = 0;
        int nominalCounter = 0;
        for (int i = 0; i < A.size(); ++i) {
            nominalCounter += (i + 1);
            counter += A.get(i);
        }
        int dupl = nu.iterator().next();
        System.out.println("counter = " + counter);
        System.out.println("nominalCounter = " + nominalCounter);
        System.out.println("dupl = " + dupl);
        int missed = dupl - (counter - nominalCounter);
        ArrayList<Integer> res = new ArrayList<>();
        res.add(dupl);
        res.add(missed);
        return res;

    }
}
