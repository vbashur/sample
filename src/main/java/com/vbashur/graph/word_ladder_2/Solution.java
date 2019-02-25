package com.vbashur.graph.word_ladder_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/*
Given two words (start and end), and a dictionary, find the shortest transformation sequence from start to end, such that:

        Only one letter can be changed at a time
        Each intermediate word must exist in the dictionary

If there are multiple such sequence of shortest length, return all of them. Refer to the example for more details.

Example :

Given:

start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]

Return

  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]


 */
/**
 * Created by vic on 25/02/19.
 * <p>
 * https://www.interviewbit.com/problems/word-ladder-ii/
 */
public class Solution {

    private Map<String, LinkedList<String>> adjMap = new HashMap<>();
    ArrayList<ArrayList<String>> resList = new ArrayList<>(  );

    public ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> dict) {
        ArrayList<String> allWords = getAllWords( start, end, dict );
        setupAdjGraph( allWords );
//        ArrayList<ArrayList<String>> resList = new ArrayList<>(  );
        if (!allWords.isEmpty()) {
            List<String> path = new LinkedList<>();
            path.add( start );
            dfs(start, path, end);
        }

        Integer minSize = Integer.MAX_VALUE;
        for (List<String> ps : resList){
            if (ps.size() < minSize) minSize = ps.size();

        }

        ArrayList<ArrayList<String>> res = new ArrayList<>(  );
        for (ArrayList<String> ps : resList){
            if (ps.size() == minSize) res.add( ps );
        }

        return res;
    }

    private void dfs(String v, List<String> path, String end) {
        LinkedList<String> adjVertices = getAdjacentVertices( v );
        while( !adjVertices.isEmpty() ) {
            String childV = adjVertices.pollLast();
            ArrayList<String> pathNew = new ArrayList<>( path );
            pathNew.add( childV );
            if (childV.equals( end )) {
                resList.add( pathNew );
            } else {
                dfs(childV, pathNew, end);
            }
        }

    }


    private LinkedList<String> getAdjacentVertices(String s) {
        return adjMap.get( s );
    }

    private ArrayList<String> getAllWords( String start, String end, ArrayList<String> dict ) {
        ArrayList<String> res = new ArrayList<>();
        res.add( start );
        res.addAll( dict );
        res.add( end );
        return res;
    }

    private void setupAdjGraph(ArrayList<String> dict) {
        for (int iter = 0; iter < dict.size() - 1; ++iter) {
            for (int j = iter + 1; j < dict.size(); ++j) {
                if (isAdjacentWords( dict.get( iter ), dict.get( j ) )) {
                    putToAdjMap( dict.get( iter ), dict.get( j ) );
                    putToAdjMap( dict.get( j ), dict.get( iter ) );
                }
            }

        }
    }

    private boolean isAdjacentWords(String s1, String s2) {
        int numDiffs = 0;
        for (int iter = 0; iter < s1.length(); ++iter) {
            if (s1.charAt( iter ) != s2.charAt( iter )) {
                ++numDiffs;
            }
        }
        return numDiffs == 1;
    }


    private void putToAdjMap(String s1, String s2) {
        if (adjMap.containsKey( s1)) {
            adjMap.get( s1 ).add( s2 );
        } else {
            LinkedList<String> adjList = new LinkedList<>();
            adjList.add( s2 );
            adjMap.put( s1, adjList );
        }
    }

}
