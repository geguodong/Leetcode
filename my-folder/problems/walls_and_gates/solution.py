class Solution:
    def wallsAndGates(self, rooms: List[List[int]]) -> None:
        """
        Do not return anything, modify rooms in-place instead.
        """
        queue = deque()
        row_len = len(rooms)
        column_len = len(rooms[0])
        for i in range(row_len):
            for j in range(column_len):
                if rooms[i][j] == 0:
                    queue.append((i, j, 0))
                
        while queue:
            row, column, d = queue.popleft()
            d += 1
            for r, c in ((row, column+1), (row, column-1), (row-1, column), (row+1, column)):
                if r >= 0 and r < row_len and c >= 0 and c < column_len and rooms[r][c] != 0 and rooms[r][c] != -1:
                    if d < rooms[r][c]:
                        rooms[r][c] = d
                        queue.append((r, c, d))