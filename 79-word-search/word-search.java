class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        if(index == word.length()) return true;

        // Boundary check or mismatch
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || 
           board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';  // mark as visited

        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for(int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            if(dfs(board, word, newRow, newCol, index + 1)) {
                return true;
            }
        }

        board[i][j] = temp;  // backtrack
        return false;
    }
}