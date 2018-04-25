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

        Long duplicatedNum = lcm(factorial, mult) / factorial;

        Long actualSum = Long.valueOf(0);
        for (int iter = 0; iter < A.size(); ++iter) {
            actualSum += A.get(iter);
        }
        Long expectedSum = getExpectedSum(A.size());
        Long missedNum = expectedSum - actualSum + duplicatedNum;
        return new ArrayList<>(Arrays.asList(duplicatedNum.intValue(), missedNum.intValue()));
    }

    public long getFact(long limit) {
        if (limit == 1) return limit;
        return limit * getFact(limit - 1);
    }

    public long getExpectedSum(long limit) {
        if (limit == 0) return limit;
        return limit + getExpectedSum(limit - 1);
    }

    /*
    The greatest common divisor
     */
    public Long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    /*
    Least common multiple
     */
    public Long lcm(long a, long b) {
        Long gcd = gcd(a, b);
        return Math.abs(a * b) / gcd;
    }
}
