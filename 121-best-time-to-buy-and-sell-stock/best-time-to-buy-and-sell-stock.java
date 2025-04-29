class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy_price = prices[0];

        for(int i=1; i<prices.length; i++) {
            // update buy_price when curr_price < profit
            if(prices[i] < buy_price) {
                buy_price = prices[i];
            }
            // curr prices - buy price
            profit = Math.max(profit, prices[i] - buy_price);
        }
        return profit;
    }
}
