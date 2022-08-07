class Solution {
    int getMaxColIndex(int[] nums)
    {
        int mxNum = 0, mxIdx = -1;
        for (int i = 0; i < nums.length; i++) 
        {
            if (nums[i] > mxNum) { mxNum = nums[i]; mxIdx = i; }
        }
        return mxIdx;
    }
    public int[] findPeakGrid(int[][] grid) 
    {
        int m = grid.length, n = grid[0].length;
        int low = 0, high = m - 1;
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            int maxColIdx = getMaxColIndex(grid[mid]);
            int maxElement = grid[mid][maxColIdx]; //maximum element in current row
			            //guarantees that current element is greater than both leftValue and rightValue
            
            boolean validTop = (mid == 0)? true : (grid[mid - 1][maxColIdx] < maxElement);
            boolean validBottom = (mid == m - 1)? true : (grid[mid + 1][maxColIdx] < maxElement);
            
            if (validTop && validBottom) return (new int[]{mid, maxColIdx});
            else if (validTop) low = mid + 1; //topVal is less than curr but bottomValue is greater than curr
            else high = mid - 1;  //1. bottomValue is less then curr but topValue is greater than curr
                                  //2. both bottomValue and topValue is greater than curr
        }
        return (new int[]{-1, -1}); 
    }
}