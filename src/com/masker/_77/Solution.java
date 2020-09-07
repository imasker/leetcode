package com.masker._77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combinations/
 */
public class Solution {

    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>(k);
        backtrace(n, k, 1, list);
        return res;
    }

    private void backtrace(int n, int k, int index, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
        } else {
            while (index <= n) {
                list.add(index);
                backtrace(n, k, index+1, list);
                list.remove(list.size()-1);
                index++;
            }
        }
    }
}
