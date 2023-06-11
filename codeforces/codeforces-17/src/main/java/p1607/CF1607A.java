package p1607;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1607A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            String keyboard = scanner.next();
            String s = scanner.next();
            System.out.println(solve(keyboard, s));
        }
    }

    private static String solve(String keyboard, String s) {
        // 长度 26 数组模拟 HashMap
        int[] dict = new int[26];
        for (int i = 0; i < keyboard.length(); i++) {
            dict[keyboard.charAt(i) - 'a'] = i;
        }
        int res = 0;
        int preIdx = dict[s.charAt(0) - 'a'];
        for (int i = 1; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            res += Math.abs(dict[idx] - preIdx);
            preIdx = dict[idx];
        }
        return String.valueOf(res);
    }
}
/*
Codeforces Round #753 (Div. 3)
A. Linear Keyboard
https://codeforces.com/contest/1607/problem/A

题目大意：
给定字符串 keyboard 和 word，keyboard 代表一个键盘字母顺序，求使用该键盘输出 word 经过的距离。

模拟即可。
======

input
5
abcdefghijklmnopqrstuvwxyz
hello
abcdefghijklmnopqrstuvwxyz
i
abcdefghijklmnopqrstuvwxyz
codeforces
qwertyuiopasdfghjklzxcvbnm
qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq
qwertyuiopasdfghjklzxcvbnm
abacaba

output
13
0
68
0
74
 */