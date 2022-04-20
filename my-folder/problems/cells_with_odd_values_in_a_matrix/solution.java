class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] mat = new int[m][n];
        
        for(int[] arr: indices)
        {
            int r = arr[0];
            int c = arr[1];
            
            //incrementing row
            for(int i = 0; i < n; ++i)
                ++mat[r][i];
            
            //incrementing col
            for(int i = 0; i < m; ++i)
                ++mat[i][c];
        }
        
        int oddCount = 0;
        for(int i = 0; i < m; ++i)
        {
            for(int j = 0; j < n; ++j)
            {
                if(mat[i][j] % 2 != 0)
                    ++oddCount;
            }
        }
        
        return oddCount;
    }
}