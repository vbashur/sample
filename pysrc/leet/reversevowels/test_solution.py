from unittest import TestCase

from pysrc.leet.reversevowels.solution import Solution


class TestSolution(TestCase):

    def test_solution(self):
        s = Solution()
        print(s.reverseVowels("hello"))
        print(s.reverseVowels("aaaooo"))

