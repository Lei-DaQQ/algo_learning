class Solution(object):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        if x == 1:
            return 1
        return self.binarySearch(x // 2)

    def binarySearch(self, x):
        l = 0
        r = x
        while (l <= r):
            mid = l + (r - l) // 2
            mid_squ = mid * mid
            if mid_squ <= x and (mid + 1) * (mid + 1) > x:
               return mid 
            elif mid_squ < x:
                l = mid + 1
            else:
                r = mid - 1
    