package com.vbashur.hashing.points_straight_line;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*




Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Sample Input :

(1, 1)
(2, 2)

Sample Output :

2

You will be give 2 arrays X and Y. Each point is represented by (X[i], Y[i])


 */
/*
/**
 * Created by vic on 18/02/19.
 * <p>
 * https://www.interviewbit.com/problems/points-on-the-straight-line/
 */
public class Solution {

    public int maxPoints( ArrayList<Integer> a, ArrayList<Integer> b ) {
        Map<Double, Integer> radCounterMap = new HashMap<>();
        if( a == null || b == null || a.size() == 0 || b.size() == 0 ) return 0;
        if( a.size() == 1 || b.size() == 1 ) return 1;
        for( int iter = 0; iter < a.size(); ++iter ) {
            for( int j = 1; j + iter < b.size(); ++j ) {
//                if (j == iter) continue;
//                System.out.println( a.get(j) + ":" + b.get(j) + " -> " + a.get(iter) + ":" + b.get(iter)  );
                double angle = angleOf( b.get( j ), b.get( iter ), a.get( j ), a.get( iter ) );
                Integer counter = 0;
                if( radCounterMap.containsKey( angle ) ) {
                    counter = radCounterMap.get( angle );

                }
                radCounterMap.put( angle, counter + 1 );
            }
//            System.out.println(">>" + radCounterMap);
        }
        int max = 1;
        for( Double rad : radCounterMap.keySet() ) {
            if( radCounterMap.get( rad ) > max ) {
                max = radCounterMap.get( rad );
            }
        }
        return max + 1;
    }

    public double angleOf( int y2, int y1, int x2, int x1 ) {
        final double deltaY = y2 - y1;
        final double deltaX = x2 - x1;
        final double result = Math.toDegrees( Math.atan2( deltaY, deltaX ) );
        double positiveRes = (result < 0) ? (360d + result) : result;
        return (positiveRes > 180) ? (positiveRes - 180d) : positiveRes;
    }
}
