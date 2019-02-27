package com.vbashur.bits.reverse_bits;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void reverse() {

        Solution s = new Solution();
        long res = s.reverse( 5 );
//        Assert.assertEquals(5, res);
        res = s.reverse( 3 );
        Assert.assertEquals(3221225472L, res);

        res = s.reverseEditoral( 3 );
        Assert.assertEquals(3221225472L, res);

        System.out.println("5 | 2 = " + (5 | 2)  );
        System.out.println("5 & 2 = " + (5 & 2)  );
        System.out.println("5 ^ 2 = " + (5 ^ 2)  );
        System.out.println("5 >> 2 = " + (5 >> 2)  );
        System.out.println("5 << 2 = " + (5 << 2)  );
        System.out.println("15 >> 1 = " + (15 >> 1)  );
        System.out.println("15 << 1 = " + (15 << 1)  );
    }
}