class Solution(object):
    def findJudge(self, N, trust):
        parents = [-1 for i in range(0, N + 1)]

        for pair in trust:
            if (parents[pair[0]] == -1):
                parents[pair[0]] = [pair[1]]
            else:
                parents[pair[0]].append(pair[1])

        judge = -1
        for i in range(1, len(parents)):
            if (parents[i] == (-1)):
                if (judge > -1):
                    return -1
                else:
                    judge = i

        for i in range(1, len(parents)):
            if (i != judge and not (self.contains_judge(parents[i], judge))):
                return -1
        return judge

    def contains_judge(self, arr, judge):
        for item in arr:
            if item == judge: return True
        return False
