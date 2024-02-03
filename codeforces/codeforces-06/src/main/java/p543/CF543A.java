package p543;

import java.util.Scanner;

public class CF543A {
    static int n, m, b, mod;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        b = scanner.nextInt();
        mod = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long[][] f = new long[m + 1][b + 1];
        f[0][0] = 1;
        for (int i = 0; i < n; i++) {
            int v = a[i];
            for (int j = 1; j <= m; j++) {
                for (int k = v; k <= b; k++) {
                    f[j][k] = (f[j][k] + f[j - 1][k - v]) % mod;
                }
            }
        }

        long ans = 0;
        for (long v : f[m]) {
            ans = (ans + v) % mod;
        }
        return String.valueOf(ans);
    }
}
/*
A. Writing Code
https://codeforces.com/contest/543/problem/A

灵茶の试炼 2022-09-14
题目大意：
输入 n (1≤n≤500) m (1≤m≤500) b (0≤b≤500) mod (1≤mod≤1e9+7) 和一个长为 n 的数组 a (0≤a[i]≤500)。
你接手了一个有很多祖传代码的老项目，该项目由 n 个程序员开发，目前有 m 行代码。
已知第 i 个程序员在一行代码中会产生 a[i] 个 bug。
你尚不知道每个程序员分别写了多少行代码，于是你思考：有多少种方案，能使项目的 bug 数量不超过 b 个？由于答案很大，你需要输出答案模 mod 的结果。
注意：两种方案不同，当且仅当某个程序员编写的行数不同。
可能有程序员一行代码都不写。

rating 1800
https://codeforces.com/contest/543/submission/172106263
转换成二维费用的完全背包：
f[i][j][k] 表示前 i 个程序员写 j 行代码产生 k 个 bug 的方案数。
用背包来理解，每个物品为 (1 行代码，a[i] 个 bug)
按照完全背包转移：f[i][j][k] = f[i-1][j][k] + f[i][j-1][k-a[i]]。
初始项：f[0][0][0] = 1。
答案：sum(f[n][m])。
代码实现时，第一个维度可以优化掉。
======

input
3 3 3 100
1 1 1
output
10

input
3 6 5 1000000007
1 2 3
output
0

input
3 5 6 11
1 2 1
output
0
 */
