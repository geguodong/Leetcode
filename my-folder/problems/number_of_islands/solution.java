class Solution {
    int rows;
    int cols;
    char[][] grid;
    int islands;
    public int numIslands(char[][] grid) {
        // check empty
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        
        // initial
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.islands = 0;
        
        // check nodes
        int num = 0;
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                bfs(i, j);
                num = islands;
            }
        }
        return islands;
    }
    
    private void bfs(int row, int col) {
        if(grid[row][col] == '0') {
            return;
        }
        Queue<int[]> queue = new LinkedList<>();
        if(grid[row][col] == '1') {
            islands++;
            grid[row][col] = '0';
            queue.add(new int[]{row, col});
        }
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int[] dir : directions) {
                int newRow = cur[0] + dir[0];
                int newCol = cur[1] + dir[1];
                if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == '1') {
                    grid[newRow][newCol] = '0';
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }
    }
}