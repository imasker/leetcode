package com.masker._66;

import java.util.Arrays;

/**
 * @author masker
 * @date 2019/10/11 7:06 PM
 */
public class Solution {

    public int[] plusOne(int[] digits) {
        int[] ans = Arrays.copyOf(digits, digits.length);
        ans[ans.length-1] += 1;
        for (int i = ans.length-1; i >= 0; i--) {
            if (ans[i] > 9) {
                if (i == 0) {
                    int[] newAns = new int[ans.length+1];
                    for (int j = 0; j < ans.length; j++) {
                        newAns[j+1] = ans[j];
                    }
                    newAns[0] = newAns[1] / 10;
                    newAns[1] = newAns[1] % 10;
                    return newAns;
                } else {
                    ans[i-1] += ans[i] / 10;
                    ans[i] = ans[i] % 10;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}
