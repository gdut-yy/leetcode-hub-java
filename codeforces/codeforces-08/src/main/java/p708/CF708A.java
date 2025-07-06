package p708;

import java.util.Scanner;

public class CF708A {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        int n = s.length;
        // 状态机 flag = 0,1,2
        int flag = 0;
        for (int i = 0; i < n; i++) {
            if (flag == 0) {
                if (s[i] > 'a') {
                    s[i]--;
                    flag = 1;
                }
            } else if (flag == 1) {
                if (s[i] > 'a') {
                    s[i]--;
                } else {
                    flag = 2;
                }
            }
        }
        // 恰好一次
        if (flag == 0) {
            s[n - 1] = 'z';
        }
        return new String(s);
    }
}
/*
A. Letters Cyclic Shift
https://codeforces.com/contest/708/problem/A

灵茶の试炼 2025-05-26
题目大意：
输入长度 ≤1e5 的字符串 s，只包含小写英文字母。
执行如下操作恰好一次：
选择 s 的一个非空子串，把子串中的字母都减一。特别地，a 减一得到 z。
输出操作后字典序最小的 s。

rating 1200
同: 2734. 执行子串操作后的字典序最小字符串
https://leetcode.cn/problems/lexicographically-smallest-string-after-substring-operation/
======

Input
codeforces
Output
bncdenqbdr

Input
abacaba
Output
aaacaba
 */
