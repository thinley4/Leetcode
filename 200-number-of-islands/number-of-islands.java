
class Solution {
    public void find_lands(int r, int c, boolean[][] visited, char[][] grid, int rlen, int clen) {
        // visit 4 directions
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int[] direction : directions) {
            int nr = r + direction[0];
            int nc = c + direction[1];
            // Valid: inside grid & '1' && not visited
            if(nr >=0 && nr < rlen && nc >= 0 && nc < clen && grid[nr][nc] == '1' && !visited[nr][nc]) {
                visited[nr][nc] = true;
                // find adjacent of another island
                find_lands(nr, nc, visited, grid, rlen, clen);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int rlen = grid.length;
        int clen = grid[0].length;
        boolean[][] visited = new boolean[rlen][clen];
        int count = 0;

        // Iterate through every element in grid
        for(int r=0; r<rlen; r++) {
            for(int c=0; c<clen; c++) {
                // '1' & not visited
                if(grid[r][c] == '1' && !visited[r][c]) {
                    count++; // no of island
                    visited[r][c] = true; // update to visited
                    find_lands(r, c, visited, grid, rlen, clen);
                }
            }
        }
        return count;
    }
}