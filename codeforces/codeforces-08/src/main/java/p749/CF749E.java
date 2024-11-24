package p749;

import java.util.Scanner;

public class CF749E {
    static int n, v;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        long[][] t = new long[n + 1][2];
        long ans0 = 0;
        double ans1 = 0.0;
        for (int i = 1; i <= n; i++) {
            v = scanner.nextInt();
            v = n + 1 - v;
            long s = 0;
            for (int j = v; j > 0; j &= j - 1) {
                ans0 += t[j][0];
                s += t[j][1];
            }
            ans1 += s * (n + 1 - i);
            for (int j = v; j <= n; j += j & -j) {
                t[j][0]++;
                t[j][1] += i;
            }
        }
        double m = n;
        double ans = (double) ans0 - ans1 / m / (m + 1) * 2 + (m + 2) * (m - 1) / 24;
        System.out.printf("%.9f\n", ans);
    }
}
/*
E. Inversions After Shuffle
https://codeforces.com/contest/749/problem/E

灵茶の试炼 2024-03-29
题目大意：
输入 n(1≤n≤1e5) 和一个 1~n 的排列 a。
a 有 n*(n+1)/2 个非空连续子数组，从中（等概率的）随机选一个子数组 b。
设 b 的长度为 k，那么 b 一共有 k! 种不同的排列，从中（等概率的）随机选一个，替换掉 a 中的子数组 b。
输出替换后，a 的逆序对的期望值。
与答案的误差不能超过 1e-9。

rating 2400
提示：贡献法，考虑 (a[i], a[j]) 在/不在所选子数组内对答案的影响。
由于已经有很清楚的题解了，我就不重复造轮子了。
公式推导 https://www.luogu.com.cn/article/ev63p40w
https://codeforces.com/contest/749/submission/250572462
======

Input
3
2 3 1
Output
1.916666666666666666666666666667
 */
