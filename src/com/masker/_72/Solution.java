package com.masker._72;

/**
 * @author masker
 * @date 2020/2/9 1:49 PM
 */
public class Solution {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        if (m * n == 0) {
            return m + n;
        }

        int[][] dp = new int[m + 1][n + 1];

        // 第一行
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j-1] + 1;
        }

        // 第一列
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i-1][0] + 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
                }
            }
        }

        return dp[m][n];
    }
}
