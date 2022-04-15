import collections

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])
        
        res = 0
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '0':
                    continue
                    
                res += 1
                self.dfs(grid, i, j, m, n)
                
        return res
        
    def dfs(self, grid, i, j, m, n):
        if i < 0 or i >= m or j < 0 or j >= n or grid[i][j] == '0':
            return
        
        grid[i][j] = '0'
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        for d in directions:
            newI = i + d[0]
            newJ = j + d[1]
            self.dfs(grid, newI, newJ, m, n)