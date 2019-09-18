class Solution:

    def replace_char(self, s, n, c):
        # n -= 1
        s = s[0:n] + s[n:n + 1].replace(s[n], c) + s[n + 1:]
        return s

    def swap(self, s, indices, start, end):
        startIndex = indices[start]
        endIndex = indices[end]
        tmp = s[startIndex]
        s = self.replace_char(s, startIndex, s[endIndex])
        s = self.replace_char(s, endIndex, tmp)
        return s

    def reverseVowels(self, s: str) -> str:
        vowels = ["e", "u", 'i', 'o', 'a']
        indices = []
        for i in range(0, len(s)):
            if s[i] in vowels:
                indices.append(i)

        start = 0
        end = len(indices) - 1
        while start < end:
            s = self.swap(s, indices, start, end)
            start = start + 1
            end = end - 1
        return s