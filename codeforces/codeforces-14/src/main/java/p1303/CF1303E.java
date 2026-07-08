package p1303;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CF1303E {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        String s = scanner.next();
        String t = scanner.next();
        int n = t.length();
        int m = s.length();
        for (int mid = 0; mid <= n; mid++) {
            String a = t.substring(0, mid);
            String b = t.substring(mid);
            int[] f = new int[n + 1];
            for (int j = 1; j <= mid; j++) {
                f[j] = (int) -1e9;
            }
            for (int i = 0; i < m; i++) {
                char x = s.charAt(i);
                for (int j = mid; j >= 0; j--) {
                    int k = f[j];
                    int res = k;
                    if (0 <= k && k < b.length() && x == b.charAt(k)) {
                        res = k + 1;
                    }
                    if (j > 0 && x == a.charAt(j - 1)) {
                        res = Math.max(res, f[j - 1]);
                    }
                    f[j] = res;
                }
            }
            if (f[mid] == b.length()) {
                out.println("YES");
                return;
            }
        }
        out.println("NO");
    }

    // Time limit exceeded on test 6
    static class TLE {
        private static void solve() {
            s = scanner.next();
            t = scanner.next();
            int n = s.length();
            for (int mid = 0; mid <= t.length(); mid++) {
                int lenA = mid;
                int lenB = t.length() - mid;
                dp = new int[n][lenA + 1];
                for (int i = 0; i < n; i++) Arrays.fill(dp[i], -INF);
                if (dfs(n - 1, lenA, lenA, lenB) == lenB) {
                    out.println("YES");
                    return;
                }
            }
            out.println("NO");
        }

        static String s, t;
        static int[][] dp;
        static final int INF = (int) 1e9;

        static int dfs(int i, int j, int lenA, int lenB) {
            if (i < 0) {
                return j == 0 ? 0 : -INF;
            }
            if (dp[i][j] != -INF) return dp[i][j];
            int res = dfs(i - 1, j, lenA, lenB);
            if (j > 0 && s.charAt(i) == t.charAt(j - 1)) {
                res = Math.max(res, dfs(i - 1, j - 1, lenA, lenB));
            }
            int k = dfs(i - 1, j, lenA, lenB);
            if (0 <= k && k < lenB && s.charAt(i) == t.charAt(lenA + k)) {
                res = Math.max(res, k + 1);
            }
            dp[i][j] = res;
            return res;
        }
    }
}
/*
E. Erase Subsequences
https://codeforces.com/contest/1303/problem/E

灵茶の试炼 2026-05-08
题目大意：
输入 T(≤100) 表示 T 组数据。所有数据的 s 的长度之和 ≤400。
每组数据输入长度 ≤400 的字符串 s，以及长度 ≤|s| 的字符串 t，只包含小写英文字母。
初始化字符串 p = ""。
你可以执行如下操作至多两次：
从 s 中取出一个子序列，添加到 p 的末尾。
「取出」的意思是从 s 中删除这个子序列。
能否把 p 变成 t？输出 YES 或 NO。
注：子序列不一定连续。

rating 2200
设 t = a + b，问题等价于：
a 和 b 是不是 s 中的两个不相交的子序列？
由于 |t| 很小，我们可以枚举 a 的长度为 mid，那么 b 的长度为 |t|-mid。
如果定义 f[i][j][k] 表示 s 的前 i 个（i 从 1 开始）字母【能否】匹配 a 的前 j 个字母以及 b 的前 k 个字母，总体时间复杂度为 O(|s|^4)，太慢了，如何优化？
对于 bool 型 DP，一个技巧是把 bool 改成 int，把其中一个维度移到状态值中。
定义 f[i+1][j] 表示 s 的 [0,i] 匹配 a 的前 j 个字母（下标 0 到 j-1）时，最多可以匹配 b 的前 f[i][j] 个字母。
b 前面匹配得越多，后面越容易完成整个 b 的匹配。
分类讨论：
不匹配：f[i+1][j] = f[i][j]。
匹配 a：如果 j > 0 且 s[i] == a[j-1]，那么 f[i+1][j] = f[i][j-1]。注意 j=0 表示当前计算的状态是匹配 a 的 0 个字母，不属于这个情况。
匹配 b：设 k = f[i][j]，如果 0 <= k < |b| 且 s[i] == b[k]，那么 f[i+1][j] = k + 1。
三种情况取最大值。
初始值：f[0][0] = 0, 其余 f[0][j] = -inf。
如果最终 f[|s|][mid] == |t|-mid，那么输出 YES。
写法一：记忆化搜索 https://codeforces.com/contest/1303/submission/373865187
写法二：1:1 翻译成递推 https://codeforces.com/contest/1303/submission/373865360
写法三：空间优化（类似 0-1 背包） https://codeforces.com/contest/1303/submission/373865425
代码备份（上面打不开的同学看这个）
======

Input
4
ababcd
abcba
a
b
defi
fed
xyz
x
Output
YES
NO
NO
YES
 */
