package c295;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc295_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        char[][] b = new char[r][c];
        for (int i = 0; i < r; i++) {
            b[i] = scanner.next().toCharArray();
        }
        System.out.println(solve(r, c, b));
    }

    private static String solve(int r, int c, char[][] b) {
        char[][] resArr = new char[r][c];
        for (int i = 0; i < r; i++) {
            System.arraycopy(b[i], 0, resArr[i], 0, c);
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (check(r, c, b, i, j)) {
                    resArr[i][j] = '.';
                }
            }
        }

        String[] res = new String[r];
        for (int i = 0; i < r; i++) {
            res[i] = new String(resArr[i]);
        }
        return String.join(System.lineSeparator(), res);
    }

    private static boolean check(int r, int c, char[][] b, int x, int y) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if ('1' <= b[i][j] && b[i][j] <= '9') {
                    int d = b[i][j] - '0';
                    if (Math.abs(i - x) + Math.abs(j - y) <= d) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
/*
B - Bombs
https://atcoder.jp/contests/abc295/tasks/abc295_b

题目大意：
board 上 R 行是水平的 C 列是垂直的。设(i,j)表示从上面开始的第 i 行和从左边开始的第 j 列的正方形。
给定字符 B i,j 表示(i,j)的当前状态。表示一个空的正方形; # 表示有墙的正方形; 1,2,...,9 分别代表一个方形，炸弹的威力为 1,2,...,9。
下一时刻，所有炸弹将同时爆炸。当炸弹爆炸时，在不大于炸弹的威力的曼哈顿距离内，每个广场都会变成一个空广场。此处，从(r1, c1)到(r2, c2) 的曼哈顿距离为 ∣r1−r2∣+∣c1−c2∣。
在爆炸后打印 board。
1≤R,C≤20

数据范围较小，枚举 每个单元格 暴力判断。
======

Input
4 4
.1.#
###.
.#2.
#.##
Output
...#
#...
....
#...

Input
2 5
..#.#
###.#
Output
..#.#
###.#

Input
2 3
11#
###
Output
...
..#
 */