// O(N) O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int low = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (profit < prices[i] - low) {
                profit = prices[i] - low;
            }
            if (prices[i] < low) {
                low = prices[i];
            }
        }
        return profit;
    }
}