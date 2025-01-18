package p1984;

import java.util.Arrays;
import java.util.Scanner;

public class CF1984C2 {
    static int n;
    static long[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            s = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                s[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static final int MOD = 998244353;

    private static String solve() {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            s[i] += s[i - 1];
            if (s[i] >= 0) {
                ans = ans * 2 % MOD;
            }
        }
        long minS = Arrays.stream(s).min().orElseThrow();
        if (minS >= 0) {
            return String.valueOf(ans);
        }
        long sumNeg = 0;
        long neg = 1;
        for (int i = n; i > 0; i--) {
            if (s[i] == minS) {
                sumNeg += neg;
            }
            if (s[i] < 0) {
                neg = neg * 2 % MOD;
            }
        }
        long res = sumNeg % MOD * ans % MOD;
        return String.valueOf(res);
    }
}
/*
C2. Magnitude (Hard Version)
https://codeforces.com/contest/1984/problem/C2

灵茶の试炼 2024-10-02
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤3e5。
每组数据输入 n(2≤n≤2e5) 和长为 n 的数组 a(-1e9≤a[i]≤1e9)。
初始化 s=0，然后从左到右遍历 a。
对于每个 a[i]，你有两个选项：
1. 把 s 更新为 s+a[i]。
2. 把 s 更新为 |s+a[i]|。
设 s 的最大值为 k。
输出使 s=k 的方案数，模 998244353。
两个选项得到的结果即使是一样的，也算不同的方案。

rating 1700
画出 a 数组的前缀和数组 s 的折线图。
观察（手玩）折线图可以发现，把 min(s) 取相反数，可以让最终的结果最大。
注意不能把 min(s) 前面的负数也取相反数，这不如单独把 min(s) 取相反数优。
对于方案数，初始化 ans=1，s 中的每个非负数都有不变/取绝对值（仍然不变）两种方案，把 ans *= 2。
对于 s 中的负数，只有 min(s) 可以取绝对值（相反数），并且一旦 min(s) 取相反数，后面的所有负数都变成了非负数，都有不变/取绝对值（仍然不变）两种方案。
所以算出 s 后，再倒着遍历一遍 s，同时统计负数对应的方案数 neg，遇到 min(s) 就累加 neg 到 sumNeg 中。
最后把答案乘以 sumNeg。
注意取模。
代码 https://codeforces.com/contest/1984/submission/282441890
======

Input
5
4
2 -5 3 -3
8
1 4 3 4 1 4 3 4
3
-1 -2 -3
4
-1000000000 1000000000 1000000000 1000000000
4
1 9 8 4
Output
12
256
1
8
16
 */
