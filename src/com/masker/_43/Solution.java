package com.masker._43;

/**
 * @author masker
 * @date 2019/10/11 6:26 PM
 */
public class Solution {

    public String multiply(String num1, String num2) {
        int[] result = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            int zeroNum1 = num1.length() - i - 1;
            char c1 = num1.charAt(i);
            int n1 = charToInt(c1);
            for (int j = 0; j < num2.length(); j++) {
                int zeroNum2 = num2.length() - j - 1;
                int zeroNum = zeroNum1 + zeroNum2;
                char c2 = num2.charAt(j);
                int n2 = charToInt(c2);
                int mult = n1 * n2;
                int mult1 = mult / 10;
                int mult2 = mult % 10;
                result[zeroNum] += mult2;
//                if (result[zeroNum] > 9) {
//                    result[zeroNum+1] += 1;
//                }
                result[zeroNum+1] += mult1;
            }
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] > 9) {
                result[i+1] += result[i] / 10;
                result[i] = result[i] % 10;
            }
        }
        int i = result.length - 1;
        while (i >= 0 && result[i] == 0) {
            i--;
        }
        if (i == -1) {
            return "0";
        } else {
            StringBuilder builder = new StringBuilder();
            while (i >= 0) {
                builder.append(result[i]);
                i--;
            }
            return builder.toString();
        }
    }

    private int charToInt(char c) {
        int a;
        switch (c) {
            case '0':
                a = 0;
                break;
            case '1':
                a = 1;
                break;
            case '2':
                a = 2;
                break;
            case '3':
                a = 3;
                break;
            case '4':
                a = 4;
                break;
            case '5':
                a = 5;
                break;
            case '6':
                a = 6;
                break;
            case '7':
                a = 7;
                break;
            case '8':
                a = 8;
                break;
            case '9':
                a = 9;
                break;
            default:
                return -1;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.multiply("123", "456"));
    }
}
