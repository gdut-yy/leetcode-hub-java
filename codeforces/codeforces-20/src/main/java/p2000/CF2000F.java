package p2000;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

public class CF2000F {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static int n, k;

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            solve1();
        }
        out.flush();
    }

    static final int INF = (int) 1e9;
    static int w, v, j;
    static int[] f;

    static void dp(int dw, int dv) {
        w += dw;
        v += dv;
        f[j] = Math.min(f[j], f[Math.max(j - w, 0)] + v);
    }

    private static void solve() {
        f = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            f[i] = INF;
        }
        for (int i0 = 0; i0 < n; i0++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (a > b) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            for (j = k; j > 0; j--) {
                w = 0;
                v = 0;
                for (int i1 = 0; i1 < b - a; i1++) {
                    dp(1, a);
                }
                for (int i = a; i > 1; i--) {
                    dp(1, i);
                    dp(1, i - 1);
                }
                dp(2, 1);
            }
        }
        if (f[k] == INF) {
            f[k] = -1;
        }
        out.println(f[k]);
    }

    private static void solve1() {
        int[] f = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            f[i] = INF;
        }
        for (int i0 = 0; i0 < n; i0++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (a > b) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            for (int j = k; j > 0; j--) {
                AtomicInteger w = new AtomicInteger();
                AtomicInteger v = new AtomicInteger();
                int finalJ = j;
                BiConsumer<Integer, Integer> dp = (dw, dv) -> {
                    w.addAndGet(dw);
                    v.addAndGet(dv);
                    f[finalJ] = Math.min(f[finalJ], f[Math.max(finalJ - w.get(), 0)] + v.get());
                };
                for (int i1 = 0; i1 < b - a; i1++) {
                    dp.accept(1, a);
                }
                for (int i = a; i > 1; i--) {
                    dp.accept(1, i);
                    dp.accept(1, i - 1);
                }
                dp.accept(2, 1);
            }
        }
        if (f[k] == INF) {
            f[k] = -1;
        }
        out.println(f[k]);
    }
}
/*
F. Color Rows and Columns
https://codeforces.com/contest/2000/problem/F

灵茶の试炼 2025-06-05
题目大意：
输入 T(≤100) 表示 T 组数据。所有数据的 n 之和 ≤1e3。
每组数据输入 n(1≤n≤1e3) k(1≤k≤100) 和长为 n 个矩形的长和宽，范围 [1,100]。
每个大小为 a×b 的矩形，有 a×b 个单元格。
每次操作，你可以选择一个矩形的一个单元格，将其涂色。
如果一个矩形的一行被涂满颜色，你获得一分。
如果一个矩形的一列被涂满颜色，你获得一分。
至少获得 k 分，最少要执行多少次操作？
如果无法做到，输出 -1。

rating 1900
贪心 + 分组背包。
把 k 当作背包容量，操作次数当作物品体积，得分当作物品价值。
问题是一个「至少装满」型分组背包。为什么是「分组」？
每个矩形当成一组，组内有一些物品。比如涂色一行两列是一个物品（价值为 3），涂色三行五列是另一个物品（价值为 8）。
只涂一个单元格肯定不如涂满一行一列优。所以不用一个一个地枚举涂了多少个格子，而是枚举涂了多少条行列。
不失一般性，假设矩形的 a < b，即 a 行 b 列。
贪心地，一列一列地涂更好，每操作 a 次，得 1 分。
涂了 b-a 列后，问题变成一个 a 行 a 列的正方形。
涂了一行后，变成 a-1 行 a 列，然后涂一列，变成 a-1 行 a-1 列，这是一个规模更小的子问题，迭代解决。
注意：剩下 1 行 1 列的时候，操作 1 次可以得到 2 分。
代码 https://codeforces.com/contest/2000/submission/321183275
代码备份（洛谷）
======

Input
7
1 4
6 3
1 5
4 4
5 10
1 1
1 1
1 1
1 1
1 1
2 100
1 2
5 6
3 11
2 2
3 3
4 4
3 25
9 2
4 3
8 10
4 18
5 4
8 5
8 3
6 2
Output
12
14
5
-1
17
80
35
 */
