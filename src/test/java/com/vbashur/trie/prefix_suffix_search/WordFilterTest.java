package com.vbashur.trie.prefix_suffix_search;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordFilterTest {


    @Test
    public void test() {
        String[] testString = new String[] {"abacabac", "def", "ape","apple", "abacklgjlaubac"};
//        String[] testString = new String[] {"ab"};
        WordFilter wf = new WordFilter(testString);

        System.out.println(wf.prefixes);
        System.out.println(wf.postfixes);
//        System.out.println(wf.f("a", "e"));
        System.out.println(wf.f("abac", "abac"));
    }

}