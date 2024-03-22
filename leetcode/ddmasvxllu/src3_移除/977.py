# class Solution(object):
#     def sortedSquares(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: List[int]
#         """
#         former = 0
#         latter = len(nums) - 1
#         latter_decrease_start = 0
#         latter_decrease_end = 0

#         # 如果有latter_decrease_start，一定比后边的数大

#         for i in range(len(nums)):
#             nums[i] = nums[i] ** 2

#         while former <= latter:
#             if latter_decrease_start != latter_decrease_end:
#                 if nums[former] < nums[latter_decrease_start]:
#                     nums[latter] = nums[latter_decrease_start]
#                     latter_decrease_start += 1
#                 else:
#                     nums[latter] = nums[former]
#                     former += 1
#                 nums[latter_decrease_end] = nums[latter]
#                 latter_decrease_end += 1
#             # else 没有临时数，只有前后比
#             elif nums[former] > nums[latter]:
#                 t = nums[latter]
#                 nums[latter] = nums[former]
#                 nums[latter_decrease_end] = t
#                 latter_decrease_end += 1

#                 former += 1
#                 latter -= 1
#             else:
#                 latter -= 1
#         # 然后颠倒 [latter_decrease_start, latter_decrease_end] 的顺序
#         i, j = latter_decrease_start, latter_decrease_end - 1
#         while i <= j:
#             nums[i], nums[j] = nums[j], nums[i]
#             i += 1
#             j -= 1
            
        
        
#         return nums
#     def storeInCircleList(self, num, nums, start, end, stop):

        
# Solution().sortedSquares([-4,-1,0,3,10])


class Solution(object):
    def sortedSquares(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        for i in range(len(nums)):
            nums[i] = nums[i] ** 2
        i = 0
        j = len(nums) - 1
        arr = [0] * len(nums)
        idx = j
        while i <= j:
            if nums[i] > nums[j]:
                arr[idx] = nums[i]
                i += 1
            else:
                arr[idx] = nums[j]
                j -= 1
            idx -= 1
        return arr
            
        
