class Solution(object):
    def isPerfectSquare(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num == 1:
            return True
        left, right = 1, num >> 1
        while left <= right:
            # mid = left + (right - left) // 2
            mid = left + ((right - left) >> 1)
            # mid = (left + right) // 2
            # mid = (left + right) >> 1

            mid_squ = mid ** 2
            if mid_squ == num:
                return True
            elif mid_squ < num:
                left = mid + 1
            else:
                right = mid - 1
        return False
