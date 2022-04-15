import collections

DIRECTIONS = [(-1, 0), (1, 0), (0, -1), (0, 1)]

class Solution:
    def wallsAndGates(self, rooms: List[List[int]]) -> None:
        """
        Do not return anything, modify rooms in-place instead.
        """
        INF = 2147483647
        m = len(rooms)
        n = len(rooms[0])
        
        queue = collections.deque()
        for i in range(m):
            for j in range(n):
                if rooms[i][j] == 0:
                    queue.append((i, j))
                                        
        level = 1
        while queue:
            k = len(queue)
            for _ in range(k):
                curI, curJ = queue.popleft()
                
                for d in DIRECTIONS:
                    newI = curI + d[0]
                    newJ = curJ + d[1]
                    if newI >= 0 and newI < m and newJ >= 0 and newJ < n and rooms[newI][newJ] == INF:
                        queue.append((newI, newJ))
                        rooms[newI][newJ] = level
                    
            level += 1
            
                