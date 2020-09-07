package com.masker._123;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][3][2];
        for (int i = 0; i < 3; i++) {
            dp[0][i][0] = 0; // 不持有
            dp[0][i][1] = Integer.MIN_VALUE; // 持有
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i - 1]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j+1][0] - prices[i - 1]);
            }
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i - 1]);
            dp[i][2][1] = Integer.MIN_VALUE;
        }
        return dp[n][0][0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{3,2,6,5,0,3}));
    }
}
