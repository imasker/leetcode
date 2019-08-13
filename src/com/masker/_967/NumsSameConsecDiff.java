package com.masker._967;

import java.util.ArrayList;
import java.util.List;

public class NumsSameConsecDiff {

    public int[] numsSameConsecDiff(int N, int K) {
        List<int[]> list = func(N, K);
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            int sum = 0;
            for (int j = N-1; j >= 0; j--) {
                sum += list.get(i)[j] * Math.pow(10, (N - 1 - j));
            }
            ans[i] = sum;
        }
        return ans;
    }

    private List<int[]> func(int N, int K) {
        List<int[]> list = new ArrayList<>();
        if (N == 1) {
            for (int j = 1; j < 10; j++) {
                int[] arr = {j};
                list.add(arr);
            }
        } else {
            List<int[]> list1 = func(N-1, K);
            for (int[] arr : list1) {
                if (arr[N-2] + K <= 9) {
                    int[] narr = new int[N];
                    for (int i = 0; i < N-1; i++) {
                        narr[i] = arr[i];
                    }
                    narr[N-1] = arr[N-2] + K;
                    list.add(narr);
                }
                if (arr[N-2] - K >= 0) {
                    int[] narr = new int[N];
                    for (int i = 0; i < N-1; i++) {
                        narr[i] = arr[i];
                    }
                    narr[N-1] = arr[N-2] - K;
                    list.add(narr);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        NumsSameConsecDiff object = new NumsSameConsecDiff();
        int[] nums = object.numsSameConsecDiff(3, 7);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
