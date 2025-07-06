class Solution {
    public void findLands(boolean[][] visited, char[][] grid, int r, int c, int rows, int cols) {
        // left, right, up, down
        int[][] directions = {{0,-1}, {0, 1}, {-1, 0}, {1, 0}}; 

        for(int[] direction : directions) {
            int crow = r + direction[0];
            int ccol = c + direction[1];
            // // valid - inside grid, not visited, char = '1'
            if(crow >= 0 && crow < rows && ccol >= 0 && ccol < cols && !visited[crow][ccol] && grid[crow][ccol] == '1') {
                visited[crow][ccol] = true; // make true
                findLands(visited, grid, crow, ccol, rows, cols);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int land = 0;

        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                // 1 and not visited
                if(grid[r][c] == '1' && !visited[r][c]) {
                    land++;
                    visited[r][c] = true;
                    findLands(visited, grid, r, c, rows, cols);
                }
            }
        }
        return land;
    }
}