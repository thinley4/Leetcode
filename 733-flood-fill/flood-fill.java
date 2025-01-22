class Solution {
    // DFS Approach
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int n = image.length; // Row length
        int m = image[0].length; // Column length
        boolean[][] visited = new boolean[n][m]; // track visited pixel
        int ogColor = image[sr][sc]; // Starting pixel color

        dfs(sr, sc, n, m, visited, image, color, ogColor);
        return image;

    }

    private void dfs(int i, int j, int n, int m, boolean[][] visited, int[][] image, int color, int ogColor) {

        // Outof bound, visited, Not ogColor, if already color pixel
        if(i < 0 || j < 0 || i>=n || j>=m || visited[i][j] || image[i][j] != ogColor || color == image[i][j]) {
            return;
        }

        visited[i][j] = true; 
        image[i][j] = color;

        // Recursively visit all 4 directions
        dfs(i, j-1, n, m, visited, image, color, ogColor); // left
        dfs(i, j+1, n, m, visited, image, color, ogColor); // right
        dfs(i+1, j, n, m, visited, image, color, ogColor); // down
        dfs(i-1, j, n, m, visited, image, color, ogColor); // up

    }
}