'''
https://leetcode.cn/problems/binary-search/description/
'''
class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        l = 0
        r = len(nums) - 1
        while (l <= r):
            mid = (l + r) / 2
            num_m = nums[mid]
            if (num_m < target):
                l = mid + 1
            elif (num_m > target):
                r = mid - 1
            else:
                return mid
        return -1            