package c175;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Abc175_e {
    static int r, c, k;
    static int[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        r = scanner.nextInt();
        c = scanner.nextInt();
        k = scanner.nextInt();
        a = new int[r + 1][c + 1];
        for (int i = 0; i < k; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int v = scanner.nextInt();
            a[x][y] = v;
        }
        System.out.println(solve());
    }

    private static String solve() {
        long[][][] f = new long[r + 1][c + 1][4];
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                f[i][j][0] = Math.max(Math.max(f[i - 1][j][1], f[i - 1][j][2]), f[i - 1][j][3]);
                f[i][j][1] = Math.max(f[i][j - 1][1], f[i][j][0] + a[i][j]);
                f[i][j][2] = Math.max(f[i][j - 1][2], f[i][j - 1][1] + a[i][j]);
                f[i][j][3] = Math.max(f[i][j - 1][3], f[i][j - 1][2] + a[i][j]);
            }
        }
        long ans = Arrays.stream(f[r][c]).max().orElseThrow();
        return String.valueOf(ans);
    }
}
/*
E - Picking Goods
https://atcoder.jp/contests/abc175/tasks/abc175_e

灵茶の试炼 2022-11-18
题目大意：
输入 n m (1≤n,m≤3000) k(≤min(2e5,r*c))，表示一个 n*m 的网格，和网格中的 k 个物品。
接下来 k 行，每行三个数 x y v(≤1e9) 表示物品的行号、列号和价值（行列号从 1 开始）。
每个网格至多有一个物品。
你从 (1,1) 出发走到 (n,m)，每步只能向下或向右。
经过物品时，你可以选或不选，且每行至多可以选三个物品。
输出你选到的物品的价值和的最大值。

https://atcoder.jp/contests/abc175/submissions/36563526
定义 f[i][j][0/1/2/3] 表示从 (1,1) 走到 (i,j)，且当前行选了 0/1/2/3 个物品时的最大价值和。
转移方程如下：
f[i][j][0] = max(f[i-1][j])
f[i][j][1] = max(f[i][j-1][1], f[i][j][0]+a[i][j])
f[i][j][2] = max(f[i][j-1][2], f[i][j-1][1]+a[i][j])
f[i][j][3] = max(f[i][j-1][3], f[i][j-1][2]+a[i][j])
答案为 max(f[n][m])。
实际计算 max(f[][]) 时，f[][][0] 可以不计入。
======

Input 1
2 2 3
1 1 3
2 1 4
1 2 5
Output 1
8

Input 2
2 5 5
1 1 3
2 4 20
1 2 1
1 3 4
1 4 2
Output 2
29

Input 3
4 5 10
2 5 12
1 5 12
2 3 15
1 2 20
1 1 28
2 4 26
3 2 27
4 5 21
3 5 10
1 3 10
Output 3
142
 */