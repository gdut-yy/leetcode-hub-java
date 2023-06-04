package c281;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc281_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = scanner.next();
        System.out.println(solve(s));
    }

    private static String solve(String s) {
        if (s.length() != 8) {
            return "No";
        }
        if (!Character.isUpperCase(s.charAt(0)) || !Character.isUpperCase(s.charAt(7))) {
            return "No";
        }
        for (int i = 1; i < 7; i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return "No";
            }
        }
        int n = Integer.parseInt(s.substring(1, 7));
        if (n < 100000 || n > 999999) {
            return "No";
        }
        return "Yes";
    }
}
/*
B - Sandwich Number
https://atcoder.jp/contests/abc281/tasks/abc281_b

題目大意：
给你一个由大写英文字母和数字组成的字符串 S。判断 S 是否满足以下条件。
- S 是下列字符和字符串按列出的顺序的连接。
  - 大写英文字母
  - 长度为 6 的字符串，是 100000 到 999999(包括 100000 和 999999)之间整数的十进制表示形式
  - 大写英文字母

模拟。
======

Input 1
Q142857Z
Output 1
Yes

Input 2
AB912278C
Output 2
No

Input 3
X900000
Output 3
No

Input 4
K012345K
Output 4
No
 */