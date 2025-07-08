// Algorithm
// 1. visiting each and every elements 
// 2. check island or water
// 3. if (land and not visited)
// - increment
// - find conneted island (visit adjacent lands)
// 5. if not island or visited
// -    go to next


class Solution {
    public void find_lands(int r, int c, int rlen, int clen, boolean[][] visited, char[][] grid) {
        // up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int[] direction : directions) {
            int nr = r + direction[0];
            int nc = c + direction[1];
            
            // valid: not visited & '1' & inside the grid
            if(nr >= 0 && nr < rlen && nc >= 0 && nc < clen && !visited[nr][nc] && grid[nr][nc] == '1') {
                visited[nr][nc] = true;
                find_lands(nr, nc, rlen, clen, visited, grid);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int rlen = grid.length;
        int clen = grid[0].length;
        boolean[][] visited = new boolean[rlen][clen];
        int count = 0;

        // traverse every element in an array
        for(int r=0; r < rlen; r++) {
            for(int c=0; c < clen; c++) {
                // if not visited and island
                if(grid[r][c] == '1' && !visited[r][c]) {
                    count++;
                    visited[r][c] = true;
                    find_lands(r, c, rlen, clen, visited, grid);
                }
            }
        }
        return count;
    }
}