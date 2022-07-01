// DFS
// O(MN) O(MN)
class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
         
        List<int[]> list = new LinkedList<>();
        
        for (int r = 0; r < board.length; r++) {
            if(board[r][0] == 'O') {
                list.add(new int[]{r, 0});
            }  
            if(board[r][board[0].length - 1] == 'O') {
                list.add(new int[]{r, board[0].length - 1});
            }
        }
        
        for (int c = 0; c < board[0].length; c++) {
            if(board[0][c] == 'O') {
                list.add(new int[]{0, c});
            }
            if(board[board.length - 1][c] == 'O') {
                list.add(new int[]{board.length - 1, c});
            }
        }
        
        for(int[] cur : list) {
            this.dfs(board, cur[0], cur[1]);
        }
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'E') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        
    }
    
    private void dfs(char[][] board, int row, int col) {
        if(board[row][col] != 'O') {
            return;
        }
        board[row][col] = 'E';
        if(row < board.length - 1) {
            dfs(board, row + 1, col);
        }
        if(row > 0) {
            dfs(board, row - 1, col);
        }
        if(col > 0) {
            dfs(board, row, col - 1);
        }
        if(col < board[0].length - 1) {
            dfs(board, row, col + 1);
        }
    }
}