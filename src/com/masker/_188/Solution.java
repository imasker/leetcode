package com.masker._188;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class Solution {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k > n/2) {
            int[] dp = new int[2];
            dp[0] = 0; // 不持有
            dp[1] = Integer.MIN_VALUE; // 持有
            for (int i = 1; i <= n; i++) {
                dp[0] = Math.max(dp[0], dp[1] + prices[i - 1]);
                dp[1] = Math.max(dp[1], dp[0] - prices[i - 1]);
            }
            return dp[0];
        } else {
            int[][] dp = new int[k + 1][2];
            for (int i = 0; i < k + 1; i++) {
                dp[i][0] = 0; // 不持有
                dp[i][1] = Integer.MIN_VALUE; // 持有
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < k; j++) {
                    dp[j][0] = Math.max(dp[j][0], dp[j][1] + prices[i - 1]);
                    dp[j][1] = Math.max(dp[j][1], dp[j + 1][0] - prices[i - 1]);
                }
                dp[k][0] = Math.max(dp[k][0], dp[k][1] + prices[i - 1]);
                dp[k][1] = Integer.MIN_VALUE;
            }
            return dp[0][0];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(2, new int[]{3,3,5,0,0,3,1,4}));
    }
}
