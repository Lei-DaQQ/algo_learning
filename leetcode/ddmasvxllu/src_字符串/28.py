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
        i, j = 0, 1
        length = len(str)
        next = [0]*length
        while j < length:
            if str[i] == str[j]:
                next[j] = i + 1
                i += 1
                j += 1
            # else:
            #     if i == 0:
            #         next[j] = 0
            #         j += 1
            #         continue
            #     i = next[i-1]                
            else:
                while i > 0 and str[i] != str[j]:
                    i = next[i-1]
                if str[i] != str[j]:
                    next[j] = 0 
                    j += 1
        return next


Solution().strStr('aabaaabaaac', 'aabaaac')
# Solution().strStr('leetcode', 'la')
