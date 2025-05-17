package p1492;

import java.util.Scanner;

public class CF1492C {
    static int n, m;
    static char[] s, t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        s = scanner.next().toCharArray();
        t = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        int[] L = new int[m];
        int k = 0;
        for (int i = 0; i < t.length; i++) {
            char b = t[i];
            while (s[k] != b) {
                k++;
            }
            L[i] = k;
            k++;
        }

        int[] R = new int[m];
        k = n - 1;
        for (int i = m - 1; i >= 0; i--) {
            char b = t[i];
            while (s[k] != b) {
                k--;
            }
            R[i] = k;
            k--;
        }

        int ans = 0;
        for (int i = 1; i < m; i++) {
            ans = max(ans, L[i] - L[i - 1], R[i] - R[i - 1], R[i] - L[i - 1]);
        }
        return String.valueOf(ans);
    }

    static int max(int... values) {
        int maxValue = Integer.MIN_VALUE;
        for (int i : values) {
            if (i > maxValue) {
                maxValue = i;
            }
        }
        return maxValue;
    }
}
/*
C. Maximum width
https://codeforces.com/contest/1492/problem/C

灵茶の试炼 2025-04-01
题目大意：
输入 n m(2≤m≤n≤2e5)，长为 n 的字符串 s，长为 m 的字符串 t，只包含小写英文字母。
保证 t 是 s 的子序列。
设 s 中的一个等于 t 的子序列的下标为 p1,p2,...,pm。
定义其宽度为 max(p[i+1] - p[i])。
输出 s 中所有等于 t 的子序列中的最大宽度。
变形：求最小宽度。

rating 1500
前后缀分解。
定义 L[i] 表示满足子序列 s[j] = t[i] 的最小 j。
定义 R[i] 表示满足子序列 s[j] = t[i] 的最大 j。
那么答案为 L[i]-L[i-1], R[i]-R[i-1], R[i]-L[i-1] 中的最大值。
代码 https://codeforces.com/contest/1492/submission/312294599
代码备份（洛谷）
变形题提示：最小化最大值 => 二分答案。
======

Input
5 3
abbbc
abc
Output
3

Input
5 2
aaaaa
aa
Output
4

Input
5 5
abcdf
abcdf
Output
1

Input
2 2
ab
ab
Output
1
 */