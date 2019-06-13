from unittest import TestCase
from findtownjudge import solution


class TestSolution(TestCase):

    def test_findJudge(self):
        s = solution.Solution()
        # res = s.findJudge(3, [[1,2],[2,3],[1,3]])
        # self.assertEqual(3, res, "positive test")
        #
        # res = s.findJudge(3, [[1, 2], [2, 3],])
        # self.assertEqual(-1, res, "negative test")
        res = s.findJudge(4, [[1, 3], [1, 4], [2, 3], [2, 4], [4, 3]])
        self.assertEqual(3, res, "positive test")
        print("cool!")
