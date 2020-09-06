package com.masker._131;

import java.util.ArrayList;
import java.util.List;

/**
 * @author masker
 * @date 2020/2/28 1:44 PM
 */
public class Solution {

    private List<List<String>> result = new ArrayList<>();
    private List<String> temp = new ArrayList<>();

    public List<List<String>> partition(String s) {
        recursion(s, 0, s.length());
        return result;
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private void recursion(String s, int a, int b) {
        // 到字符串末尾，记录结果
        if (a >= b) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = a+1; i <= b; i++) {
            if (isPalindrome(s.substring(a, i))) {
                temp.add(s.substring(a, i));
                recursion(s, i, b);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> result = solution.partition("aab");
        for (List<String> list : result) {
            System.out.println(list.toString());
        }
    }
}
