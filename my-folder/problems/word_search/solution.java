// Backtracking 
// O(N* 3^L)  where NN is the number of cells in the board and LL is the length of the word to be matched. 
// O(L) where LL is the length of the word to be matched.
class Solution {
    char[][] board;
    int rows;
    int cols;
    
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(backtrack(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean backtrack(char[][] board, int row, int col, String word, int index) {
        // check success case
        if(index >= word.length()) {
            return true;
        }
        // check edge case
        if(row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != word.charAt(index)) {
            return false;
        }
        
        // mark viristed
        board[row][col] = '#';
        // use DFS to check negh
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for(int[] dir : directions) {
            int newRow = dir[0] + row;
            int newCol = dir[1] + col;
            if(backtrack(board, newRow, newCol, word, index + 1)) {
                return true;
            }
        }
        
        // clean visit
        board[row][col] = word.charAt(index);
        return false;  
    }
}