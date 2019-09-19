class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        map = [0] * 28
        for iter in range(0, len(text)):
            map[ord(text[iter]) - ord('a')] += 1
        text_length = 1000000
        #print(map)
        for c in "balon":
            if c == 'l' or c == 'o':
                #print("char=%s and text_length=%s and map_val=%s" % (c, text_length, int(map[ord(c) - ord('a')] / 2)))
                text_length = min(text_length, int(map[ord(c) - ord('a')] / 2))
            else:
                text_length = min(text_length, map[ord(c) - ord('a')])
        return text_length if text_length < 1000000 else 0
