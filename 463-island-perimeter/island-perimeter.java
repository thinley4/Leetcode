class Solution {
    public int islandPerimeter(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int totalSum = 0;

        for(int i=0; i<grid.length; i++) {
            // visit all grid
            for(int j=0; j<grid[0].length; j++) {
                // if land then check left, top, right, bottom
                if(grid[i][j] == 1) {
                    // sum = perimeter for each island
                    int sum = check(i, j, grid, rowLen, colLen);
                    totalSum += sum;
                }
            }
        }
        
        return totalSum;
    }
    public int check(int i, int j,int[][] grid, int rowLen, int colLen) {
        // check left, top, right and bottom
        int[][] fourSide = {
            // left, top, right, bottom 
            {0, -1}, {-1, 0}, {0, 1}, {1, 0}
        };
        int count = 0;

        for(int[] oneSide: fourSide) {
            int newRow = oneSide[0]+i;
            int newCol = oneSide[1]+j;

            if( newRow < 0 || newRow >= rowLen || newCol < 0 || newCol >= colLen || grid[newRow][newCol] == 0) {
                // if outofbound Or water, increase count
                count++;
            } 
        }
        
        return count;
    }
}