package com.vbashur.graph.word_ladder_1;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


/*
Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

        You must change exactly one character in every transformation
        Each intermediate word must exist in the dictionary

        Example :

        Given:

        start = "hit"
        end = "cog"
        dict = ["hot","dot","dog","lot","log"]

        As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
        return its length 5.

        Note that we account for the length of the transformation path instead of the number of transformation itself.

        Note:

        Return 0 if there is no such transformation sequence.
        All words have the same length.
        All words contain only lowercase alphabetic characters.

*/
/**
 * Created by vic on 19/02/19.
 * <p>
 * https://www.interviewbit.com/problems/word-ladder-i/
 */
public class Solution {

    public int ladderLength( String start, String end, ArrayList<String> dictV ) {
        dictV.add( end );
        Graph g = new Graph();
        for( String dictItem : dictV ) {
            if( g.isAdjacent( start, dictItem ) ) {
                g.put( start, dictItem );
            }
        }
        for( int iter = 0; iter < dictV.size(); ++iter ) {
            for( int j = 0; j < dictV.size(); ++j ) {
                if( iter != j ) {
                    if( g.isAdjacent( dictV.get( iter ), dictV.get( j ) ) ) {
                        g.put( dictV.get( iter ), dictV.get( j ) );
                    }
                }
            }
        }
        Integer pathes = g.getPathes( start, end );
        return pathes;
    }


    public class Graph {

        private Map<String, List<String>> adjacents = new HashMap<>();

        public void put( String v1, String v2 ) {
            if( !adjacents.containsKey( v1 ) ) {
                List<String> adjList = new LinkedList<>();
                adjList.add( v2 );
                adjacents.put( v1, adjList );
            } else {
                adjacents.get( v1 ).add( v2 );
            }

            if( !adjacents.containsKey( v2 ) ) {
                List<String> adjList = new LinkedList<>();
                adjList.add( v1 );
                adjacents.put( v2, adjList );
            } else {
                adjacents.get( v2 ).add( v1 );
            }
        }

        public boolean isAdjacent( String v1, String v2 ) {
            int counter = 0;
            for( int iter = 0; iter < v1.length(); ++iter ) {
                if( v1.charAt( iter ) == v2.charAt( iter ) ) ++counter;
            }
            return counter == v1.length() - 1;
        }

        public Integer getPathes( String start, String end ) {
            Map<String, Integer> pathes = new HashMap<>();
            Set<String> marked = new HashSet<>();
            LinkedList<String> queue = new LinkedList<>();
            queue.add( start );
            marked.add( start );
            int iter = 1;
            pathes.put( start, iter );
            while( !queue.isEmpty() ) {
                String vert = queue.pollFirst();
                if (adjacents != null && adjacents.containsKey( vert ))
                for( String adjV : adjacents.get( vert ) ) {
                    if( !marked.contains( adjV ) ) {
                        queue.add( adjV );
                        marked.add( adjV );
                        Integer parentCounter = pathes.get( vert );
                        pathes.put( adjV, parentCounter + 1 );
                    }
                }
            }
            return pathes.get( end );
        }
    }
}
