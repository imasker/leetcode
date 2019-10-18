package com.masker._1160;

import java.util.Arrays;
import java.util.Map;

/**
 * @author masker
 * @date 2019/10/18 7:50 PM
 */
public class Solution {

    public int countCharacters(String[] words, String chars) {
        int[] origin = new int[26];
        for (char c : chars.toCharArray()) {
            origin[c - 'a']++;
        }
        int ans = 0;
        for (String word : words) {
            int[] list = Arrays.copyOf(origin, 26);
            boolean found = true;
            for (char c : word.toCharArray()) {
                list[c - 'a']--;
                if (list[c - 'a'] < 0) {
                    found = false;
                    break;
                }
            }
            if (found) {
                ans += word.length();
            }
        }
        return ans;
    }
}
