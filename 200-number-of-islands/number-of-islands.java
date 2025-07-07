class Solution {
    public void findLands(int r, int c, boolean[][] visited, int rlen, int clen, char[][] grid, Queue<int[]> q) {
        // left, right, up, down
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!q.isEmpty()) {
            int size = q.size();

            if(size > 0) {
                int[] currElement = q.poll();
                // check all 4 directions
                for(int[] direction : directions) {
                    int nr = currElement[0] + direction[0];
                    int nc = currElement[1] + direction[1];
                    // Valid: Inside grid & 1 & not visited
                    if(nr >= 0 && nr < rlen && nc >= 0 && nc < clen && !visited[nr][nc] && grid[nr][nc] == '1') {
                        visited[nr][nc] = true;
                        q.add(new int[] {nr, nc});
                    } 
                }
                size--;
            }
        }
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        int rlen = grid.length;
        int clen = grid[0].length;
        boolean[][] visited;
        visited = new boolean[rlen][clen];
        Queue<int[]> q = new LinkedList<>();

        // visite all elements in a grid
        for(int i=0; i < rlen; i++) {
            for(int j=0; j < clen; j++) {
                // if island '1' & not visited
                if(grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    visited[i][j] = true;
                    q.add(new int[]{i, j});
                    findLands(i, j, visited, rlen, clen, grid, q);
                }
            }
        }
        return count;
    }
}