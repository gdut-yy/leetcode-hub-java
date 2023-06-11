package c305;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc305_c {
    static int h, w;
    static char[][] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        h = scanner.nextInt();
        w = scanner.nextInt();
        s = new char[h][w];
        for (int i = 0; i < h; i++) {
            s[i] = scanner.next().toCharArray();
        }
        System.out.println(solve());
    }

    private static String solve() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (s[i][j] == '.') {
                    if (cnt(i, j) >= 2) {
                        return (i + 1) + " " + (j + 1);
                    }
                }
            }
        }
        return "-1";
    }

    private static int cnt(int x, int y) {
        int ans = 0;
        if (x - 1 >= 0 && s[x - 1][y] == '#') ans++;
        if (x + 1 < h && s[x + 1][y] == '#') ans++;
        if (y - 1 >= 0 && s[x][y - 1] == '#') ans++;
        if (y + 1 < w && s[x][y + 1] == '#') ans++;
        return ans;
    }
}
/*
C - Snuke the Cookie Picker
https://atcoder.jp/contests/abc305/tasks/abc305_c

题目大意：
有一个 H 行 W 列的网格。令(i,j)表示从上到下第 i 行和从左到第 j 列的正方形。最初，在一个高度和宽度至少为 2 个正方形的矩形内，每个正方形上都有一块饼干，其他正方形上没有饼干。形式上，只有一个四元组的整数(a,b,c,d)满足以下所有条件。
- 1≤a<b≤H
- 1≤c<d≤W
- 每个方格(i,j)上有一块饼干，使得 a≤i≤b,c≤j≤d，其他方格上没有饼干。
然而，Snuke 拿走并吃掉了网格上的一块饼干。包含该 cookie 的正方形现在是空的。
作为输入，您将获得 Snuke 吃完饼干后网格的状态。
正方形(i,j)的状态表示为字符 S i,j，其中 '#' 表示带有 cookie 的正方形，和 '.' 表示没有格子的正方形。
找到放着 Snuke 吃掉的饼干的方块。(答案是唯一确定的。)

暴力。
======

Input 1
5 6
......
..#.#.
..###.
..###.
......
Output 1
2 4

Input 2
3 2
#.
##
##
Output 2
1 2

Input 3
6 6
..####
..##.#
..####
..####
..####
......
Output 3
2 5
 */