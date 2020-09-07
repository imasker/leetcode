package com.masker._45;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/jump-game/
 */
public class Solution {

    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0;
        int farthest = 0;
        int jump = 0;
        for (int i = 0; i < n-1; i++) {
            farthest = Math.max(nums[i] + i, farthest);
            if (end == i) {
                jump++;
                end = farthest;
            }
        }
        return jump;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().jump(new int[]{2,3,1,1,4}));
    }
}
