// Priority Queue
// O(N) O(N)

class Pair {
    int row;
    int col;
    int height;
    
    public Pair(int row, int col, int height) {
        this.row = row;
        this.col = col;
        this.height = height;
    }
}
class Solution {
    public int trapRainWater(int[][] heightMap) {
        int rows = heightMap.length;
        int cols = heightMap[0].length;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.height - b.height);
        boolean[][] visited = new boolean[rows][cols];
        // add 4 edges to pq;
        for(int i = 0; i < rows; i++) {
            pq.add(new Pair(i, 0, heightMap[i][0]));
            visited[i][0] = true;
            pq.add(new Pair(i, cols - 1, heightMap[i][cols - 1]));
            visited[i][cols - 1] = true;
        }
        for(int j = 1; j < cols - 1; j++) {
            pq.add(new Pair(0, j, heightMap[0][j]));
            visited[0][j] = true;
            pq.add(new Pair(rows - 1, j, heightMap[rows - 1][j]));
            visited[rows - 1][j] = true;
        }
        // for(int i = 0; i < rows; i++) {
        //      for(int j = 0; j < cols; j++) {
        //          if(i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
        //               pq.add(new Pair(i, j, heightMap[i][j]));
        //               visited[i][j] = true;
        //           }
        //       }
        //   }
        
        int[][] directions = new int[][] {{-1,0}, {1,0}, {0,1}, {0,-1}};
        
        int res = 0;
        
        while(!pq.isEmpty()) {
            Pair cur = pq.poll();
            for(int[] dir : directions) {
                int r = cur.row + dir[0];
                int c = cur.col + dir[1];
                if(r >= 0 && r < rows && c >= 0 && c < cols && !visited[r][c]) {
                    if(cur.height > heightMap[r][c]) {
                        res += cur.height - heightMap[r][c];
                    }
                    visited[r][c] = true;
                    pq.add(new Pair(r, c, Math.max(cur.height, heightMap[r][c])));
                }
            }
        }
        return res;
    }
}