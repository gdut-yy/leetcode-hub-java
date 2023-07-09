package c306;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc306_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        String s = scanner.next();
        System.out.println(solve(n, s));
    }

    private static String solve(int n, String s) {
        char[] cs = new char[n * 2];
        for (int i = 0; i < n; i++) {
            cs[i * 2] = cs[i * 2 + 1] = s.charAt(i);
        }
        return new String(cs);
    }
}
/*
A - Echo
https://atcoder.jp/contests/abc306/tasks/abc306_a

题目大意：
给定一个长度为 N 的字符串 S，由小写英文字母组成。
我们用 s1 表示 S 的第 i 个字符。
打印由 s1, s1, s2, s2,..., sn, sn 按此顺序连接得到的长度为 2N 的字符串。
例如，如果 S 是 beginner，则打印 bbeeggiinnnneerr。

模拟
======

Input 1
8
beginner
Output 1
bbeeggiinnnneerr

Input 2
3
aaa
Output 2
aaaaaa
 */