package c311;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc311_e {
    static int h, w, n;
    static int[][] hole;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        h = scanner.nextInt();
        w = scanner.nextInt();
        n = scanner.nextInt();
        hole = new int[h + 1][w + 1];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            hole[x][y] = 1;
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[][] f = new int[h + 1][w + 1];
        long ans = 0;
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                if (hole[i][j] == 1) {
                    continue;
                }
                f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j], f[i][j - 1])) + 1;
                ans += f[i][j];
            }
        }
        return String.valueOf(ans);
    }
}
/*
E - Defect-free Squares
https://atcoder.jp/contests/abc311/tasks/abc311_e

题目大意：
有一个 H 行 W 列的网格。设(i,j)表示网格顶部第 i 行和左侧第 j 列的正方形。
网格的每个方格是否有孔。一共有 N 个有洞的正方形:(a1, b1),(a2, b2),...,(an, bn)。
当正整数(i,j,n)的三元组满足以下条件时，左上角为(i,j)，右下角为(i+n−1,j+n−1)的方形区域称为无孔方形。
- i+n−1≤H。
- j+n−1≤W。
- 对于 0≤k≤n−1,0≤l≤n−1 的每一对非负整数(k,l)，平方(i+k,j+l)不空。
网格中有多少个无孔方块?

https://atcoder.jp/contests/abc311/editorial/6827
考虑用 DP(动态规划)来解决这个问题。定义
dp[i][j]:=(右下角为(i,j)的无孔正方形的最大边 n，如果不存在，则为 0)。
======

Input 1
2 3 1
2 3
Output 1
6

Input 2
3 2 6
1 1
1 2
2 1
2 2
3 1
3 2
Output 2
0

Input 3
1 1 0
Output 3
1

Input 4
3000 3000 0
Output 4
9004500500
 */