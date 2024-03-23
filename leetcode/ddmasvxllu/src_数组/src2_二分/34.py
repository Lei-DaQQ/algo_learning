'''
https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/
'''


class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        idx = self.binarySearch(nums, target)
        if idx == -1:
            # print('[-1,-1]')
            return [-1, -1]
        else:
            l = idx - 1
            while (l >= 0 and nums[l] == target):
                l -= 1
            r = idx + 1
            while (r < len(nums) and nums[r] == target):
                r += 1
            # print('[{},{}]'.format(l + 1, r - 1))
            return [l + 1, r - 1]
            # print('[{l+1},{r-1}]')

    def binarySearch(self, nums, target):
        l = 0
        r = len(nums) - 1
        while (l <= r):
            mid = l + (r - l) // 2
            if (target < nums[mid]):
                r = mid - 1
            elif (target > nums[mid]):
                l = mid + 1
            else:
                return mid
        return -1


class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        l = self.binarySearch(nums, target, True)
        r = self.binarySearch(nums, target, False)
        return [l, r]

    def binarySearch(self, nums, target, lower=False):
        # lower=False, find left;
        # lower=True, find right
        l = 0
        r = len(nums) - 1
        ans = -1
        while (l <= r):
            mid = l + (r - l) // 2
            if (target < nums[mid]):
                r = mid - 1
            elif (target > nums[mid]):
                l = mid + 1
            elif lower:
                r = mid - 1
                ans = mid
            else:
                l = mid + 1
                ans = mid
        return ans
