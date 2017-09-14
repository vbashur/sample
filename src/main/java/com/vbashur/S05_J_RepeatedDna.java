package com.vbashur;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by victor.bashurov on 14.09.2017.
 */
public class S05_J_RepeatedDna {
/*
    public List<String> findRepeatedDnaSequences(String s) {

        List<String> result = new LinkedList<String>();
        for (String entry : considerDnaFrame(s, 0, new HashSet<String>(), new HashSet<String>())) {
            result.add(entry);
        }
        return result;
    }


    Set<String> considerDnaFrame(String dna, int index, Set<String> resolvedDna, Set<String> resList) {
        if (index + 10 < dna.length()) {
            String currentDna = dna.substring(index, index + 10);
            if (resolvedDna.contains(currentDna)) {
                resList.add(currentDna);
                resList.addAll(considerDnaFrame(dna, index + 1, resolvedDna, resList));
                return resList;
            } else {
                resolvedDna.add(currentDna);
                return considerDnaFrame(dna, index + 1, resolvedDna, resList);
            }
        }
        return resList;
    }
*/
}
