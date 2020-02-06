package com.vbashur.trie.prefix_suffix_search;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

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
                    curr = curr.values.get(symb);
                }

            }
        }

//        Trie postfixes = new Trie();
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
                    curr = curr.values.get(symb);
                }
            }
        }


        /*
        for (int iter = 0; iter < words.length; ++iter ){
            Map<String, Map> currMap = prefixes;
            for (int i = 0; i < words[iter].length(); ++i) {
                String symb = words[iter].substring(i, i+1);
                if (!currMap.containsKey(symb)) {
                    Map newMap = new HashMap<>();
                    currMap.put(symb, newMap);
                    currMap = newMap;
                } else {
                    currMap = currMap.get(symb);
                }
            }
        }

        for (int iter = 0; iter < words.length; ++iter ){
            Map<String, Map> currMap = postfixes;
            for (int i = words[iter].length() - 1; i >= 0 ; --i) {
                String symb = words[iter].substring(i, i+1);
                if (!currMap.containsKey(symb)) {
                    Map newMap = new HashMap<>();
                    currMap.put(symb, newMap);
                    currMap = newMap;
                } else {
                    currMap = currMap.get(symb);
                }
            }
        }*/


    }

    public int f(String prefix, String suffix) {
        return 2;

    }

    private class Trie {
        public PriorityQueue<Integer> indices = new PriorityQueue<>((e1, e2) -> e2.compareTo(e1));
        //        public String key;
        public Map<String, Trie> values = new HashMap<>();

        @Override
        public String toString() {
            return "Trie{" +
                    "indices=" + indices +
                    ", values=" + values +
                    '}';
        }
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */

