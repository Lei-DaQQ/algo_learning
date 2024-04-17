class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        next = self.buildNext(needle)
        length_hay = len(haystack)
        length_need = len(needle)
        idx_hay = 0
        idx_need = 0
        while idx_hay < length_hay and idx_need < length_need:
            if needle[idx_need] == haystack[idx_hay]:
                idx_hay += 1
                idx_need += 1
            else:
                if idx_need == 0:
                    idx_hay += 1
                    continue
                idx_need = next[idx_need-1]
                
        if idx_need == length_need:
            return idx_hay - length_need
        else:
            return -1

    def buildNext(self, str):
        length = len(str)
        next = [0]*length

        for i in range(1, length):
            if str[i] == str[next[i-1]]:
                next[i] = next[i-1] + 1
            else:
                next[i] = 0
        return next

Solution().strStr('aabaaabaaac', 'aabaaac')
# Solution().strStr('leetcode', 'la')