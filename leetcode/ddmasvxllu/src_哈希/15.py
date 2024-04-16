class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:
        '''
        如果先将两数之和存入haspmap?
        '''
        '''
        如果先将两数之和存入haspmap，但是比较麻烦的就是index， 可能的解决方式是存储时：{key:sum, value:[index1, index2]}
        但是sum是可重复的

        如果先所有数排序？
        [- - - - 0 0 0 + + + +]
        '''

        ans = []
        length = len(nums)
        nums.sort()
        for index, num1 in enumerate(nums):
            if num1 > 0 or index + 2 == length:
                break
            if index > 0 and num1 == nums[index-1]:
                continue
            left, right = index + 1, length - 1
            while left < right:
                left_num, right_num = nums[left], nums[right]
                if num1 + left_num + right_num == 0:
                    ans.append([num1, left_num, right_num])
                    while left < right and nums[left] == left_num:
                        left += 1
                    while left < right and nums[right] == right_num:
                        right -= 1
                elif num1+left_num + right_num < 0:
                    left += 1
                else:
                    right -= 1
        return ans

            
            
        
        
Solution().threeSum([-1,0,1,2,-1,-4])