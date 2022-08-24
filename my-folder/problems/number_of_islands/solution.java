class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return res;
        }
        
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] directions = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == '1') {
                    res++;
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(i * cols + j);
                    while(!queue.isEmpty()) {
                        int cur = queue.poll();
                        grid[cur/cols][cur%cols] = '0';
                        for(int[] dir : directions) {
                            int r = cur/cols + dir[0];
                            int c = cur%cols + dir[1];
                            if(r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == '1') {
                                queue.add(r*cols + c);
                                grid[r][c] = '0';
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
