package com.vbashur.strings.length_last_word;

import java.util.LinkedList;

/**
 * Created by vic on 3/13/19.
 */
public class Solution {

    public int lengthOfLastWord(final String A) {
        LinkedList<Character> normalizedReversedString = getReversedLastWord(A);
        //StringBuilder res = new StringBuilder();
        //while (!normalizedReversedString.isEmpty()) {
        //	res.append(normalizedReversedString.pollLast());
        //}
        return normalizedReversedString.size();
    }

    private LinkedList<Character> getReversedLastWord(String line) {
        int index = line.length() - 1;
        boolean isWordDetected = false;
        boolean isLastSpaceDetected = false;
        LinkedList<Character> chars = new LinkedList<Character>();
        while (index >= 0 && !isLastSpaceDetected) {
            if (line.charAt(index) != ' ') {
                isWordDetected = true;
                chars.add(line.charAt(index));
            } else if (isWordDetected) {
                isLastSpaceDetected = true;
            }
            --index;
        }
        return chars;
    }

}
