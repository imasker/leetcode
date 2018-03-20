package com.masker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author masker
 * @date 2018/3/14 上午10:53
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && nums[i] <= target; i++) {
            if (i != 0 && nums[i-1] == nums[i]) {
                continue;
            }
            for (int j = nums.length-1; j > i+2 && nums[j] >= target; j--) {
                if (j != nums.length-1 && nums[j+1] == nums[j]) {
                    continue;
                }
                int p1 = i+1;
                int p2 = j-1;
                while (p1 < p2) {
                    int sum = nums[i] + nums[p1] + nums[p2] + nums[j];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[p1]);
                        temp.add(nums[p2]);
                        temp.add(nums[j]);
                        result.add(temp);
                        while (p1 < p2 && nums[p1+1] == nums[p1]) {
                            p1++;
                        }
                        p1++;
                        while (p1 < p2 && nums[p2-1] == nums[p2]) {
                            p2--;
                        }
                        p2--;
                    } else if (sum < target) {
                        p1++;
                        while (p1 < p2 && nums[p1+1] == nums[p1]) {
                            p1++;
                        }
                    } else {
                        p2--;
                        while (p1 < p2 && nums[p2-1] == nums[p2]) {
                            p2--;
                        }
                    }
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,5,3,5,1,-5,1,-2};
        int target = 4;
        FourSum fourSum = new FourSum();
        List<List<Integer>> result = fourSum.fourSum(nums, target);
        System.out.println(result);
    }
}
