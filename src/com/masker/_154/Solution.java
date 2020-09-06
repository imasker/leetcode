package com.masker._154;

/**
 * @author masker
 * @date 2020/3/7 1:35 PM
 */
public class Solution {

    public int findMin(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i+1]) {
                return nums[i+1];
            }
        }
        return nums[0];
    }
}
