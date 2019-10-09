package com.masker._90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author masker
 * @date 2019/9/20 8:28 PM
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            int dupCount = 0;
            while (i+1 < nums.length && nums[i] == nums[i+1]) {
                dupCount++;
                i++;
            }
            int prevNum = ans.size();
            for (int j = 0; j < prevNum; j++) {
                List<Integer> temp = new ArrayList<>(ans.get(j));
                for (int k = 0; k <= dupCount; k++) {
                    temp.add(nums[i]);
                    ans.add(new ArrayList<>(temp));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
