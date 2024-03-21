class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        # O n^2
        idx = len(nums) - 1
        new_len = len(nums)
        while idx >= 0:
            if (nums[idx] == val):
                s = idx
                while s < new_len - 1:
                    nums[s] = nums[s + 1]
                    s += 1
                new_len -= 1
            idx -= 1
        return new_len


class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        # O(n) ，但是leetcode上更慢，数据量小的原因
        idx = 0
        new_len = len(nums)
        while idx < new_len:
            if (nums[idx] == val):
                nums[idx] = nums[new_len - 1]
                new_len -= 1
                continue
            idx += 1
        return new_len


class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        #  左右双指针，更改了元素顺序
        idx = 0
        new_len = len(nums)
        while idx < new_len:
            while idx < new_len and nums[idx] != val:
                idx += 1
            while idx < new_len and nums[new_len - 1] == val:
                new_len -= 1

            if idx < new_len:
                nums[idx] = nums[new_len - 1]
                new_len -= 1
                idx += 1
        return new_len


class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        #  快慢指针双指针, 7ms
        slow_idx = 0
        fast_idx = 0
        len_nums = len(nums)
        
        while fast_idx < len_nums:
            if nums[fast_idx] != val:
                nums[slow_idx] = nums[fast_idx]
                slow_idx += 1
            fast_idx += 1
        return slow_idx
