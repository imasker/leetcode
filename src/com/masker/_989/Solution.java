package com.masker._989;

import java.util.ArrayList;
import java.util.List;

/**
 * @author masker
 * @date 2019/10/18 7:24 PM
 */
public class Solution {

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> tempAns = new ArrayList<>();
        for (int i = A.length-1; i >= 0; i--) {
            tempAns.add(A[i]);
        }
        tempAns.set(0, tempAns.get(0) + K);
        for (int i = 0; i < tempAns.size(); i++) {
            int temp1 = tempAns.get(i) % 10;
            int temp2 = tempAns.get(i) / 10;
            tempAns.set(i, temp1);
            if (temp2 > 0) {
                if (tempAns.size() == i+1) {
                    tempAns.add(temp2);
                } else {
                    tempAns.set(i+1, tempAns.get(i+1) + temp2);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = tempAns.size()-1; i >= 0; i--) {
            ans.add(tempAns.get(i));
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = new int[]{1,2,0,0};
        int K = 34;
        solution.addToArrayForm(A, K);
    }
}
