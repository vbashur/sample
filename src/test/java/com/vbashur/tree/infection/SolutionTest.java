package com.vbashur.tree.infection;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    Solution s = new Solution();

    @Test
    public void getSourceSimpleSingle() {
        List<Solution.Route> routes = new LinkedList<>(  );
        routes.add( new Solution.Route( "E", "D" ) );
        routes.add( new Solution.Route( "B", "A" ) );
        routes.add( new Solution.Route( "C", "D" ) );
        routes.add( new Solution.Route( "B", "E" ) );
        routes.add( new Solution.Route( "B", "C" ) );
        List<String> res = s.getSource( routes );
        System.out.print( res );
        Assert.assertEquals(1, res.size() );
        Assert.assertEquals("B", res.get( 0 ) );
    }

    @Test
    public void getSourceSimpleDouble() {
        List<Solution.Route> routes = new LinkedList<>(  );
        routes.add( new Solution.Route( "E", "D" ) );
        routes.add( new Solution.Route( "B", "A" ) );
        routes.add( new Solution.Route( "F", "G" ) );
        routes.add( new Solution.Route( "I", "J" ) );
        routes.add( new Solution.Route( "G", "I" ) );
        routes.add( new Solution.Route( "F", "H" ) );
        routes.add( new Solution.Route( "C", "D" ) );
        routes.add( new Solution.Route( "B", "E" ) );
        routes.add( new Solution.Route( "B", "C" ) );
        List<String> res = s.getSource( routes );
        System.out.print( res );
        Assert.assertEquals(2, res.size() );
        Assert.assertTrue(res.contains( "B" ) );
        Assert.assertTrue(res.contains( "F" ) );
    }

    @Test
    public void getSourceBoundedDouble() {
        List<Solution.Route> routes = new LinkedList<>(  );
        routes.add( new Solution.Route( "E", "D" ) );
        routes.add( new Solution.Route( "B", "A" ) );
        routes.add( new Solution.Route( "F", "G" ) );
        routes.add( new Solution.Route( "I", "J" ) );
        routes.add( new Solution.Route( "G", "I" ) );
        routes.add( new Solution.Route( "F", "H" ) );
        routes.add( new Solution.Route( "C", "D" ) );
        routes.add( new Solution.Route( "B", "E" ) );
        routes.add( new Solution.Route( "B", "C" ) );
        routes.add( new Solution.Route( "J", "D" ) );
        List<String> res = s.getSource( routes );
        System.out.print( res );
        Assert.assertEquals(2, res.size() );
        Assert.assertTrue(res.contains( "B" ) );
        Assert.assertTrue(res.contains( "F" ) );
    }
}