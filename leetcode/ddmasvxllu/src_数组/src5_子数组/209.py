class Solution(object):
    def minSubArrayLen(self, target, nums):
        """
        :type target: int
        :type nums: List[int]
        :rtype: int
        """
        # 前缀和版滑动窗口
        prefix = [0]
        for i in range(len(nums)):
            prefix.append(prefix[-1] + nums[i])

        min_len = float('inf')
        for i in range(len(prefix)):
            if prefix[i] >= target:
                min_len = i
                break
        if min_len == float('inf'):
            return 0

        # 逐步减小 min_len
        i = 1
        # nums有多少元素， prefix 下标就可以取到该数
        while i + min_len - 1 < len(prefix):
            # 看减小 min_len 是否可行
            while prefix[i+min_len-1] - prefix[i] >= target:
                min_len -= 1
            i += 1
        return min_len


print(Solution().minSubArrayLen(7, [2, 3, 1, 2, 4, 3]))
