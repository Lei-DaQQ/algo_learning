from collections import deque


class Solution:
    def maxSlidingWindow(self, nums: list[int], k: int) -> list[int]:
        dq = deque()

        for i in range(k-1):
            # store [0, k-1)
            elem = nums[i]
            while dq:
                if elem > dq[-1]:
                    dq.pop()
                elif elem <= dq[-1]:
                    dq.append(elem)
                    break
            if not dq:
                dq.append(elem)

        res = []
        for i in range(k-1, len(nums)):
            # add window's last:
            elem = nums[i]
            while dq:
                if elem > dq[-1]:
                    dq.pop()
                elif elem <= dq[-1]:
                    dq.append(elem)
                    break
            if not dq:
                dq.append(elem)

            res.append(dq[0])
            # remove
            if nums[i-k+1] == dq[0]:
                dq.popleft()
        return res


Solution().maxSlidingWindow([1, 3, -1, -3, 5, 3, 6, 7], k=3)
