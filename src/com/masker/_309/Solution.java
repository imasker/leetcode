package com.masker._309;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class Solution {

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp0 = 0;
        int dp1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, dp0 - prices[i] - fee);
        }
        return dp0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{1,3,2,8,4,9}, 2));
    }
}
