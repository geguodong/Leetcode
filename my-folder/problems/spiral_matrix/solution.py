class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        if matrix is None or len(matrix) is None or len(matrix[0]) is None:
            return None
        result = []
        rows, cols = len(matrix), len(matrix[0])
        left, right, up, down = 0, cols - 1, 0, rows - 1
        while len(result) < rows * cols:
            for col in range(left, right + 1):
                result.append(matrix[up][col])
            for row in range(up + 1, down + 1):
                result.append(matrix[row][right])
            if up != down:
                for col in range(right - 1, left - 1, -1):
                    result.append(matrix[down][col])
            if left != right:
                for row in range(down - 1, up, -1):
                    result.append(matrix[row][left])
                    
            left += 1
            right -= 1
            up += 1
            down -= 1
        return result