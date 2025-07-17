class Solution {
    public boolean notRow(int num, char[][] board, int r) {
        for(int i=0; i<9; i++) {
            if(num == board[r][i] - '0')
                return false;
        }
        return true;
    }

    public boolean notCol(int num, char[][] board, int c) {
        for(int i=0; i<9; i++) {
            if(num == board[i][c] - '0')
                return false;
        }
        return true;        
    }

    public boolean notSubMatrix(int num, int r, int c, char[][] board) {
        int sr = r - r % 3;
        int sc = c - c % 3;
        
        for(int i=sr; i<sr+3; i++) {
            for(int j=sc; j<sc+3; j++) {
                if(num == board[i][j] - '0')
                    return false;
            }
        }
        return true;
    }

    public boolean helper(char[][] board, boolean[][] original, int rlen, int clen) {
        for(int r=0; r<rlen; r++) {
            for(int c=0; c<clen; c++) {
                // zero: 1 to 9, row, col and sub matrix
                // valid: store the value, 
                // not valid: backtrack
                if(!original[r][c] && board[r][c] == '.') {
                    for(int num=1; num <= 9; num++) {
                        // valid
                        if(notRow(num, board, r) && notCol(num, board, c) && notSubMatrix(num, r, c, board)) {
                            board[r][c] = (char)(num + '0');
                            
                            // if lead to soln
                            if( helper(board, original, rlen, clen) )
                                return true;
                                
                            // backtrack 
                            board[r][c] = '.';
                        }
                    }
                    // If no number fits, return false
                    return false;
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        int rlen = board.length;
        int clen = board[0].length;
        boolean[][] original = new boolean[rlen][clen];
        
        // non-zero: true
        for(int i=0; i<rlen; i++) {
            for(int j=0; j<clen; j++) {
                if(board[i][j] != '.') {
                    original[i][j] = true;
                }
            }
        }
        
        helper(board, original, rlen, clen);
    }
}
