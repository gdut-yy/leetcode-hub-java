package c303;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc303_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        String s = scanner.next();
        String t = scanner.next();
        System.out.println(solve(n, s, t));
    }

    private static String solve(int n, String s, String t) {
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (!check(c1, c2)) {
                return "No";
            }
        }
        return "Yes";
    }

    private static boolean check(char c1, char c2) {
        if (Character.toLowerCase(c1) == Character.toLowerCase(c2)) {
            return true;
        }
        if (c1 == '1' && c2 == 'l' || c1 == 'l' && c2 == '1') {
            return true;
        }
        if (c1 == '0' && c2 == 'o' || c1 == 'o' && c2 == '0') {
            return true;
        }
        return false;
    }
}
/*
A - Similar String
https://atcoder.jp/contests/abc303/tasks/abc303_a

题目大意：
当且仅当满足下列条件之一时，两个字符称为相似字符:
- X 和 y 是相同的字符。
- x 和 y 的一个是 1，另一个是 l。
- x 和 y 的一个是 0，另一个是 o。
两个长度为 N 的字符串 S 和 T 称为相似字符串，当且仅当:
- 对于所有 i(1≤i≤N)， S 的第 i 个字符与 T 的第 i 个字符是相似的字符。
给定由小写英文字母和数字组成的两个长度为 N 的字符串 S 和 T，判断 S 和 T 是否相似。

模拟。
======

Input 1
3
l0w
1ow
Output 1
Yes

Input 2
3
abc
arc
Output 2
No

Input 3
4
nok0
n0ko
Output 3
Yes
 */