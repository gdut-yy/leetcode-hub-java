package c248;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc248_c {
    static int n, m, k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        System.out.println(solve());
    }

    private static final int MOD = 998244353;

    private static String solve() {
        long[] f = new long[k + 1];
        f[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = k; j >= 0; j--) {
                f[j] = 0;
                for (int v = 1; v <= m && v <= j; v++) {
                    f[j] += f[j - v];
                }
                f[j] %= MOD;
            }
        }

        long ans = 0;
        for (long v : f) {
            ans = (ans + v) % MOD;
        }
        return String.valueOf(ans);
    }
}
/*
C - Dice Sum
https://atcoder.jp/contests/abc248/tasks/abc248_c

灵茶の试炼 2023-09-11
题目大意：
输入 n m(1≤n,m≤50) k(n≤k≤n*m)。
输出有多少个长为 n 的数组 a 满足 1≤a[i]≤m 且 sum(a)≤k。
模 998244353。
数据加强版 https://iai.sh.cn/problem/839

方法一：朴素 DP
f[i][j] 表示前 i 个数的元素和为 j 的方案数。i 从 1 开始。
f[i][j] = f[i-1][j-1] + f[i-1][j-2] + ... + f[i-1][max(j-m,0)]
初始值 f[0][0] = 1。
答案为 sum(f[n])。
https://atcoder.jp/contests/abc248/submissions/45034906
方法二：后缀和优化 DP
把转移方程中的和式用后缀和优化。
用后缀和的原因是可以一边计算状态一边计算后缀和，这样就不需要 f 数组了，只需要后缀和数组。
https://atcoder.jp/contests/abc248/submissions/45035045
======

Input 1
2 3 4
Output 1
6

Input 2
31 41 592
Output 2
798416518
 */