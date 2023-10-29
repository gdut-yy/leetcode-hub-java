package c323;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc323_a {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        for (int i = 0; i < s.length; i++) {
            if (i % 2 == 1 && s[i] != '0') {
                return "No";
            }
        }
        return "Yes";
    }
}
/*
A - Weak Beats
https://atcoder.jp/contests/abc323/tasks/abc323_a

题目大意：
给定长度为 16 的字符串 S，由 0 和 1 组成。
如果 S 的第 i 个字符从 2 到 16 的每一个偶数 i 都是 0，打印 Yes;否则，打印 No。

模拟
======

Input 1
1001000000001010
Output 1
No

Input 2
1010100000101000
Output 2
Yes

Input 3
1111111111111111
Output 3
No
 */
