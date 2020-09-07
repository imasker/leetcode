package com.masker._714;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp00 = 0;
        int dp10 = 0;
        int dp11 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp10 = dp10;
            dp10 = Math.max(dp10, dp11 + prices[i]);
            dp11 = Math.max(dp11, dp00 - prices[i]);
            dp00 = temp10;
        }
        return dp10;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{1,2,3,0,2}));
    }
}
