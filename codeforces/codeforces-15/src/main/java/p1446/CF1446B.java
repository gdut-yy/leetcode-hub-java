package p1446;

import java.util.Scanner;

public class CF1446B {
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
        int ans = 0;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (s[i] == t[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 2;
                    ans = Math.max(ans, dp[i + 1][j + 1]);
                } else {
                    dp[i + 1][j + 1] = Math.max(Math.max(dp[i][j + 1], dp[i + 1][j]) - 1, 0);
                }
            }
        }
        return String.valueOf(ans);
    }
}
/*
B. Catching Cheaters
https://codeforces.com/contest/1446/problem/B

灵茶の试炼 2022-06-21
题目大意：
背景：最长公共子序列（LCS） https://leetcode-cn.com/problems/longest-common-subsequence/
给你 n,m(<=5000)，长为 n 的字符串 s，长为 m 的字符串 t。定义 LCS(x,y) 表示字符串 x 和 y 的最长公共子序列。
请你选择 s 的子串 s'，t 的子串 t'，最大化 4*len(LCS(s',t'))-len(s')-len(t') 的值。
输出这个最大值。
输入的字符串只包含小写字母。
子串是连续的，子序列不要求连续。

rating 1800
https://codeforces.com/contest/1446/submission/161363517
考虑（子串中的）每个字母的贡献。
如果它作为 LCS 的一部分，那么贡献是 2，否则贡献是 -1。
（对比一下 LCS 那道题，贡献分别是 1 或 0）
所以在 LCS DP 的基础上修改一下贡献即可。
答案为 dp 数组的最大值。
======

input
4 5
abba
babab
output
5

input
8 10
bbbbabab
bbbabaaaaa
output
12

input
7 7
uiibwws
qhtkxcn
output
0
 */
