import collections

DIRECTIONS = [(-1, 0), (1, 0), (0, -1), (0, 1)]

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        
        goodOranges = 0
        minutes = 0
        queue = collections.deque()
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    queue.append((i, j))
                elif grid[i][j] == 1:
                    goodOranges += 1
                    
        if goodOranges == 0:
            return 0
                    
        while queue:
            for _ in range(len(queue)):
                i, j = queue.popleft()
                for d in DIRECTIONS:
                    newI = i + d[0]
                    newJ = j + d[1]
                    if newI >= 0 and newI < m and newJ >= 0 and newJ < n and grid[newI][newJ] == 1:
                        queue.append((newI, newJ))
                        grid[newI][newJ] = 2
                        goodOranges -= 1
                        
            minutes += 1
            
        if goodOranges != 0:
            return -1
        
        return minutes - 1