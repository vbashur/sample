package com.vbashur.array.findduplicate;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//https://www.interviewbit.com/problems/find-duplicate-in-array/
public class Solution {

    // DO NOT MODIFY THE LIST
    public int repeatedNumber(final List<Integer> a) {

        Set<Integer> uniques = new HashSet<>();
        List<Integer> integers = a.stream().filter(el -> !uniques.add(el)).collect(Collectors.toList());
        return integers.isEmpty() ? -1 : integers.iterator().next();
    }
}
