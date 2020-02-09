package com.masker._921;

/**
 * @author masker
 * @date 2019/11/8 8:39 PM
 */
public class Solution {

    public int minAddToMakeValid(String S) {
        int left = 0;
        int add = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                left++;
            } else {
                if (left > 0) {
                    left--;
                } else {
                    add++;
                }
            }
        }
        add += left;
        return add;
    }
}
