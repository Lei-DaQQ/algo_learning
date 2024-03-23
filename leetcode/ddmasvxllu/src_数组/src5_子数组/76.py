from collections import Counter
import collections


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        left = 0
        right = 0

        # 先统计t中每个字符的个数
        t_dict = Counter()
        all_cnt = len(t)
        for c in t:
            t_dict[c] += 1

        t_dict_remain = t_dict.copy()
        ans = (0, len(s)+1, len(s)+1)
        while left < len(s):
            while all_cnt != 0 and right < len(s):
                right_char = s[right]
                if right_char in t_dict:
                    if t_dict_remain[right_char] > 0:
                        all_cnt -= 1
                    t_dict_remain[right_char] -= 1
                right += 1
            if all_cnt == 0:
                if ans[2] > right - left:
                    ans = (left, right, right - left)
            '''
            这里可以 left 一直 ++，直到 度过那些不在t中的字符
            '''
            if s[left] in t_dict:
                if t_dict_remain[s[left]] == 0:
                    all_cnt += 1
                t_dict_remain[s[left]] += 1
            left += 1
        if ans[2] == len(s)+1:
            return ""
        return s[ans[0]:ans[1]]

    def minWindow(self, s: str, t: str) -> str:
        need_dict = collections.defaultdict(int)
        for ch in t:
            need_dict[ch] += 1
        needCnt = len(t)
        left = 0
        ans = (0, float('inf'))
        for right, ch in enumerate(s):
            if need_dict[ch] > 0:
                needCnt -= 1
            need_dict[ch] -= 1
            if needCnt == 0:  # 步骤一：滑动窗口包含了所有T元素
                while True:  # 步骤二：增加i，排除多余元素
                    ch = s[left]
                    if need_dict[ch] == 0:
                        break
                    need_dict[ch] += 1
                    left += 1
                if right-left < ans[1]-ans[0]:  # 记录结果
                    ans = (left, right)
                need_dict[s[left]] += 1  # 步骤三：i增加一个位置，寻找新的满足条件滑动窗口
                needCnt += 1
                left += 1
        # 如果res始终没被更新过，代表无满足条件的结果
        return '' if ans[1] > len(s) else s[ans[0]:ans[1]+1]


Solution().minWindow("ADOBECODEBANC", "ABC")
