class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i=2; i<n; i++) {
            // Sum of Curr cost value and Min of i-1 & i-2
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }

        // Since last index and second last index values are end so, the min value is return
        return Math.min(dp[n-1], dp[n-2]);
    }
}