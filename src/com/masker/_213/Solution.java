package com.masker._213;

public class Solution {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        int[] dp1 = new int[n];
        dp[0] = 0;
        dp1[0] = 0;
        dp[1] = nums[0];
        dp1[1] = nums[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + nums[i]);
        }
        return Math.max(dp[n-1], dp1[n-1]);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{1,2,1,1}));
    }
}
