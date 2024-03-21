from collections import Counter


class Solution:
    def totalFruit(self, fruits: list[int]) -> int:
        '''
        用了两层循环，可能没有必要
        '''
        left = 0
        right = 0
        window_fruit_dict = {}
        ans = 0
        while left < len(fruits):
            while right < len(fruits):
                right_type = fruits[right]
                if right_type not in window_fruit_dict and len(window_fruit_dict) == 2:
                    break
                if right_type in window_fruit_dict:
                    window_fruit_dict[right_type] += 1
                else:
                    window_fruit_dict[right_type] = 1
                right += 1
            ans = max(ans, right - left)

            left_type = fruits[left]
            window_fruit_dict[left_type] -= 1
            if window_fruit_dict[left_type] == 0:
                del window_fruit_dict[left_type]
            left += 1
        return ans


class Solution:
    def totalFruit(self, fruits: list[int]) -> int:
        '''
        这样更慢一点了，虽然复杂度一样，并且时间应该不算特别准确
        但是猜测一下？每次都要 ans = max? 好奇怪
        '''
        left = 0
        right = 0
        window_fruit_dict = Counter()
        ans = 0
        while right < len(fruits):
            right_type = fruits[right]
            if right_type not in window_fruit_dict and len(window_fruit_dict) == 2:
                left_type = fruits[left]
                window_fruit_dict[left_type] -= 1
                if window_fruit_dict[left_type] == 0:
                    window_fruit_dict.pop(left_type)
                left += 1
            else:
                right += 1
                window_fruit_dict[right_type] += 1
            ans = max(ans, right - left)

        return ans


print(Solution().totalFruit([1]))
