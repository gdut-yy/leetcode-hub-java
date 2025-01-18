package p1974;

import java.util.Arrays;
import java.util.Scanner;

public class CF1974E {
    static Scanner scanner = new Scanner(System.in);
    static int n, x;

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            x = scanner.nextInt();

            System.out.println(solve());
        }
    }

    static final long INF = (long) 1e18;
    static final int mx = (int) (5e4 + 1);
    static long[] f = new long[mx];

    private static String solve() {
        Arrays.fill(f, INF);
        f[0] = 0;

        int s = 0;
        for (int i = 0; i < n; i++) {
            int c = scanner.nextInt();
            int h = scanner.nextInt();
            s += h;
            for (int j = s; j >= h; j--) {
                if (f[j - h] <= (long) i * x - c) {
                    f[j] = Math.min(f[j], f[j - h] + c);
                }
            }
        }
        int ans = 0;
        for (int i = s; i >= 0; i--) {
            if (f[i] < INF) {
                ans = i;
                break;
            }
        }
        return String.valueOf(ans);
    }
}
/*
E. Money Buys Happiness
https://codeforces.com/contest/1974/problem/E

灵茶の试炼 2024-10-09
题目大意：
输入 T(≤1e3) 表示 T 组数据。所有数据的 hi 之和 ≤1e5。
每组数据输入 n(1≤n≤50) x(1≤x≤1e8) 表示有 n 个月，每个月的月底你会得到 x 元钱。
然后输入 n 行，每行两个数 ci(0≤ci≤1e8) 和 hi(1≤hi≤1e3)，表示你可以在第 i 月的月初支付 ci 元钱，可以得到 hi 个单位的幸福。
注意第 1 月你没有钱。
注意 ci 可以等于 0，表示你可以免费获得 hi 的幸福。
输出你能得到的幸福总量的最大值。

rating 1800
数据范围暗示了，本题是以【幸福之和】为状态的 0-1 背包。
定义 f[i][j] 表示前 i 个月，获得幸福之和为 j，最少要花多少钱。
如果无法得到 j，那么 f[i][j] = inf。
如果钱够，即 f[i-1][j-h]+c <= i*x（目前收入之和，i 从 0 开始），那么考虑选或不选，有
f[i][j] = min(f[i-1][j], f[i-1][j-h]+c)
如果钱不够，则 f[i][j] = f[i-1][j]。
初始值 f[0][0] = 0，其余为 inf。
答案为最大的满足 f[n][j] < inf 的 j。
代码实现时，第一个维度可以去掉。
代码 https://codeforces.com/contest/1974/submission/284242887
======

Input
7
1 10
1 5
2 80
0 10
200 100
3 100
70 100
100 200
150 150
5 8
3 1
5 3
3 4
1 5
5 3
2 5
1 5
2 1
5 3
2 5
2 4
4 1
5 1
3 4
5 2
2 1
1 2
3 5
3 2
3 2
Output
0
10
200
15
1
9
9
 */
