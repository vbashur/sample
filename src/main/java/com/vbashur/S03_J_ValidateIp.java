package com.vbashur;

/**
 * Created by victor.bashurov on 12.09.2017.
 * https://leetcode.com/problems/validate-ip-address/description/
 *
 *
 */
public class S03_J_ValidateIp {

    public String validIPAddress(String IP) {

        try {
            if (IP.contains(".")) {
                String[] nums = IP.split("\\.");
                if (nums.length == 4) {
                    for (String num : nums) {
                        if (num.length() > 3 || num.length() == 0
                                || (num.startsWith("0") && num.length() > 1)
                                || Integer.toBinaryString(Integer.valueOf(num)).length() > 8) {
                            return "Neither";
                        }
                    }
                    return "IPv4";
                }

            } else if (IP.contains(":")) {
                String[] nums = IP.split(":");
                if (nums.length == 8 && !IP.endsWith(":")) {
                    for (String num : nums) {
                        if (num.length() > 4 || num.length() < 1
                                || Integer.toBinaryString(Integer.parseInt(num, 16)).length() > 16) {
                            return "Neither";
                        }
                    }
                    return "IPv6";
                }

            }
        } catch (NumberFormatException e) {
            return "Neither";
        }
        return "Neither";
    }





}


