from unittest import TestCase
# from findtownjudge import solution
from pysrc.leet.findtownjudge.solution import Solution


class TestSolution(TestCase):

    def test_findJudge(self):
        s = Solution()
        res = s.findJudge(3, [[1, 2], [2, 3], [1, 3]])
        self.assertEqual(3, res, "positive test")

        res = s.findJudge(3, [[1, 2], [2, 3], ])
        self.assertEqual(-1, res, "negative test")

        res = s.findJudge(4, [[1, 3], [1, 4], [2, 3], [2, 4], [4, 3]])
        self.assertEqual(3, res, "positive test")

        res = s.findJudge(4, [[1, 2], [2, 1], [3, 4]])
        self.assertEqual(-1, res, "negative test")

        res = s.findJudge(4, [[1, 4], [2, 4], [3, 4], [1, 2]])
        self.assertEqual(4, res, "negative test")

        print("cool!")
