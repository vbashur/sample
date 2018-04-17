package com.vbashur;

/**
 * Created by victor.bashurov on 26.09.2017.
 *
 * https://leetcode.com/problems/ugly-number/discuss/
 *
 Write a program to check whether a given number is an ugly number.

 Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

 Note that 1 is typically treated as an ugly number.
 */
public class S09_J_UglyNum {

    public boolean isUgly(int num) {
//        if (num < 1) return false;
//        if (num == 1 || num == 3 || num == 5) return true;
//        Set<Integer> nums = new HashSet<Integer>();
//        Set<Integer> primes = new HashSet<Integer>();
//        for (int iter = 2; iter <= Math.abs(num); ++iter) {
//            int step = iter;
//            if (!nums.contains(iter)) {
//                primes.add(iter);
//            }
//            while (step <= Math.abs(num)) {
//                nums.add(step);
//                step += iter;
//            }
//        }
//        if (Math.abs(num) %2 == 0 && primes.contains(Math.abs(num) /2) && (Math.abs(num) /2  == 2)) {
//            System.out.println(Math.abs(num) %2);
//            System.out.println(primes.contains(Math.abs(num) /2));
//            System.out.println(Math.abs(num) /2);
//            return false;
//        }
//        if (Math.abs(num) %3 == 0 && primes.contains(Math.abs(num) /3) && (Math.abs(num) /3  == 3)) return false;
//        if (Math.abs(num) %5 == 0 && primes.contains(Math.abs(num) /5)&& (Math.abs(num) /5  == 5)) return false;
//        return true;


        if (num <= 0) {
            return false;
        }

        int[] divisors = {2, 3, 5};

        for (int d : divisors) {
            while (num % d == 0) {
                num /= d;
            }
        }
        return num == 1;

    }
}
