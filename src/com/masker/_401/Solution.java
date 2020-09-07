package com.masker._401;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> ans = new ArrayList<>();
        if (num == 0) {
            ans.add("0:00");
        } else {
            foo(0, 0, num, -1, ans);
        }
        return ans;
    }

    private void foo(int h, int m, int num, int prevPos, List<String> ans) {
        int curPos = prevPos + 1;
        while (curPos < 10) {
            int hour = h;
            int min = m;
            if (curPos < 6) {
                min = m + (1 << curPos);
            } else {
                hour = h + (1 << (curPos - 6));
            }
            if (min > 59 || hour > 11) {
                curPos++;
                continue;
            }
            if (num == 1) {
                String str = hour + ":" + String.format("%02d", min);
                ans.add(str);
            } else {
                foo(hour, min, num - 1, curPos, ans);
            }
            curPos++;
        }
    }

    public List<String> readBinaryWatch1(int num) {
        List<String> times = new ArrayList<>();
        for (int h=0;h<12;h++) {
            for (int m=0;m<60;m++) {
                if (Integer.bitCount(h)+Integer.bitCount(m)==num)
                    times.add(String.format("%d:%02d",h,m));
            }
        }
        return times;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strs = solution.readBinaryWatch(2);
        for (String str : strs) {
            System.out.println(str);
        }
    }
}
