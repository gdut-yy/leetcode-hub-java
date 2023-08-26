package c132;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Arc132_c {
    static int n, d;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        d = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final int MOD = 998244353;

    private static String solve() {
        long[][] f = new long[n + 1][1 << (d * 2)];
        f[0][0] = 1;
        for (int i = 0; i < n; i++) {
            long[] fs = f[i];
            int v = a[i];
            for (int mask = 0; mask < 1 << (d * 2); mask++) {
                long res = fs[mask];
                for (int j = Math.max(i - d, 0); j <= Math.min(i + d, n - 1); j++) {
                    if ((v == -1 || j == v - 1) && (mask >> (j - i + d) & 1) == 0) {
                        int m = (mask | 1 << (j - i + d)) >> 1;
                        f[i + 1][m] = (f[i + 1][m] + res) % MOD;
                    }
                }
            }
        }
        long ans = Arrays.stream(f[n]).sum() % MOD;
        return String.valueOf(ans);
    }
}
/*
C - Almost Sorted
https://atcoder.jp/contests/arc132/tasks/arc132_c

灵茶の试炼 2022-12-09
题目大意：
输入 n(≤500) d(≤5) 和长为 n 的数组 a。
a 原本是一个 1~n 的排列 p，不过有些数字被替换成了 -1。
你需要还原 p，使得 abs(p[i]-i) ≤ d 对每个 i 都成立。
输出有多少个这样的 p，模 998244353。

https://atcoder.jp/contests/arc132/submissions/37103023
定义 f[i][mask] 表示前 i 个数字构成的集合为 mask 时的方案数。
枚举第 i 个数字要填的数字 j，转移给 f[i+1][mask|(1<<j)]。
初始 f[0][0]=1，答案为 sum(f[n])。
你以为 mask 有 2^n-1 那么大？
注意到第 i 个数字能填的范围是有限的，所以 mask 至多是 2^(2d)-1。
======

Input 1
4 2
3 -1 1 -1
Output 1
2

Input 2
5 1
2 3 4 5 -1
Output 2
0

Input 3
16 5
-1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
Output 3
794673086
 */