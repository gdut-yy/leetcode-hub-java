package p1875;

import java.util.Scanner;

public class CF1875D {
    static int n;
    static int[] cnt;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            cnt = new int[n + 1];
            for (int i = 0; i < n; i++) {
                int v = scanner.nextInt();
                if (v < n) {
                    cnt[v]++;
                }
            }
            System.out.println(solve());
        }
    }

    static final int INF = (int) 1e9;

    private static String solve() {
        int mex = 0;
        while (cnt[mex] > 0) mex++;
        long ans = (long) mex * (cnt[0] - 1);
        int[] f = new int[mex];
        for (int i = 1; i < mex; i++) {
            f[i] = INF;
            for (int j = 0; j < i; j++) {
                int c = cnt[j];
                f[i] = Math.min(f[i], f[j] + i * c);
            }
            ans = Math.min(ans, f[i] + (long) mex * (cnt[i] - 1));
        }
        return String.valueOf(ans);
    }
}
/*
D. Jellyfish and Mex
https://codeforces.com/contest/1875/problem/D

灵茶の试炼 2024-04-10
题目大意：
输入 T(≤5000) 表示 T 组数据。所有数据的 n 之和 ≤5000。
每组数据输入 n(1≤n≤5000) 和长为 n 的数组 a(0≤a[i]≤1e9)。
每次操作，你可以删除一个 a[i]，代价为删除后的数组的 MEX，即不在数组中的最小非负整数。
输出清空数组 a（操作 n 次）的最小总代价。

rating 1600
DP。
先用 cnt 统计每个数的出现次数。
定义 f[i] 表示在已经去掉所有 i 的情况下，后续操作的代价之和。
用「枚举选哪个」思考，枚举下一步去掉所有的 j（j < i），则有
f[i] = min(f[j] + i * cnt[j])，j=0,1,2,...,i-1。
答案为 min(f[i] + mex * (cnt[i] - 1))，其中 mex 指数组 a 的 MEX，其中 i 的范围从 0 到 mex-1。
时间复杂度 O(mex^2)。
https://codeforces.com/contest/1875/submission/255617295
======

Input
4
8
5 2 1 0 3 0 4 0
2
1 2
5
1 0 2 114514 0
8
0 1 2 0 1 2 0 3
Output
3
0
2
7
 */
