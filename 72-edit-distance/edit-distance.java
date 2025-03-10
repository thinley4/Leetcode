class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];

        // Fill first '0' col
        for(int i=1; i<=m; i++) {
            dp[i][0] = i;
        }
        //Fill first '0' row
        for(int j=1; j<=n; j++) {
            dp[0][j] = j;
        }
        // Fill remaining box in matrix
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                //Same characters
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]; // no operation
                } else {
                    // replace // delete // insert
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}