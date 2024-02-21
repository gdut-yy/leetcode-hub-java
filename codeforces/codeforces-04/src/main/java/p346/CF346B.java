package p346;

import java.util.Arrays;
import java.util.Scanner;

public class CF346B {
    static char[] s, t, virus;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        t = scanner.next().toCharArray();
        virus = scanner.next().toCharArray();
        System.out.println(solve());
    }

    static int n, m, l;
    static int[] pi;
    static int[][][] dp;
    static int[][][] to;

    private static String solve() {
        n = s.length;
        m = t.length;
        l = virus.length;
        pi = prefix_function(virus);

        dp = new int[n + 1][m + 1][l];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        to = new int[n + 1][m + 1][l];

        int ans = f(0, 0, 0);
        if (ans <= 0) {
            return "0";
        }

        StringBuilder lcs = new StringBuilder();
        for (int i = 0, j = 0, k = 0; i < n && j < m; ) {
            int t = to[i][j][k];
            if (t == -2) {
                i++;
            } else if (t == -3) {
                j++;
            } else {
                lcs.append(s[i]);
                i++;
                j++;
                k = t;
            }
        }
        return lcs.toString();
    }

    static int f(int i, int j, int k) {
        if (i == n || j == m) return 0;
        if (dp[i][j][k] != -1) return dp[i][j][k];

        int res = -1;
        int r = f(i + 1, j, k);
        if (r > res) {
            res = r;
            to[i][j][k] = -2;
        }
        r = f(i, j + 1, k);
        if (r > res) {
            res = r;
            to[i][j][k] = -3;
        }
        if (s[i] == t[j]) {
            // kmp
            int j0 = k;
            while (j0 > 0 && s[i] != virus[j0]) j0 = pi[j0 - 1];
            if (s[i] == virus[j0]) j0++;
            if (j0 < l) {
                r = 1 + f(i + 1, j + 1, j0);
                if (r > res) {
                    res = r;
                    to[i][j][k] = j0;
                }
            }
        }
        return dp[i][j][k] = res;
    }

    static int[] prefix_function(char[] s) {
        int n = s.length;
        int[] pi = new int[n];
        for (int i = 1; i < n; i++) {
            int j = pi[i - 1];
            while (j > 0 && s[i] != s[j]) j = pi[j - 1];
            if (s[i] == s[j]) j++;
            pi[i] = j;
        }
        return pi;
    }
}
/*
B. Lucky Common Subsequence
https://codeforces.com/contest/346/problem/B

灵茶の试炼 2022-04-27
题目大意：
背景：最长公共子序列（LCS） https://leetcode-cn.com/problems/longest-common-subsequence/
给你三个字符串 s1、s2 和 t，长度均不超过 100，且仅包含大写字母。你需要求出 s1 和 s2 的 LCS，并且 t 不能是 LCS 的子串（或者说 LCS 不能包含 t）。如果没有 LCS 则输出 0。
请注意，子串一定是连续的，子序列可以是不连续的。

rating 2000
感觉记忆化会比较好写，用
f(i,j,k) 表示现在枚举到 s1[i] 和 s2[j]，且匹配了 t 中的 k 个字符的答案，若 s1[i] = s2[j] 则需要用 KMP 来更新 k，其余同经典 LCS 做法。
https://codeforces.com/contest/346/submission/122209017
======

input
AJKEQSLOBSROFGZ
OVGURWZLWVLUXTH
OZ
output
ORZ

input
AA
A
A
output
0
 */
