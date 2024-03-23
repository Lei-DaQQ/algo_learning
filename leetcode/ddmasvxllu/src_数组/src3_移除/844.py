
class Solution(object):
    def backspaceCompare(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        #  反向 双指针
        s_right = len(s) - 1
        t_right = len(t) - 1

        s_del = 0
        t_del = 0
        while True:

            while s_right >= 0:
                if s[s_right] == '#':
                    s_del += 1
                elif s_del > 0:
                    s_del -= 1
                else:
                    break
                s_right -= 1
            while t_right >= 0:
                if t[t_right] == '#':
                    t_del += 1
                elif t_del > 0:
                    t_del -= 1
                else:
                    break
                t_right -= 1
            # 两个都 < 0，则True，只有一个 < 0，则False
            if s_right < 0 and t_right < 0:
                return True
            if s_right < 0 or t_right < 0:
                return False
            if s[s_right] != t[t_right]:
                return False
            s_right -= 1
            t_right -= 1


Solution().backspaceCompare("ab#c", "ad#c")
