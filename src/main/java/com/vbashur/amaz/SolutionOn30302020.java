package com.vbashur.amaz;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

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
            for (int iter = 0; iter < words.length; ++iter) {
                if (countMap.containsKey(words[iter])) {
                    Integer currCounter = countMap.get(words[iter]);
                    countMap.put(words[iter], currCounter + 1);
                }
            }
        }
        PriorityQueue<StrIntPair> pq = new PriorityQueue<>();

        for (String key : countMap.keySet()) {
            pq.add(new StrIntPair(key, countMap.get(key)));
        }

        ArrayList<String> popularNFeatures = new ArrayList<>(numFeatureRequests);
        for (int iter = 0; iter < numFeatureRequests; ++iter) {
            popularNFeatures.add(pq.poll().key);
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
