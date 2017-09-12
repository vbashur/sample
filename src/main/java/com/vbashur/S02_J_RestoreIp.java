package com.vbashur;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by victor.bashurov on 11.09.2017.
 * <p>
 * https://leetcode.com/problems/restore-ip-addresses/description/
 * <p>
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p>
 * For example:
 * Given "25525511135",
 * <p>
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class S02_J_RestoreIp {

    public List<String> restoreIpAddresses(String s) {

        List<String> res = new LinkedList<String>();
        for (int iter = 0; iter < 256; ++iter) {
            String firstNum = String.valueOf(iter);
            if (s.startsWith(firstNum)) {
                String appendix = s.substring(firstNum.length());
                getIpAddressPart(appendix, 1, firstNum + ".", res);
            }
        }
        return res;
    }

    private void getIpAddressPart(String appendix, int iteration, String sb, List<String> result) {
        for (int iter = 0; iter < 256; ++iter) {
            String firstNum = String.valueOf(iter);
            if (appendix.startsWith(firstNum)) {
                if (iteration < 3) {
                    String appendixInner = appendix.substring(firstNum.length());
                    getIpAddressPart(appendixInner, iteration + 1, sb + firstNum + ".", result);

                } else if (iteration == 3 && appendix.equals(firstNum)) {
                    result.add(sb + firstNum);
                    return;
                }
            }
        }

    }
}
