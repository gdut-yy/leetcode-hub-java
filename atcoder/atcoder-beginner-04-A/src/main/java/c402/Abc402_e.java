package c402;

import java.io.PrintWriter;
import java.util.Scanner;

public class Abc402_e {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int tot = scanner.nextInt();
        double[] s = new double[n];
        int[] c = new int[n];
        double[] p = new double[n];
        for (int i = 0; i < n; i++) {
            s[i] = scanner.nextDouble();
            c[i] = scanner.nextInt();
            p[i] = scanner.nextDouble() / 100.0;
        }
        double[][] f = new double[tot + 1][1 << n];
        for (int i = 0; i <= tot; i++) {
            for (int mask = 0; mask < 1 << n; mask++) {
                for (int sub = mask; sub > 0; sub &= sub - 1) {
                    int j = Integer.numberOfTrailingZeros(sub);
                    if (c[j] <= i) {
                        f[i][mask] = Math.max(f[i][mask], p[j] * (f[i - c[j]][mask ^ (1 << j)] + s[j]) + (1 - p[j]) * f[i - c[j]][mask]);
                    }
                }
            }
        }
        out.printf("%.6f", f[tot][(1 << n) - 1]);
    }
}
/*
E - Payment Required
https://atcoder.jp/contests/abc402/tasks/abc402_e

灵茶の试炼 2026-05-20
题目大意：
输入 n(1≤n≤8) 和 x(1≤x≤5000)。
然后输入 n 道题目的数据，每行三个数：题目分数 s(1≤s≤2718)，每次提交需要支付的费用 c(1≤c≤x)，做出这道题的概率 p(1≤p≤100)。
有 n 道题，你有 x 元钱。
每次，你可以选择一道没有 AC 的题提交（前提是 c <= 剩余的钱）。有 p% 的概率 AC，得到 s 分。
每次提交能否 AC 与之前的提交结果互相独立。
你想最大化总得分的期望值。
输出这个期望值。与答案的绝对或相对误差不能超过 1e-6。

rating
n 很小，考虑状压 DP。
定义 f[i][mask] 表示剩余 i 元钱，剩余题目集合为 mask 时的最大期望得分。
枚举 mask 中的题目 j，要求 c[j] <= i。
做出来的期望得分：p[j]/100 * (f[i-c[j]][mask^(1<<j)] + s[j])。
没做出来的期望得分：(1-p[j]/100) * f[i-c[j]][mask]。
二者相加，更新 f[i][mask] 的最大值。
答案为 f[x][(1<<n)-1]。
代码 https://atcoder.jp/contests/abc402/submissions/75795397
======

Input 1
3 2
100 1 50
200 1 20
1000 1 1
Output 1
95

Input 2
2 7
100 3 50
100 2 50
Output 2
125

Input 3
5 32
500 9 57
300 4 8
300 3 32
300 7 99
100 8 69
Output 3
953.976967020096

Input 4
7 78
100 1 100
200 2 90
300 3 80
400 4 60
450 5 50
525 6 30
650 7 1
Output 4
1976.2441416041121021
 */
