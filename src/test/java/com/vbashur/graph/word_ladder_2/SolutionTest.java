package com.vbashur.graph.word_ladder_2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;


public class SolutionTest {

    Solution s = new Solution();

    @Test
    public void simpleBaseTest() {
        ArrayList<String> dict = new ArrayList<>();
        dict.addAll( Arrays.asList( "hot", "dot", "dog", "lot", "log" ) );
        ArrayList<ArrayList<String>>  path = s.findLadders("hit", "cog", dict );
        System.out.println(path);

    }

    @Test
    public void simpleBaseTest2() {
        ArrayList<String> dict = new ArrayList<>();
        dict.addAll( Arrays.asList(  ) );
        ArrayList<ArrayList<String>>  path = s.findLadders("bb", "ab", dict );
        System.out.println(path);

    }



}