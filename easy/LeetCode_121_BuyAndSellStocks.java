/**
 * LeetCode 121 - https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */

class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int i = 0;
        while (i < prices.length - 1) {
            int j = i + 1;
            while ( j < prices.length) {
                if (prices[j] < prices[i]) break;
                if (profit < (prices[j] - prices[i])) {
                    profit = prices[j] - prices[i];
                }
                j++;
            }
            i = j;
        }

        return profit;
    }
}