package p1800;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1800A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            String s = scanner.next();
            System.out.println(solve(n, s));
        }
    }

    private static String solve(int n, String s) {
        boolean[] meow = new boolean[4];
        char[] cs = s.toLowerCase().toCharArray();

        for (int i = 0; i < n; i++) {
            if (cs[i] == 'm') {
                if (!meow[1] && !meow[2] && !meow[3]) {
                    meow[0] = true;
                } else {
                    return "NO";
                }
            } else if (cs[i] == 'e') {
                if (meow[0] && !meow[2] && !meow[3]) {
                    meow[1] = true;
                } else {
                    return "NO";
                }
            } else if (cs[i] == 'o') {
                if (meow[0] && meow[1] && !meow[3]) {
                    meow[2] = true;
                } else {
                    return "NO";
                }
            } else if (cs[i] == 'w') {
                if (meow[0] && meow[1] && meow[2]) {
                    meow[3] = true;
                } else {
                    return "NO";
                }
            } else {
                return "NO";
            }
        }
        return meow[0] && meow[1] && meow[2] && meow[3] && cs[n - 1] == 'w' ? "YES" : "NO";
    }
}
/*
Codeforces Round 855 (Div. 3)
A. Is It a Cat?
https://codeforces.com/contest/1800/problem/A

题目大意：
给定字符串 s。判断 s 是否是一个 'm'， 'e'， 'o' 和 'w' 排列。

状态机
======

input
7
4
meOw
14
mMmeoOoWWWwwwW
3
mew
7
MmeEeUw
4
MEOW
6
MmyaVW
5
meowA

output
YES
YES
NO
NO
YES
NO
NO
 */