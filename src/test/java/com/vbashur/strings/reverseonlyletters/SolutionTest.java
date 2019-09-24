package com.vbashur.strings.reverseonlyletters;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {


    Solution s = new Solution();

    @Test
    public void reverseOnlyLetters() {
        assertEquals("dc-ba", s.reverseOnlyLetters("ab-cd"));
        assertEquals("a-bC-dEf-ghIj", s.reverseOnlyLetters("j-Ih-gfE-dCba"));

    }

    @Test
    public void isLetter() {
        assertTrue(s.isLetter('r'));
        assertTrue(s.isLetter('R'));
        assertFalse(s.isLetter('1'));
        assertFalse(s.isLetter('!'));
    }
}
