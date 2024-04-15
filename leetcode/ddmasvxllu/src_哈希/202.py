from collections import Counter


class Solution:
    def isHappy(self, n: int) -> bool:
        seen = set()
        new_n = n
        while new_n not in seen:
            seen.add(new_n)
            new_n = self.return_square(new_n)
        return new_n == 1

    def return_square(self, n: int) -> int:
        return sum(int(i) ** 2 for i in str(n))
        # return sum(i**2 for i in map(int, str(n)))
        # return sum(map(lambda x: int(x) ** 2, str(n)))
        pass


print(Solution().return_square(12))
