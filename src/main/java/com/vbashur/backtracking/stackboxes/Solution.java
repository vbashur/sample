package com.vbashur.backtracking.stackboxes;


/*
how many boxes could be placed one in another - give a maximum number
 */

import java.util.Comparator;
import java.util.List;

/*
 * Created by vic on 29/03/19.
 * <p>
 * from real stage
 */
public class Solution {


    public static class Box {
        int w;
        int h;
        int d;
        String name;

        public Box( int w, int h, int d ) {
            this.w = w;
            this.h = h;
            this.d = d;
        }

        public Box(String name, int w, int h, int d ) {
            this.w = w;
            this.h = h;
            this.d = d;
            this.name = name; // for test purposes
        }

        public boolean less( Box other ) {

            int[] thisBox = new int[] { this.d, this.h, this.w };
            int[] otherBox = new int[] { other.d, other.h, other.w };
            for( int i = 0; i < thisBox.length; ++i ) {
                if( thisBox[i] >= otherBox[i] ) return false;
            }
            return true;
        }

        public String toString() {
            return name;
        }
    }

    public int getStackedBoxes( List<Box> boxes ) {
        boxes.sort( boxComparator );
        System.out.println(boxes);
        int maxSequence = Integer.MIN_VALUE;
        if( boxes == null || boxes.size() == 1 ) {
            return 1;
        }
        for( int iter = 0; iter < boxes.size() - 1; ++iter ) {
            int counter = 1;
            while( (iter < boxes.size() - 1) && boxes.get( iter ).less( boxes.get( iter + 1 ) ) ) {
                ++counter;
                if( counter > maxSequence ) maxSequence = counter;
                ++iter;
            }
        }
        return maxSequence;

    }

    public Comparator<Box> boxComparator = new Comparator<Box>() {
        @Override
        public int compare( Box o1, Box o2 ) {
            return o1.less( o2 ) ? -1 : 1;
        }
    };
}
