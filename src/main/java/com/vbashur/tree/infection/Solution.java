package com.vbashur.tree.infection;

/*
Infection is widely spreaded among the world, find the all possible sources of the infection

input: AB, BC, BD, DF - output: A
input: MK, LJ, KL, FM - output: M
input: MK, LJ, KL, FM, TW - output: M, T
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * Created by vic on 28/03/19.
 * <p>
 * from real stage
 */
public class Solution {

    public static class Route {
        public Route( String source, String destination ) {
            this.src = source;
            this.dest = destination;
        }

        public String src;
        public String dest;
    }

    public List<String> getSource( List<Route> routes ) {
        Map<String, String> sources = new HashMap<>();
        for( Route r : routes ) {
            String source = r.src;
            String dest = r.dest;
            sources.put( dest, source );
            if( !sources.containsKey( source ) ) {
                sources.put( source, null );
            }
        }
        List<String> sourcesRes = new LinkedList<>();
        for( String key : sources.keySet() ) {
            if( sources.get( key ) == null ) {
                sourcesRes.add( key );
            }
        }
        return sourcesRes;
    }
}
