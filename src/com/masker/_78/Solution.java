package com.masker._78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<List<Integer>> answers = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        backtrace(nums, n);
        return answers;
    }

    private void backtrace(int[] nums, int index) {
        if (index == 0) {
            answers.add(new ArrayList<>(0));
        } else {
            backtrace(nums, index-1);
            int size = answers.size();
            for (int i = 0; i < size; i++) {
                List<Integer> list = new ArrayList<>(answers.get(i).size()+1);
                list.addAll(answers.get(i));
                list.add(nums[index-1]);
                answers.add(list);
            }
        }
    }
}
