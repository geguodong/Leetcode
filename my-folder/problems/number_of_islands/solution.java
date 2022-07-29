
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        int[][] directions = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(i * cols + j);
                    
                    while (queue.size() != 0) {
                        int cur = queue.remove();
                        for (int[] dir : directions) {
                            int r = cur / cols + dir[0];
                            int c = cur % cols + dir[1];
                            if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == '1') {
                                grid[r][c] = '0';
                                queue.add(r * cols + c);
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
