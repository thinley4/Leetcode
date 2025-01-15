import java.util.Arrays;

class Solution {
    private int solve(int index, boolean buy, int cnt, int n, int[] prices, int[][][] dp) {
        // Base case
        // n = length of prices
        // cnt = 2 (Max transistion)
        if (index == n || cnt == 0) {
            return 0;
        }
        // buy = 1, sell = 0
        if (dp[index][buy ? 1 : 0][cnt] != -1) {
            return dp[index][buy ? 1 : 0][cnt];
        }
        int profit = 0;

        if (buy) {
            // If I want to buy
            // Money will be gone so '-prices[index]'
            int pick = -prices[index] + solve(index + 1, false, cnt, n, prices, dp);
            // If I don't want to buy
            int notPick = solve(index + 1, true, cnt, n, prices, dp);
            profit = Math.max(pick, notPick);
        } else {
            // If I want to sell
            int pick = prices[index] + solve(index + 1, true, cnt - 1, n, prices, dp);
            // If I don't want to sell
            int notPick = solve(index + 1, false, cnt, n, prices, dp);
            profit = Math.max(pick, notPick);
        }
        
        return dp[index][buy ? 1 : 0][cnt] = profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];
        for (int[][] rows : dp) {
            for (int[] row : rows) {
                Arrays.fill(row, -1);
            }
        }
        return solve(0, true, 2, n, prices, dp);
    }
}