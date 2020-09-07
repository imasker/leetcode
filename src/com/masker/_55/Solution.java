package com.masker._55;

/**
 * https://leetcode-cn.com/problems/jump-game/
 */
public class Solution {

    public boolean canJump(int[] nums) {
        int maxPos = 0;
        for (int i = 0; i < nums.length; i++) {
            maxPos = Math.max(maxPos, i+nums[i]);
            if (i >= maxPos && i < nums.length-1) {
                return false;
            }
        }
        return true;
    }
}
