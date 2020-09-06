package com.masker._423;

import java.util.HashMap;
import java.util.Map;

/**
 * @author masker
 * @date 2020/2/28 5:45 PM
 */
public class Solution {

    public String originalDigits(String s) {
        String[] list = new String[] {
                "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
        };
        StringBuilder ans = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int[] nums = new int[10];
        nums[0] = map.getOrDefault('z', 0);
        nums[2] = map.getOrDefault('w', 0);
        nums[4] = map.getOrDefault('u', 0);
        nums[6] = map.getOrDefault('x', 0);
        nums[8] = map.getOrDefault('g', 0);
        nums[3] = map.getOrDefault('r', 0) - nums[0] - nums[4];
        nums[1] = map.getOrDefault('o', 0) - nums[0] - nums[2] - nums[4];
        nums[5] = map.getOrDefault('f', 0) - nums[4];
        nums[7] = map.getOrDefault('v', 0) - nums[5];
        nums[9] = (map.getOrDefault('n', 0) - nums[1] - nums[7]) / 2;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i]; j++) {
                ans.append(i);
            }
        }
        return ans.toString();
    }
}
