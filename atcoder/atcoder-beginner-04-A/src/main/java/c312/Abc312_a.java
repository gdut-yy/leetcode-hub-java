package c312;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc312_a {
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        s = scanner.next();
        System.out.println(solve());
    }

    private static String solve() {
        boolean ans = s.equals("ACE") || s.equals("BDF") || s.equals("CEG") || s.equals("DFA") ||
                s.equals("EGB") || s.equals("FAC") || s.equals("GBD");
        return ans ? "Yes" : "No";
    }
}
/*
A - Chord
https://atcoder.jp/contests/abc312/tasks/abc312_a

题目大意：
给定由大写英文字母组成的长度为 3 的字符串 S，如果 S 等于 ACE、BDF、CEG、DFA、EGB、FAC 和 GBD 中的一个，则打印 Yes;否则打印 No。

枚举
======

Input 1
ABC
Output 1
No

Input 2
FAC
Output 2
Yes

Input 3
XYX
Output 3
No
 */