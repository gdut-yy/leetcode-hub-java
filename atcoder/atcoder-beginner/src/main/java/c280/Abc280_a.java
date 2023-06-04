package c280;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc280_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        char[][] s = new char[h][w];
        for (int i = 0; i < h; i++) {
            s[i] = scanner.next().toCharArray();
        }
        System.out.println(solve(h, w, s));
    }

    private static String solve(int h, int w, char[][] s) {
        int ans = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (s[i][j] == '#') {
                    ans++;
                }
            }
        }
        return String.valueOf(ans);
    }
}
/*
A - Pawn on a Grid
https://atcoder.jp/contests/abc280/tasks/abc280_a

题目大意：
有一个网格，从上到下有 H 行，从左到右有 W 列。每个方块上都有一个棋子，或者是空的。
网格的状态由长度为 W 的字符串 s1, s2，…，S H 表示。
- 如果 s1 的第 j 个字符是 '#'，则从上到下第 i 行、从左到第 j 列的正方形上有一块;
- 如果 s1 的第 j 个字符是 '.'，则从上到下第 i 行、从左到第 j 列的正方形为空。
网格中有多少方格上有棋子?

计数。
======

Input 1
3 5
#....
.....
.##..
Output 1
3

Input 2
1 10
..........
Output 2
0

Input 3
6 5
#.#.#
....#
..##.
####.
..#..
#####
Output 3
16
 */