package com.masker._46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 */
public class Solution {

    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        List<Integer> list = new ArrayList<>(nums.length);
        backtrace(nums, used, list);
        return res;
    }

    private void backtrace(int[] nums, boolean[] used, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    list.add(nums[i]);
                    backtrace(nums, used, list);
                    list.remove(list.size()-1);
                    used[i] = false;
                }
            }
        }
    }
}
