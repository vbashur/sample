package com.vbashur

/**
  * Created by victor.bashurov on 13.09.2017.
  */
object S03_S_ValidateIp {

  def validIPAddress(IP: String): String = {

    try {
      if (IP.contains(".")) {
        val nums = IP.split("\\.")
        if (nums.length == 4) {
          val isProperIp = nums.filter(n => n.size == 0 || n.size > 3 || (n.startsWith("0") && n.size > 1) || Integer.toBinaryString(Integer.valueOf(n)).length > 8).isEmpty
          if (isProperIp) {
            return "IPv4"
          }
        }
      } else if (IP.contains(":")) {
        val nums = IP.split(":")
        if (nums.length == 8 && !IP.endsWith(":")) {
          val isProperIp = nums.filter(n => n.size < 1 || n.size > 4 || Integer.toBinaryString(Integer.valueOf(n, 16)).length > 16).isEmpty
          if (isProperIp) {
            return "IPv6"
          }
        }

      }
    } catch {
      case e: NumberFormatException => "Neither"
    }
    "Neither"


  }

}
