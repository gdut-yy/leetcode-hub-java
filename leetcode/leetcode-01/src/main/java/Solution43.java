import java.math.BigInteger;

public class Solution43 {
    static class V1 {
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }
            int m = num1.length(), n = num2.length();
            int[] ansArr = new int[m + n];
            for (int i = m - 1; i >= 0; i--) {
                int x = num1.charAt(i) - '0';
                for (int j = n - 1; j >= 0; j--) {
                    int y = num2.charAt(j) - '0';
                    ansArr[i + j + 1] += x * y;
                }
            }
            for (int i = m + n - 1; i > 0; i--) {
                ansArr[i - 1] += ansArr[i] / 10;
                ansArr[i] %= 10;
            }
            int idx = ansArr[0] == 0 ? 1 : 0;
            StringBuilder ans = new StringBuilder();
            while (idx < m + n) {
                ans.append(ansArr[idx]);
                idx++;
            }
            return ans.toString();
        }
    }

    static class V2 {
        public String multiply(String num1, String num2) {
            return new BigInteger(num1).multiply(new BigInteger(num2)).toString();
        }
    }
}
/*
43. 字符串相乘
https://leetcode.cn/problems/multiply-strings/

给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
提示：
1 <= num1.length, num2.length <= 200
num1 和 num2 只能由数字组成。
num1 和 num2 都不包含任何前导零，除了数字0本身。

朴素乘法 或者 BigInteger
（实际工程中意义不大）
 */