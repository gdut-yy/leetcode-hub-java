package p1197;

import java.util.Arrays;
import java.util.Scanner;

public class CF1197D {
    static int n, m, k;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final long INF = (long) 1e18;

    private static String solve() {
        long[] minS = new long[m];
        Arrays.fill(minS, INF);
        minS[0] = 0;

        long s = 0;
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            s += (long) a[i] * m - k;
            for (int d = 0; d < m; d++) {
                ans = Math.max(ans, s - minS[(i + d) % m] - (long) k * d);
            }
            minS[i % m] = Math.min(minS[i % m], s);
        }
        ans /= m;
        return String.valueOf(ans);
    }
}
/*
D. Yet Another Subarray Problem
https://codeforces.com/contest/1197/problem/D

灵茶の试炼 2022-09-12
题目大意：
输入 n (1≤n≤3e5) m (1≤m≤10) k (1≤k≤1e9) 和一个长为 n 的数组 a (-1e9≤a[i]≤1e9)。
定义数组 b 的价值为 sum(b) - k * ceil(len(b) / m)。
空数组的价值为 0。
输出 a 的所有子数组的最大价值。

rating 1900
https://codeforces.com/contest/1197/submission/126967539
提示 1-1：m=1 要怎么做？
式子变形。
提示 1-2：当 m=1 时，记 a'[i]=a[i]-k，则原问题可转换成最大子段和问题。
提示 2-1：用前缀和，枚举数组右端点。
提示 2-2：需要知道左侧前缀和的最小值。
提示 3-1：把式子乘上 m，最后算出的答案再除以 m。
思考 m=2 要怎么做。
提示 3-2：当 m=2 时，设区间为 [l,r)，如果 r-l 是偶数，那么 ceil 无影响，像提示 2 那样式子变形一下。
如果 r-l 是奇数，在 ceil 的影响下，r-l 等价于 r-l+1，由于 ceil 前面是减号，相当于需要额外减去 k。
提示 4：推广，把前缀和按照 下标%m 分组。
提示 5：记录每个组的最小值。
注意用 64 位整型。
======

input
7 3 10
2 -4 15 -3 4 8 3
output
7

input
5 2 1000
-13 -4 -9 -20 -11
output
0
 */
