class Solution:
    def repeatedSubstringPattern(self, s: str) -> bool:
        next = self.buildNext(s)
        length = len(s)
        if next[length-1] == 0:
            return False
        if length % (length - next[length-1]) == 0:
            return True
        return False
        
    '''
        应该是kmp建立next的过程
    '''

    def buildNext(self, str):
        length = len(str)
        next = [0]*length
        start = 0
        idx = 1
        while idx < length:
            if str[idx] == str[start]:
                next[idx] = start + 1
                idx += 1
                start += 1
            else:
                while start > 0 and str[idx] != str[start]:
                    start = next[start-1]
                if str[idx] != str[start]:
                    next[idx] = 0
                    idx += 1
        return next

Solution().repeatedSubstringPattern('babbabbabbabbab')