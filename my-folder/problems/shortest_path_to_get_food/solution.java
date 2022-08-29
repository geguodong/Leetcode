class Solution {
    public int getFood(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] seen = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '*') {
                    return bfs(i, j, grid, seen);
                }
            }
        }
        return -1;
    }
    
    private int bfs(int row, int col, char[][] grid, boolean[][] seen) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        seen[row][col] = true;
        int level = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                if (grid[point[0]][point[1]] == '#') {
                    return level;
                }
                for (int[] dir : dirs) {
                    int nextRow = dir[0] + point[0];
                    int nextCol = dir[1] + point[1];
                    if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && grid[nextRow][nextCol] != 'X' && !seen[nextRow][nextCol]) {
                        queue.add(new int[]{nextRow, nextCol});
                        seen[nextRow][nextCol] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}