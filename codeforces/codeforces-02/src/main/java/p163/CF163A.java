package p163;

import java.util.Scanner;

public class CF163A {
    static char[] s, t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        t = scanner.next().toCharArray();
        System.out.println(solve());
    }

    static final int MOD = (int) (1e9 + 7);

    private static String solve() {
        int n = s.length;
        int m = t.length;

        long[][] dp = new long[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (s[i] == t[j]) {
                    dp[i + 1][j + 1] = (dp[i + 1][j] + dp[i][j] + 1) % MOD;
                } else {
                    dp[i + 1][j + 1] = dp[i + 1][j];
                }
            }
        }

        long ans = 0;
        for (long[] dv : dp) {
            ans = (ans + dv[m]) % MOD;
        }
        return String.valueOf(ans);
    }
}
/*
A. Substring and Subsequence
https://codeforces.com/contest/163/problem/A

灵茶の试炼 2022-05-09
题目大意：
给你两个字符串 s 和 t，只包含小写字母，长度均不超过 5000，求所有 (x,y) pair 的个数，满足：
1. x 是 s 的子串
2. y 是 t 的子序列
3. x 等于 y
请注意，在计算 (x,y) pair 时，重复的子串或子序列应视作多个不同的 (x,y) pair。例如：
s = "aa", t = "a"，那么 (s[:1],t) 和 (s[1:], t) 都是合法答案，因此答案为 2。
由于答案可能很大，输出答案对 1e9+7 取模后的结果。

rating 1700
https://codeforces.com/contest/163/submission/117005013
定义 dp[i][j] 表示考虑 s 的前 i 个字符，和 t 的前 j 的字符，并且子串 x 一定以 s[i-1] 结尾的答案。
那么分类讨论：
如果 s[i] != t[j]：t[j] 无法选取，则 dp[i+1][j+1] = dp[i+1][j]
如果 s[i] == t[j]：t[j] 可选可不选，则 dp[i+1][j+1] = dp[i+1][j] + dp[i][j] + 1
不选就是 dp[i+1][j]
选就是把 s[i] 和 t[j] 拼到 dp[i][j] 的那些 pair 的末尾
+1 是把 s[i] 和 t[j] 单独算作一个 (x,y) pair
最后答案为 sum(dp[i][len(t)])
记得取模。
======

input
aa
aa
output
5

input
codeforces
forceofcode
output
60
 */
