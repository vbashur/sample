package com.vbashur

/**
  * Created by victor.bashurov on 14.09.2017.
  * https://leetcode.com/problems/repeated-dna-sequences/description/
  *

All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].

  */

object S05_S_RepeatedDna {

  def findRepeatedDnaSequences(s: String): List[String] = {
    considerDnaFrame(s, 0, Set("")).toList
  }

  def considerDnaFrame(dna: String, index: Int, resolvedDna: Set[String]): Set[String] = {
    if (index + 10 < dna.size) {
      val currentDna = dna.substring(index, index + 10)
      if (resolvedDna.contains(currentDna)) {
        return considerDnaFrame(dna, index + 1, resolvedDna + currentDna) + currentDna
      } else {
        return considerDnaFrame(dna, index + 1, resolvedDna + currentDna)
      }
    }
    Set()
  }

}
