package com.vbashur.array.prettyprint;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {


    @Test
    public void test() {

        int A = 2;
        Solution s = new Solution();
        s.prettyPrint( 14 );
        System.out.println( "------------" );
        s.prettyPrint( 3 );
        System.out.println( "------------" );
        s.prettyPrint( 6 );

    }



}