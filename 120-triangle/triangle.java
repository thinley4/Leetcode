class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] memo = new int[n];

        // store in memo
        for(int i=0; i<n; i++) {
            memo[i] = triangle.get(n-1).get(i);
        }

        // second last row to 1st row
        for(int r = n-2; r >= 0; r--) {
            
            // min + second last row element value
            for(int c=0; c <= r; c++) {
                memo[c] = Math.min(memo[c], memo[c+1]) + triangle.get(r).get(c);
            }
        }

        return memo[0];
    }
}