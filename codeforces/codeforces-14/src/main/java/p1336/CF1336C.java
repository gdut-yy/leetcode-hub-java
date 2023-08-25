package p1336;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1336C {
    static char[] s, t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        s = scanner.next().toCharArray();
        t = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static final int MOD = 998244353;

    private static String solve() {
        int n = s.length, m = t.length;
        long[][] f = new long[n][n];

        for (int i = n - 1; i >= 0; i--) {
            if (i >= m || s[0] == t[i]) {
                f[i][i] = 2;
            }
            for (int j = i + 1; j < n; j++) {
                if (i >= m || s[j - i] == t[i]) {
                    f[i][j] = (f[i][j] + f[i + 1][j]) % MOD;
                }
                if (j >= m || s[j - i] == t[j]) {
                    f[i][j] = (f[i][j] + f[i][j - 1]) % MOD;
                }
            }
        }
        long ans = 0;
        for (int j = m - 1; j < n; j++) {
            ans = (ans + f[0][j]) % MOD;
        }
        return String.valueOf(ans);
    }
}
/*
C. Kaavi and Magic Spell
https://codeforces.com/contest/1336/problem/C

灵茶の试炼 2023-07-28
题目大意：
输入长度不超过 3000 的字符串 S，只包含小写字母。设 S 的长度为 n。
输入长度不超过 n 的字符串 T，只包含小写字母。
从一个空字符串 A 开始，执行如下操作不超过 n 次：
删除 S 的第一个字母，然后加到 A 的开头或者末尾。
问：要使 T 是 A 的前缀，有多少种不同的操作方式？模 998244353。
注：即使两个不同的操作方式得到了相同的字符串 A，也算不同的操作方式。

https://codeforces.com/problemset/submission/1336/216028319
先假设 s 和 t 一样长。
我们不知道 s 的第一个字母和谁匹配，但我们知道 s 的最后一个字母只能与 t[0] 或者 t[m-1] 匹配（加到开头或者末尾）。
假如与 t[0] 匹配，那么问题变成 s[:n-1] 与 t[1:] 匹配的方案数。这是一个规模更小的子问题。
这启发我们得到下面的区间 DP。
把 t 扩充成和 s 一样长，扩充的字母视作任意字符（一定可以与 s[i] 匹配）。
定义 f[i][j] 表示操作前缀 s[0]~s[j-i] 得到子串 t[i]~t[j] 的方案数。
那么答案就是 f[0][m-1]+f[0][m]+...+f[0][n-1]。
考虑 s[j-i] 与 t[i] 还是 t[j] 匹配，可以得到
f[i][j] = (i>=m || s[j-i]==t[i] ? f[i+1][j] : 0) + (j>=m || s[j-i]==t[j] ? f[i][j-1] : 0)
初始值 f[i][i] = (i>=m || s[0]==t[i] ? 2 : 0)
（也可以初始化 f[i+1][i] = 1）
======

input
abab
ba
output
12

input
defineintlonglong
signedmain
output
0

input
rotator
rotator
output
4

input
cacdcdbbbb
bdcaccdbbb
output
24
 */
