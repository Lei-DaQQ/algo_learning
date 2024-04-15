from collections import Counter
class Solution:
    def fourSumCount(self, nums1: list[int], nums2: list[int], nums3: list[int], nums4: list[int]) -> int:
        '''
        暂时想到的就是两个数组先求和，但是答案要的是元组种类数，所以求和可能是有重复的，
        但是重复的和代表着不同的元组组合方式，有几个重复就有几种元组组合
        '''
        res = 0
        sum12 = Counter()
        for elem1 in nums1:
            for elem2 in nums2:
                sum = elem1 + elem2
                sum12[sum] += 1
                
        # sum34 = Counter()
        # for elem3 in nums3:
        #     for elem4 in nums4:
        #         sum = elem3 + elem4
        #         sum34[sum] += 1
        # for elem12 in sum12:
        #     res += sum12[elem12] * sum34[-elem12]
            
        for elem3 in nums3:
            for elem4 in nums4:
                res += sum12[-(elem3+elem4)]
        return res