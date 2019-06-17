class Solution(object):
    def climbStairs(self, n):
        # sum1 = self.climb(1, n)
        # if n == 2:
        #     return sum1
        return self.climb(1, n) + self.climb(2, n)

    def climb(self, added_value, target):
        if (added_value > target):
            return 0
        if (added_value == target):
            return 1
        return self.climb(added_value + 1, target) + self.climb(added_value + 2, target)

