package com.vbashur.strings.maxnumbaloons;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void maxNumberOfBalloons() {
        Solution s = new Solution();
        System.out.println(s.maxNumberOfBalloons("nlaebolko"));
        System.out.println(s.maxNumberOfBalloons("loonbalxballpoon"));

        System.out.println(s.maxNumberOfBalloons("loonba"));
    }
}
