class Solution(object):
    def backspaceCompare(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        #  倒序 双指针
        s_right = len(s) - 1
        s_left = len(s) - 1

        t_right = len(t) - 1
        t_left = len(t) - 1

        while s_left >= 0 and t_left >= 0:
            while s[s_left] == '#':
                s_left -= 1
            s_left -= (s_right - s_left)

            while t[t_left] == '#':
                t_left -= 1
            t_left -= (t_right - t_left)
            if s_left >= 0 and t_left >= 0:
                if s[s_left] != t[t_left]:
                    return False
            t_right = t_left - 1
            s_right = s_left - 1
        return True
