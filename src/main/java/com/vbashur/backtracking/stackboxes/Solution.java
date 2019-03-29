package com.vbashur.backtracking.stackboxes;


/*
how many boxes could be placed one in another - givw a maximum number
 */

import java.util.Comparator;
import java.util.LinkedList;
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

        public Box( int w, int h, int d ) {
            this.w = w;
            this.h = h;
            this.d = d;
        }

        public boolean less( Box other ) {
            List<int[]> box1Dims = new LinkedList<>();
            int[] box1DimArray = new int[] { this.d, this.h, this.w };
            doPerm( box1Dims, box1DimArray, box1DimArray.length );
            printPerms(box1Dims);
            List<int[]> box2Dims = new LinkedList<>();
            int[] box2DimArray = new int[] { other.d, other.h, other.w };
            doPerm( box2Dims, box2DimArray, box2DimArray.length );
            printPerms(box2Dims);
            for( int[] box1Arr : box1Dims ) {
                for( int[] box2Arr : box2Dims ) {
                    boolean isLess = true;
                    for( int iter = 0; iter < box1Arr.length && isLess; ++iter ) {
                        if( box1Arr[iter] < box2Arr[iter] ) {
                            isLess = false;
                        }
                    }
                    if( isLess ) return true;
                }
            }
            return false;

        }

        public void doPerm( List<int[]> dimList, int[] dimensions, int index ) {

            if( index <= 0 )
                dimList.add( dimensions );
            else { //recursively solve this by placing all other items at current first pos
                doPerm( dimList, dimensions, index - 1 );
                int currPos = dimensions.length - index;
                for( int i = currPos + 1; i < dimensions.length; i++ ) {//start swapping all other items with current first item
                    swap( dimensions, currPos, i );
                    doPerm( dimList, dimensions, index - 1 );
                    swap( dimensions, i, currPos );//restore back
                }
            }
        }

        private void swap( int[] input, int a, int b ) {
            int tmp = input[a];
            input[a] = input[b];
            input[b] = tmp;
        }

        private void printPerms(List<int[]> boxDims) {
            System.out.println( "print permutations:" );
            for (int[] dims : boxDims) {
                for (int i = 0; i < dims.length; ++i ) {
                    System.out.print(dims[i] + " " );
                }
                System.out.println( );
            }
        }

    }


    public int getStackedBoxes( List<Box> boxes ) {
        boxes.sort( boxComparator );
        int maxSequence = Integer.MIN_VALUE;
        if( boxes == null || boxes.size() == 1 ) {
            return 1;
        }
        for( int iter = 0; iter < boxes.size() - 1; ++iter ) {
            int counter = 1;
            while( boxes.get( iter ).less( boxes.get( iter + 1 ) ) ) {
                ++counter;
                if( counter > maxSequence ) maxSequence = counter;
            }
        }
        return maxSequence;

    }

    public Comparator<Box> boxComparator = new Comparator<Box>() {
        @Override
        public int compare( Box o1, Box o2 ) {
            return o2.less( o1 ) ? 1 : -1;
        }
    };


//    public void doPerm(List<int[]> dimList, int[] dimensions, int index){
//
//        if(index <= 0)
//            dimList.add(dimensions);
//        else { //recursively solve this by placing all other chars at current first pos
//            doPerm(dimList, dimensions, index-1);
//            int currPos = dimensions.length-index;
//            for (int i = currPos+1; i < dimensions.length; i++) {//start swapping all other chars with current first char
//                swap(dimensions,currPos, i);
//                doPerm(dimList, dimensions, index-1);
//                swap(dimensions,i, currPos);//restore back my string buffer
//            }
//        }
//    }
//

//    public int[] getBoxDimensions(Box box) {
//        int[] indexes = new int[]{box.w, box.h, box.d};
//        int i = 0;
//        while (i < indexes.length) {
//            if (indexes[i] < i) {
//                swap(indexes, i % 2 == 0 ?  0: indexes[i], i);
//                indexes[i]++;
//                i = 0;
//            }
//            else {
//                indexes[i] = 0;
//                i++;
//            }
//        }
//    }
//
//    public void shuffleAllRecursive( int n, int[] elements) {
//
//        if(n == 1) {
//            return;
//        } else {
//            for(int i = 0; i < n-1; i++) {
//                shuffleAllRecursive(n - 1, elements);
//                if(n % 2 == 0) {
//                    swap(elements, i, n-1);
//                } else {
//                    swap(elements, 0, n-1);
//                }
//            }
//            shuffleAllRecursive(n - 1, elements);
//        }
//    }


}
