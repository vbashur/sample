package com.vbashur.array.prettyprint;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

public class SolutionTest {


    @Test
    public void test() {

        int A = 2;
        Solution s = new Solution();
        print(s.prettyPrint( 14 ));
        System.out.println( "------------" );
        print(s.prettyPrint( 3 ));
        System.out.println( "------------" );
        print(s.prettyPrint( 6 ));

        System.out.println("Hyp: " + Math.hypot(3, 3));

    }

    void print(ArrayList<ArrayList<Integer>> res) {
        for (ArrayList<Integer> arr : res) {
            System.out.println(arr);
        }
    }



}