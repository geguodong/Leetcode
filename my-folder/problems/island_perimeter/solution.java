/*
Time complexity : O(mn) where mm is the number of rows of the grid and nn is the number of columns of the grid. Since two for loops go through all the cells on the grid, for a two-dimensional grid of size m\times nm×n, the algorithm would have to check mnmn cells.

Space complexity : O(1). Only the result variable is updated and there is no other space requirement.

*/
class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int result = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    result += 4;
                    
                    if (r > 0 && grid[r-1][c] == 1) {
                        result -= 2;
                    }
                    
                    if (c > 0 && grid[r][c-1] == 1) {
                        result -= 2;
                    }
                }
            }
        }
        
    return result;
    }
}
  