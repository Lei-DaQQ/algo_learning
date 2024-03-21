class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        slow = 1
        fast = 1
        # fast 指向 和nums[slow-1]不同的元素，只有和新数组中上一个元素不同的元素才会被保存，
        # fast 也可以指向 和 nums[fast-1] 不同的元素，只有原数组中和上一个元素不同的元素才会被保存
        # 放在 slow 处
        nums_len = len(nums)
        while fast < nums_len:
            if nums[fast] != nums[slow-1]:
                nums[slow] = nums[fast]
                slow += 1
            fast += 1
        return slow # slow 是要放新的元素的位置，也是数组的新长度


class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        nums[0:-1] = list(set(nums))[0:-1]
        return len(nums) 