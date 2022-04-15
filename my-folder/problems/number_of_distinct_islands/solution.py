import collections

DIRECTIONS = [(-1, 0), (1, 0), (0, -1), (0, 1)]

class Solution:
    def numDistinctIslands(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        
        lands = set()
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    lands.add(self.bfs(grid, i, j))
                
        return len(lands)
    
    def bfs(self, grid, i, j):
        startI = i
        startJ = j
        
        land = []
        queue = collections.deque([(i, j)])
        grid[i][j] = 2
        
        while queue:
            i, j = queue.popleft()
            land.append((i - startI, j - startJ))
            
            for d in DIRECTIONS:
                newI = i + d[0]
                newJ = j + d[1]
                if newI >= 0 and newI < len(grid) and newJ >= 0 and newJ < len(grid[0]) and grid[newI][newJ] == 1:
                    queue.append((newI, newJ))
                    grid[newI][newJ] = 0

        return tuple(land)
        