package p327;

import java.util.Scanner;

public class CF327A {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static final int INF = (int) 1e9;

    private static String solve() {
        int f0 = 0, f1 = -INF, f2 = -INF;
        for (int v : a) {
            f2 = Math.max(f2, f1) + v;
            f1 = Math.max(f1, f0) + 1 - v;
            f0 += v;
        }
        int ans = Math.max(f1, f2);
        return String.valueOf(ans);
    }
}
/*
A. Flipping Game
https://codeforces.com/contest/327/problem/A

灵茶の试炼 2025-02-24
题目大意：
输入 n(1≤n≤100) 和长为 n 的数组 a，只包含 0 和 1。
从 a 中选一个非空连续子数组，把其中的 0 变成 1，1 变成 0。
这个操作必须恰好执行一次。
输出操作后 a 中 1 的个数的最大值。

rating 1200
状态机 DP。
把数组分成三段：子数组左边，子数组中，子数组右边。
定义 f0,f1,f2 分别表示在前 i 个数中操作，当前位置在第一/二/三段时的最大 1 的个数。
（原始定义是 f[i][j]，这里把第一维度省略了。）
转移：
f2 = max(f2, f1) + a[i]
f1 = max(f1, f0) + 1 - a[i]
f0 += a[i]
初始值 f0=0，f1=f2=-inf
答案为 max(f1,f2)，最后一个数可以在子数组中，也可以在子数组右边。
代码 https://codeforces.com/problemset/submission/327/307098227
代码备份（洛谷）
======

Input
5
1 0 0 1 0
Output
4

Input
4
1 0 0 1
Output
4
 */
