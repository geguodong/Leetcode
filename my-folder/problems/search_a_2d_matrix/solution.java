/*
Binary Search
Time complexity : O(log(mn)) since it's a standard binary search.
Space complexity :O(1).
*/
/*
O(max(m,n))
O(1)
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int curRow = matrix.length - 1;
        int curCol = 0;
        
        while (curRow >= 0 && curCol <= matrix[0].length - 1) {
            int cur = matrix[curRow][curCol];
            if (cur == target) {
                return true;
            } else if (cur < target) {
                curCol++;
            } else {
                curRow--;
            }
        }
        return false;
    }
}