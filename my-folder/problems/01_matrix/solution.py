class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if mat is None or len(mat) is None or len(mat[0]) is None:
            return None
        m, n = len(mat), len(mat[0])
        if m == 0:
            return mat
        dp = [[float(inf) for _ in range(n)] for _ in range(m)]

        for row in range(0, m):
            for col in range(0, n):
                if mat[row][col] == 0:
                    dp[row][col] = 0
                else:
                    if row > 0:
                        dp[row][col] = min(dp[row][col], dp[row - 1][col] + 1)
                    if col > 0:
                        dp[row][col] = min(dp[row][col], dp[row][col - 1] + 1)
                    
        for row in range(m - 1, -1, -1):
            for col in range(n - 1, -1, -1):
                if row < m - 1:
                    dp[row][col] = min(dp[row][col], dp[row + 1][col] + 1)
                if col < n - 1:
                    dp[row][col] = min(dp[row][col], dp[row][col + 1] + 1)
                        
        return dp