# class Solution:
#     def findAnagrams(self, s: str, p: str) -> list[int]:
#         from typing import Counter
#         res = []
#         left, right = 0, 0
#         p_counter = Counter(p)
#         rem_counter = p_counter.copy()
#         len_wnd = 0
#         len_s = len(s)
#         len_p = len(p)
#         while right < len_s:
#             if s[right] in p:
#                 rem_counter[s[right]] -= 1
#                 if rem_counter[s[right]] >= 0:
#                     let_wnd += 1
#                 if len_wnd == len_p:
#                     res.append(left)
#                     left += 1
#                     if s[left] in p:
#                         rem_counter[s[left]] += 1
#                         if rem_counter[s[left]] > 0:
#                             len_wnd -= 1
#                         '''
#                         想成之前的滑动窗口了，但是这里得是子串，要连续，且不能多余
#                         '''
#             right += 1

class Solution:
    def findAnagrams(self, s: str, p: str) -> list[int]:
        from typing import Counter
        len_s = len(s)
        counter_p = Counter(p)
        counter_sub = {}
        res = []
        left, right = 0, 0
        while right < len_s:
            if s[right] not in p:
                counter_sub.clear()
                left = right = right + 1
            else:
                counter_sub[s[right]] = counter_sub.get(s[right], 0) + 1
                if right - left + 1 == len(p):
                    if counter_p == counter_sub:
                        res.append(left)
                    counter_sub[s[left]] -= 1
                    left += 1
                right += 1
        return res
