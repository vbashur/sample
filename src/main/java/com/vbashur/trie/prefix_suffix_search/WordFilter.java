package com.vbashur.trie.prefix_suffix_search;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
08/02/2020
https://leetcode.com/problems/prefix-and-suffix-search/
 */
public class WordFilter {

    public Trie prefixes = new Trie();
    public Trie postfixes = new Trie();

    public WordFilter(String[] words) {

        for (int iter = 0; iter < words.length; ++iter) {
            Trie curr = prefixes;
            for (int i = 0; i < words[iter].length(); ++i) {
                String symb = words[iter].substring(i, i + 1);
                if (!curr.values.containsKey(symb)) {
                    Trie newTrie = new Trie();
                    curr.values.put(symb, newTrie);
                    curr.indices.offer(iter);
                    curr = newTrie;
                } else {
                    curr.indices.offer(iter);
                    curr = curr.values.get(symb);
                }

            }
        }

        for (int iter = 0; iter < words.length; ++iter) {
            Trie curr = postfixes;
            for (int i = words[iter].length() - 1; i >= 0; --i) {
                String symb = words[iter].substring(i, i + 1);
                if (!curr.values.containsKey(symb)) {
                    Trie newTrie = new Trie();
                    curr.values.put(symb, newTrie);
                    curr.indices.offer(iter);
                    curr = newTrie;
                } else {
                    curr.indices.offer(iter);
                    curr = curr.values.get(symb);
                }
            }
        }

    }

    public int f(String prefix, String suffix) {
        suffix = getReverted(suffix);
        PriorityQueue<Integer> prefPQ = getWeights(prefix, prefixes);
        PriorityQueue<Integer> suffPQ = getWeights(suffix, postfixes);
        if (prefPQ != null && suffPQ != null) {
            while (!prefPQ.isEmpty()
             && !suffPQ.isEmpty()) {
                int prefPeek = prefPQ.peek();
                int suffPeak = suffPQ.peek();
                if (suffPeak == prefPeek) {
                    return suffPeak;
                }
                if (suffPeak > prefPeek) {
                    suffPQ.poll();
                } else {
                    prefPQ.poll();
                }
            }

        }
        return -1;
    }

    private String getReverted(String suffix) {
        char[] reverted = new char[suffix.length()];
        for (int iter = suffix.length() - 1; iter >= 0; --iter) {
            reverted[suffix.length() - 1 - iter] = suffix.charAt(iter);
        }
        return new String(reverted);
    }

    PriorityQueue<Integer> getWeights(String word, Trie tmpPrefixes) {
        for (int iter = 0; iter < word.length(); ++iter) {
            String symb = word.substring(iter, iter + 1);
            if (tmpPrefixes.values.containsKey(symb)) {
                if (iter == word.length() - 1) {
                    return tmpPrefixes.values.get(symb).indices;
                }
                tmpPrefixes = tmpPrefixes.values.get(symb);
            } else {
                return null;
            }
        }
        return null;
    }

    private static class Trie {
        public PriorityQueue<Integer> indices = new PriorityQueue<>((e1, e2) -> e2.compareTo(e1));
        //        public String key;
        public Map<String, Trie> values = new HashMap<>();

//        @Override
//        public String toString() {
//            return "Trie{" +
//                    "indices=" + indices +
//                    "\n\t, values=" + values +
//                    '}';
//        }
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */



