package c279;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc279_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = scanner.next();
        String t = scanner.next();
        System.out.println(solve(s, t));
    }

    private static String solve(String s, String t) {
        return s.contains(t) ? "Yes" : "No";
    }
}
/*
B - LOOKUP
https://atcoder.jp/contests/abc279/tasks/abc279_b

题目大意：
给定由小写英文字母组成的字符串 S 和 T。确定 T 是否是 S 的(连续的)子串。
当且仅当对 X 执行以下操作 0 次或更多次可以得到 Y 时，我们称字符串 Y 是 X 的(连续)子字符串。
- 做以下其中一项。
  - 删除 X 中的第一个字符。
  - 删除 X 中的最后一个字符。
例如，tag 是 voltage 的(连续)子串，而 ace 不是 atcoder 的(连续)子串。

String#contains() 库函数
======

Input 1
voltage
tag
Output 1
Yes

Input 2
atcoder
ace
Output 2
No

Input 3
gorilla
gorillagorillagorilla
Output 3
No

Input 4
toyotasystems
toyotasystems
Output 4
Yes
 */