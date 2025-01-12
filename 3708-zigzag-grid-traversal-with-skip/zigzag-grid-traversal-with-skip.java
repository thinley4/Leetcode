class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        boolean skip=false;
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<rows; i++){
            if(i%2 == 0) {
                // Even, left -> right
                for(int j=0; j<cols; j++){
                    if(!skip){
                        ans.add(grid[i][j]);
                    }
                    skip = !skip; // toggle
                }
            } else {
                // Odd right -> left
                for(int j=cols-1; j>=0; j--){
                    if(!skip){
                        ans.add(grid[i][j]);
                    }
                    skip = !skip; // toggle
                }
            }
        }
        return ans;
    }
}