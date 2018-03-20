package com.masker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author masker
 * @date 2018/3/15 上午10:48
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        String ans;
        int start = 0;
        int end = 0;
        if (s.length() == 0 || s.length() == 1) {
            ans = s;
        } else {
            for (int i = 0; i < s.length()-1; i++) {
                if (s.charAt(i) == s.charAt(i+1)) {
                    int left = i-1;
                    int right = i+2;
                    while (left >= 0 && right < s.length()) {
                        if (s.charAt(left) != s.charAt(right)) {
                            break;
                        }
                        left--;
                        right++;
                    }
                    if (right-left-2 > end-start) {
                        start = left+1;
                        end = right-1;
                    }
                }
            }
            for (int i = 0; i < s.length(); i++) {
                int left = i-1;
                int right = i+1;
                while (left >= 0 && right < s.length()) {
                    if (s.charAt(left) != s.charAt(right)) {
                        break;
                    }
                    left--;
                    right++;
                }
                if (right-left-2 > end-start) {
                    start = left+1;
                    end = right-1;
                }
            }
            ans = s.substring(start, end+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();
        String s = "babad";
        System.out.println(l.longestPalindrome(s));
    }
}
