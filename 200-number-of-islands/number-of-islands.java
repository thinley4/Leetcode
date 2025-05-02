class Solution {
    public int numIslands(char[][] grid) {
        HashSet<String> visited = new HashSet<>();
        int island = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] directions = {{1,0}, {-1,0}, {0, 1}, {0, -1}};

        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                // not visited & is '1'
                if(!visited.contains(r+","+c) && grid[r][c] == '1'){
                    island++;
                    bfs(rows, cols, r, c, grid, directions, visited);
                }
            }
        }
        return island;
    }
    public void bfs(int rows, int cols, int r, int c, char[][] grid, int[][] directions, HashSet<String> visited) {
        Queue<int[]> q = new LinkedList<>();
        // store in visited & queue
        visited.add(r+","+c);
        q.add(new int[] {r, c});

        while(!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];

            for(int[] direction : directions) {
                // Updated row = nr & col = nc 
                // (left, right, down, up)
                int nr = row + direction[0];
                int nc = col + direction[1];
                if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == '1' && !visited.contains(nr +"," + nc)) {
                    q.add(new int[] {nr, nc});
                    visited.add(nr+","+ nc);
                }
            }
        }
    }
}