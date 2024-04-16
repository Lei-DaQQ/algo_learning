class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        s_lst = list(s)
        length = len(s)
        i = 0
        while i < length:
            if i + k < length:
                self.reverse(s_lst, i, i+k-1)
            else:
                self.reverse(s_lst, i, length-1)
            i += 2*k
        return ''.join(s_lst)

    def reverse(self, s_lst, left, right):
        while left < right:
            s_lst[left], s_lst[right] = s_lst[right], s_lst[left]
            left += 1
            right -= 1
