package com.masker._122;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        dp[0][0] = 0; // 不持有
        dp[0][1] = Integer.MIN_VALUE; // 持有
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i-1]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i-1]);
        }
        return dp[n][0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
