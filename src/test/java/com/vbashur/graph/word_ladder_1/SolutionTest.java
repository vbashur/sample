package com.vbashur.graph.word_ladder_1;

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
        Integer path = s.ladderLength( "hit", "cog", dict );
        Assert.assertEquals( Integer.valueOf( 5 ), path );

    }

    @Test
    public void simpleBaseTest2() {
        ArrayList<String> dict = new ArrayList<>();
        dict.addAll( Arrays.asList(  ) );
        Integer path = s.ladderLength( "bb", "bb", dict );
        Assert.assertEquals( Integer.valueOf( 1 ), path );

    }

    @Test
    public void simpleSingleTest() {
        ArrayList<String> dict = new ArrayList<>();
//        dict.addAll( Arrays.asList("hot","dot","dog","lot","log") );
        Integer path = s.ladderLength( "hit", "hot", dict );
        Assert.assertEquals( Integer.valueOf( 2 ), path );

    }

    @Test
    public void simpleSingleTest2() {
        ArrayList<String> dict = new ArrayList<>();
        dict.addAll( Arrays.asList( "hot" ) );
        Integer path = s.ladderLength( "hit", "dot", dict );
        Assert.assertEquals( Integer.valueOf( 3 ), path );

    }

    @Test
    public void simpleSingleTest3() {
        ArrayList<String> dict = new ArrayList<>();
        dict.addAll( Arrays.asList( "hot" ) );
        Integer path = s.ladderLength( "hit", "hut", dict );
        Assert.assertEquals( Integer.valueOf( 2 ), path );
    }
}