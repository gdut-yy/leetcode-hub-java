package p1954;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CF1954D {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) V2.solve();
        out.flush();
    }

    private static final int MOD = 998244353;

    static class V1 {
        private static void solve() {
            int n = scanner.nextInt();
            int[] a = new int[n];
            int s = 0;
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
                s += a[i];
            }
            Arrays.sort(a);
            long[] f = new long[s + 1];
            f[0] = 1;
            int sum = 0;
            long ans = 0;
            for (int v : a) {
                for (int j = 0; j <= sum; j++) {
                    ans = (ans + Math.max((j + v + 1) / 2, v) * f[j]) % MOD;
                }
                sum += v;
                for (int j = sum; j >= v; j--) {
                    f[j] = (f[j] + f[j - v]) % MOD;
                }
            }
            out.print(ans);
        }
    }

    static class V2 {
        private static void solve() {
            int n = scanner.nextInt();
            int[] a = new int[n];
            int s = 0;
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
                s += a[i];
            }
            Arrays.sort(a);

            long[] f = new long[s + 1];
            f[0] = 1;
            s = 0;
            long ans = 0;
            for (int v : a) {
                long sumF = 0;
                for (int j = 0; j < v; j++) {
                    sumF += f[j];
                }
                ans += sumF % MOD * v % MOD;
                for (int j = v; j <= s; j++) {
                    ans += (j + v + 1) / 2 * f[j] % MOD;
                }
                ans %= MOD;
                s += v;
                for (int j = s; j >= v; j--) {
                    f[j] = (f[j] + f[j - v]) % MOD;
                }
            }
            out.print(ans);
        }
    }
}
/*
D. Colored Balls
https://codeforces.com/contest/1954/problem/D

灵茶の试炼 2025-12-24
题目大意：
输入 n(1≤n≤5000) 和长为 n 的数组 a(1≤a[i]≤5000)，保证 sum(a)≤5000。
a[i] 表示颜色为 i 的小球的个数。
定义 f(b) 表示一共有 sum(b) 个小球，每次操作可以移除一个球，或者两个颜色不同的球，问：至少要操作多少次才能把所有球移除完。
例如 f([3,1,7]) = 7。
a 有 2^n 个子序列 b，每个独立计算 f(b)。
输出这 2^n 个 f(b) 之和，模 998244353。

rating 1800
请先完成昨天的题目。
考虑枚举 max(b)。
换句话说，把所有子序列按照子序列的最大值分类。
从小到大排序 a，枚举子序列的最大值为 a[i]。
对于在 a[i] 左边的子序列，枚举其元素和为 s=0,1,2,... 设这样的子序列有 f[s] 个。
在这 f[s] 个子序列的末尾都添加 a[i]，每个子序列对答案的贡献是 max(ceil((s+a[i])/2), a[i])，累加到答案中。
f[s] 是标准的 0-1 背包（空间优化）。
写法一 https://codeforces.com/contest/1954/submission/353915916
写法二（常数优化） https://codeforces.com/contest/1954/submission/353915791
代码备份（上面打不开的同学看这个）
======

Input
3
1 1 2
Output
11

Input
1
5
Output
5

Input
4
1 3 3 7
Output
76
 */
