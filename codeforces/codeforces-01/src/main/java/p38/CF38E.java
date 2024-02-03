package p38;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CF38E {
    static int n;
    static int[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = scanner.nextInt();
            a[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(a, Comparator.comparingInt(o -> o[0]));

        long[][] f = new long[n][n];
        f[0][0] = a[0][1];
        for (int i = 1; i < n; i++) {
            long mn = f[i - 1][0];
            for (int j = 0; j < i; j++) {
                f[i][j] = f[i - 1][j] + (a[i][0] - a[j][0]);
                mn = Math.min(mn, f[i - 1][j]);
            }
            f[i][i] = mn + a[i][1];
        }

        long ans = Long.MAX_VALUE;
        for (long v : f[n - 1]) {
            ans = Math.min(ans, v);
        }
        return String.valueOf(ans);
    }
}
/*
E. Let's Go Rolling!
https://codeforces.com/contest/38/problem/E

灵茶の试炼 2022-10-10
题目大意：
输入 n(≤3000)，表示在一维数轴上有 n 颗大小忽略不计的弹珠。
然后输入 n 对数字，每对数字表示这颗弹珠在数轴上的位置 xi，以及把这颗弹珠固定在 xi 上的花费 ci，数据范围均在 [-1e9,1e9] 之间，且 xi 互不相同。注意 ci 可以为负。
选择若干弹珠固定后，所有未固定的弹珠向左滚动，直到碰到固定住的弹珠。
总花费 = 固定弹珠的花费之和 + 所有未固定的弹珠的滚动距离之和。
输出总花费的最小值。
注：根据题意，最左边的弹珠一定要固定。

rating 1800
https://codeforces.com/contest/38/submission/175293285
https://codeforces.com/contest/38/submission/175293327 滚动数组
按照坐标排序。
定义 f[i][j] 表示考虑前 i 颗弹珠，且最后一个固定的弹珠是 j 时的最小花费。
考虑第 i 颗弹珠是否固定，则有：
f[i][j] = f[i-1][j] + x[i] - x[j], j < i
f[i][i] = min(f[i-1][j]) + c[i]
初始 f[0][0] = c[0]，
答案 min(f[n-1])。
代码实现时，第一个维度可以去掉。
======

input
3
2 3
3 4
1 2
output
5

input
4
1 7
3 1
5 10
6 1
output
11
 */
