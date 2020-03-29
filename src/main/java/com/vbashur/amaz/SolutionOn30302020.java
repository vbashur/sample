package com.vbashur.amaz;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Test ID: 23280666274486
 */
public class SolutionOn30302020 {


    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public ArrayList<String> popularNFeatures(int numFeatures,
                                              int topFeatures,
                                              List<String> possibleFeatures,
                                              int numFeatureRequests,
                                              List<String> featureRequests) {
        Map<String, Integer> countMap = new HashMap<>();
        possibleFeatures.forEach(pf -> countMap.put(pf, 0));

        for(String fr : featureRequests) {
            String[] words = fr.split(" ");
            Set<String> set = new HashSet<>();

            for (int iter = 0; iter < words.length; ++iter) {
                set.add(words[iter]);
            }
            set.forEach(w -> {
                if (countMap.containsKey(w)) {
                    Integer currCounter = countMap.get(w);
                    countMap.put(w, currCounter + 1);
                }
            });


        }
        LinkedList<StrIntPair> pq = new LinkedList<>();

        for (String key : countMap.keySet()) {
            pq.add(new StrIntPair(key, countMap.get(key)));
        }

        pq.sort((pair1, pair2) -> pair2.counter.compareTo(pair1.counter));
        new ArrayList<String>().addAll(pq.subList(0, 3).stream().map(p->p.key).collect(Collectors.toList()));

        ArrayList<String> popularNFeatures = new ArrayList<>(numFeatureRequests);
        for (int iter = 0; iter < numFeatureRequests; ++iter) {
            popularNFeatures.add(pq.pollFirst().key);
        }

        return popularNFeatures;
        // WRITE YOUR CODE HERE
    }
    // METHOD SIGNATURE ENDS

    class StrIntPair implements Comparable<StrIntPair> {
        String key;
        Integer counter;

        StrIntPair(String k, Integer c) {
            this.key = k;
            this.counter = c;
        }

        public int compareTo(StrIntPair other) {
            return this.counter.compareTo(other.counter);
        }

    }
}
