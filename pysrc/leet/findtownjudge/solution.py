

class Solution(object):
    def findJudge(self, N, trust):
        parents = [-1 for i in range(0, N + 1)]

        for pair in trust:
            parents[pair[0]] = pair[1]

        judge = -1
        for i in range(1, len(parents)):
            print(parents[i])


            if (parents[i] == -1 and judge == -1) :
                # print(str(parents[i]) + "-1-" + str(judge))
                judge = parents[i]
            elif (parents[i] != -1 and judge != -1) :
                # print(str(parents[i]) + "<2>" + str(judge))
                if (parents[i] != judge) :
                    judge = 0
            elif (parents[i] != -1 and judge == -1):
                # print(str(parents[i]) + "<3>" + str(judge))
                judge = parents[i]
            elif (parents[i] == -1 and judge != i):
                # print(str(parents[i]) + "<4>" + str(judge))
                judge = 0
        print("hui")
        print(judge)
        return judge if (judge > 0) else -1