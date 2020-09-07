package com.masker._347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        PriorityQueue<NumFrequency> queue = new PriorityQueue<>(k+1, (a, b) -> a.frequency - b.frequency);
        for (int key : map.keySet()) {
            queue.add(new NumFrequency(key, map.get(key)));
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll().num;
        }
        return res;
    }
}

class NumFrequency {
    int num;
    int frequency;

    public NumFrequency(int num, int frequency) {
        this.num = num;
        this.frequency = frequency;
    }
}
