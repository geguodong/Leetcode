// BFS
// From Ocean to check reachable nodes
class Solution {
    int[][] heights;
    int rows;
    int cols;
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // check empty
        if(heights == null || heights.length == 0 || heights[0] == null || heights[0].length == 0) {
            return new ArrayList<>();
        }
        
        //initalize variables;
        this.heights = heights;
        this.rows = heights.length;
        this.cols = heights[0].length;
        
        // Add pacific and atlantic ocean nodes
        Queue<int[]> pacific = new LinkedList<>();
        Queue<int[]> atlantic = new LinkedList<>();
        for(int col = 0; col < cols; col++) {
            pacific.add(new int[]{0, col});
            atlantic.add(new int[]{rows - 1, col});
        }
        
        for(int row = 0; row < rows; row++) {
            pacific.add(new int[]{row, 0});
            atlantic.add(new int[]{row, cols - 1});
        }
        
        boolean[][] pacificReachable = bfs(heights, pacific);
        boolean[][] atlanticReachable = bfs(heights, atlantic);
        
        List<List<Integer>> res = new ArrayList<>();
        for( int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(pacificReachable[i][j] && atlanticReachable[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }
        return res;
    
    }
    
    private boolean[][] bfs(int[][]heights, Queue<int[]> queue) {
        boolean[][] reachable = new boolean[rows][cols];
        int[][] directions = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            reachable[row][col] = true;
            for(int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    if(reachable[newRow][newCol]) {
                        continue;
                    }
                    if(heights[newRow][newCol] >= heights[row][col]) {
                        reachable[newRow][newCol] = true;
                        queue.add(new int[]{newRow, newCol});
                    }
                }
                    
                
                 
            }
        }
        return reachable;
    }
}