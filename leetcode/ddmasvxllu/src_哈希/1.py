from collections import Counter


class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:

        all = Counter(nums)

        for index, item in enumerate(nums):
            complement = target - item
            all[item] -= 1
            if all[complement] > 0:
                return [index, nums[index+1:].index(complement)+index+1]


class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        seen = dict()
        for index, num in enumerate(nums):
            complement = target - num
            if complement in seen:
                return [index, seen[complement]]
            seen[num] = index
