# class Solution:
#     def reverseWords(self, s: str) -> str:
#         strs = s.split()
#         res = ''
#         for i in range(len(strs)-1, 0, -1):
#             res += strs[i] + ' '
#         res += strs[0]
#         return res

class Solution:
    def reverseWords(self, s: str) -> str:
        '''
        不要使用split，并且原地操作
        2steps：
        1：整个字符串反转
        2：每个单词反转
        3.移动空格


        '''
        str = list(s)
        length = self.moveSpace(str)
        self.reverseStr(str, 0, length-1)

        start = 0
        # 单词反转
        while start < length:
            end = start + 1
            while end < length and str[end] != ' ':
                end += 1
            self.reverseStr(str, start, end - 1)
            start = end + 1
        return "".join(str[0:length])

    def moveSpace(self, str: list):
        start = 0
        idx = 0
        length = len(str)
        while idx < length:
            while idx < length and str[idx] == ' ':
                idx += 1
            # new word

            while idx < length and str[idx] != ' ':
                str[start] = str[idx]
                start += 1
                idx += 1
            if idx < length:
                str[start] = ' '
                start += 1  # a space
        return start  # new length

    def reverseStr(self, str: list, left, right):
        while left < right:
            str[left], str[right] = str[right], str[left]
            left += 1
            right -= 1

Solution().reverseWords("  hello       world  ")
