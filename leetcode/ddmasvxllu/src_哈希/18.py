class Solution:
    def fourSum(self, nums: list[int], target: int) -> list[list[int]]:
        length = len(nums)
        nums.sort()
        ans = []
        for idx1 in range(length):
            num1 = nums[idx1]
            if idx1 > 0 and num1 == nums[idx1-1]:
                continue
            for idx2 in range(idx1+1, length):
                num2 = nums[idx2]
                if idx2 > idx1+1 and num2 == nums[idx2-1]:
                    continue
                left, right = idx2+1, length - 1
                while left < right:
                    num3, num4 = nums[left], nums[right]
                    sum = num1 + num2 + num3 + num4
                    if sum > target:
                        right -= 1
                    elif sum < target:
                        left += 1
                    else:
                        ans.append([num1, num2, num3, num4])
                        while left < right and nums[left] == num3:
                            left += 1
                        while left < right and nums[right] == num4:
                            right -= 1
        return ans
