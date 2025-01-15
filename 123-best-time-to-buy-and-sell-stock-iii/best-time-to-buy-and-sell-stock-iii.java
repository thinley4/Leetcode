import java.util.Arrays;

class Solution {
    private int solve(int index, boolean buy, int cnt, int n, int[] prices, int[][][] dp) {
        if (index == n || cnt == 0) {
            return 0;
        }
        if (dp[index][buy ? 1 : 0][cnt] != -1) {
            return dp[index][buy ? 1 : 0][cnt];
        }
        int profit = 0;
        if (buy) {
            int pick = -prices[index] + solve(index + 1, false, cnt, n, prices, dp);
            int notPick = solve(index + 1, true, cnt, n, prices, dp);
            profit = Math.max(pick, notPick);
        } else {
            int pick = prices[index] + solve(index + 1, true, cnt - 1, n, prices, dp);
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