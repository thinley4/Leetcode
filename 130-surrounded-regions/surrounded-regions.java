class Solution {
    public void dfs(int r, int c, int rows, int cols, char[][] board) {
        if(r<0 || r>=rows || c<0 || c>=cols || board[r][c] != 'O')
            return;
        // if 'O'
        // if 'O' & is inside board than make 'T'
        board[r][c] = 'T';

        // check all direction for 'O'
        dfs(r+1, c, rows, cols, board);
        dfs(r-1, c, rows, cols, board);
        dfs(r, c+1, rows, cols, board);
        dfs(r, c-1, rows, cols, board);
    }

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        // check first & last rows and cols
        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                if(r==0 || r == rows-1 || c == 0 || c == cols-1) {
                    dfs(r, c, rows, cols, board);
                }
            }
        }

        // make middle 'O' -> 'X'
        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                if(board[r][c] == 'O') 
                    board[r][c] = 'X';
            }
        }

        // make 'T' -> 'O'
        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                if(board[r][c] == 'T')
                    board[r][c] = 'O';
            }
        }
    }
}