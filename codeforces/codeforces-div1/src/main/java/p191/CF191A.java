package p191;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF191A {
    static int n;
    static String[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = scanner.next();
        }
        System.out.println(solve());
    }

    private static final int INF = (int) 1e9;

    private static String solve() {
        int[][] f = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(f[i], -INF);
        }

        for (String s1 : s) {
            int m = s1.length();
            int v = s1.charAt(0) - 'a';
            int w = s1.charAt(m - 1) - 'a';
            for (int j = 0; j < 26; j++) {
                f[j][w] = Math.max(f[j][w], f[j][v] + m);
            }
            f[v][w] = Math.max(f[v][w], m);
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans = Math.max(ans, f[i][i]);
        }
        return String.valueOf(ans);
    }
}
/*
A. Dynasty Puzzles
https://codeforces.com/contest/191/problem/A

灵茶の试炼 2023-07-18
题目大意：
输入 n(1≤n≤5e5) 和长为 n 的字符串数组 a，只包含小写字母，每个 a[i] 的长度至多为 10。
你需要选择 a 的一个子序列 b，满足 b[i] 的最后一个字母等于 b[i+1] 的第一个字母，且 b[0] 的第一个字母等于 b[-1] 的最后一个字母。这里 b[-1] 表示最后一项。
输出 b 中字符串长度之和的最大值。
注：子序列不要求连续。

https://codeforces.com/problemset/submission/191/214043184
定义 f[i][j][k] 表示考虑 a 的前 i 个字符串，选出的子序列的第一个字母为 j，最后一个字母为 k。
转移方程的 i 从 1 开始。
设 v=a[i][0], w=a[i][-1]
f[i][j][w] = max(f[i][j][w], f[i-1][j][v] + len(a[i]))，表示 max(不选 a[i]，选 a[i])。
f[i][v][w] = max(f[i][v][w], len(a[i]))，表示把 a[i] 当作子序列的第一个字符串。
初始值 f[0][j][k] = -inf。
答案为 f[n][0][0],f[n][1][1],...,f[n][25][25] 的最大值。
代码实现时，第一个维度可以优化掉。
======

input
3
abc
ca
cba
output
6

input
4
vvp
vvp
dam
vvp
output
0

input
3
ab
c
def
output
1
 */
