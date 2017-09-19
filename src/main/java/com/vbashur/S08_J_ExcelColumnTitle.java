package com.vbashur;

/**
 * Created by victor.bashurov on 19.09.2017.
 *
 * https://leetcode.com/problems/excel-sheet-column-title/discuss/
 *
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 For example:

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 */
public class S08_J_ExcelColumnTitle {

    public String convertToTitle(int n) {


        StringBuilder result = new StringBuilder();

        while (n > 0) {
            n--;
            result.insert(0, (char) ('A' + n % 26));
            n /= 26;
        }

        return result.toString();
    }

}
