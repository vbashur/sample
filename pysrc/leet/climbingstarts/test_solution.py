from unittest import TestCase

from pysrc.leet.climbingstarts.solution import Solution


class TestSolution(TestCase):

    def test_solution(self):
        s = Solution()
        self.assertEqual(1, s.climbStairs(1))
        self.assertEqual(2, s.climbStairs(2))
        self.assertEqual(3, s.climbStairs(3))
        self.assertEqual(5, s.climbStairs(4))
        self.assertEqual(8, s.climbStairs(5))
    #
    #
    # pass
