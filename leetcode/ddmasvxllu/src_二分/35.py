'''
https://leetcode.cn/problems/search-insert-position/description/
'''
class Solution(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        l = 0
        r = len(nums) - 1
        while (l <= r):
            mid = l + (r - l) // 2
            num_m = nums[mid]
            if (num_m > target):
                r = mid - 1
            elif (num_m < target):
                l = mid + 1
            else:
                return mid
        return l