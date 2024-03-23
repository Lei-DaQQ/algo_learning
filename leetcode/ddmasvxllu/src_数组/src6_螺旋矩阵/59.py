from typing import List


class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        right_end = n - 1
        down_end = n - 1
        left_end = 0
        up_end = 1

        matrix = [[0]*n for _ in range(n)]
        row, col = 0, 0
        number = 1

        while number != n*n + 1:
            while col <= right_end:
                matrix[row][col] = number
                number += 1
                col += 1
            col -= 1
            right_end -= 1

            row += 1
            while row <= down_end:
                matrix[row][col] = number
                number += 1
                row += 1
            row -= 1
            down_end -= 1

            col -= 1
            while col >= left_end:
                matrix[row][col] = number
                number += 1
                col -= 1
            col += 1
            left_end += 1

            row -= 1
            while row >= up_end:
                matrix[row][col] = number
                number += 1
                row -= 1
            row += 1
            up_end += 1

            col += 1
        return matrix


Solution().generateMatrix(3)
