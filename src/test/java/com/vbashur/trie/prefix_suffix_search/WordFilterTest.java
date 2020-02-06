package com.vbashur.trie.prefix_suffix_search;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordFilterTest {


    @Test
    public void test() {
        String[] testString = new String[] {"abc", "def", "apple"};
        WordFilter wf = new WordFilter(testString);
        System.out.println(wf.prefixes);
        System.out.println(wf.postfixes);
    }

}