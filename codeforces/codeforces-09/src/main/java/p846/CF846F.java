package p846;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF846F {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static final int MX = (int) 1e6;

    private static void solve() {
        int n = scanner.nextInt();
        int[] pre = new int[MX + 1];
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            int v = scanner.nextInt();
            ans += (long) (i - pre[v]) * (n - i + 1);
            pre[v] = i;
        }
        double result = (2.0 * ans - n) / ((long) n * n);
        out.printf("%.6f", result);
    }
}
/*
F. Random Query
https://codeforces.com/contest/846/problem/F

灵茶の试炼 2025-09-10
题目大意：
输入 n(1≤n≤1e6) 和长为 n 的数组 a(1≤a[i]≤1e6)。下标从 1 开始。
从 [1,n] 中随机选择一个整数，记作 L。
从 [1,n] 中随机选择一个整数，记作 R。
L 和 R 互相独立。
如果 L>R，交换 L 和 R。
输出 a 的子数组 [L,R] 的不同元素个数的期望值。
与答案的误差必须 <= 1e-4。

rating 1800
本题的「期望」相当于所有子数组不同元素个数的平均值。这等于所有子数组的不同元素个数之和，除以选择 L 和 R 的方案数（n^2）。
如何计算所有子数组的不同元素个数之和？
两种做法：增量法 / 贡献法，见 LC2262. 字符串的总引力 我的题解。
本题 L 和 R 是独立选择的，(L,R) 和 (R,L) 我们要算两次，减去其中 (i,i) 重复算的一次，所以 a[i] 的正确贡献是
(i-last[a[i]]) * (n-i+1) * 2 - 1。
累加每个 a[i] 的贡献，即为所有子数组的不同元素个数之和。
除以 n^2，即为答案。
代码 https://codeforces.com/problemset/submission/846/335779225
代码（快读版） https://codeforces.com/problemset/submission/846/335779545
代码备份（上面打不开的同学看这个）
======

Input
2
1 2
Output
1.500000

Input
2
2 2
Output
1.000000
 */
