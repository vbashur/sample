package com.vbashur.array.repeat_and_missing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vic on 4/25/18.
 * https://www.interviewbit.com/problems/repeat-and-missing-number-array/
 *
 * You are given a read only array of n integers from 1 to n.

 Each integer appears exactly once except A which appears twice and B which is missing.

 Return A and B.

 Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 Note that in your output A should precede B.
 */
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        long factorial = getFact(A.size());
        long mult = 1;
        for (int iter = 0; iter < A.size(); ++iter) {
            mult *= A.get(iter);
        }
        if (mult > factorial && mult % factorial == 0) {
            factorial = factorial / (mult/factorial);
        }


        else if (factorial > mult && factorial % mult== 0) {
            mult = mult / (factorial/mult);
        }



        return new ArrayList<Integer>(Arrays.asList(gcd(mult, factorial).intValue()));
    }

    public long getFact(long limit) {
        if (limit == 1) return limit;
        return limit * getFact(limit - 1);
    }

    public Long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);

    }
}
