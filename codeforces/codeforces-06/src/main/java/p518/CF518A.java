package p518;

import java.util.Arrays;
import java.util.Scanner;

public class CF518A {
    static char[] s, t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        t = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        int n = s.length;
        for (int i = n - 1; ; i--) {
            if (s[i] < 'z') {
                s[i]++;
                break;
            }
            s[i] = 'a';
        }
        if (Arrays.equals(s, t)) {
            return "No such string";
        }
        return new String(s);
    }
}
/*
A. Vitaly and Strings
https://codeforces.com/contest/518/problem/A

灵茶の试炼 2022-06-30
题目大意：
给你两个长度相同（不超过 100），均由小写字母组成的字符串 s 和 t，且 s 的字典序小于 t。
请你输出字典序在 s 和 t 之间的，长度相同且由小写字母组成的任意一个字符串。
若不存在这样的字符串，输出 "No such string"。

rating 1600
https://codeforces.com/contest/518/submission/96459205
把 s 看成一个数字，将其 +1。
做法：倒着遍历 s，把末尾的 z 都改成 a，遍历到的第一个非 z 字母加一。
输出修改后的 s。如果这样做和 t 相同，就输出 No such string。
======

input
a
c
output
b

input
aaa
zzz
output
kkk

input
abcdefg
abcdefh
output
No such string
 */