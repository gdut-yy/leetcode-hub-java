package c377;

import java.util.Scanner;

public class Abc377_b {
    static char[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        a = new char[8][];
        for (int i = 0; i < 8; i++) {
            a[i] = scanner.next().toCharArray();
        }
        System.out.println(solve());
    }

    private static String solve() {
        boolean[] row = new boolean[8];
        boolean[] col = new boolean[8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (a[i][j] == '#') {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!row[i] && !col[j]) ans++;
            }
        }
        return String.valueOf(ans);
    }
}
/*
B - Avoid Rook Attack
https://atcoder.jp/contests/abc377/tasks/abc377_b

题目大意：
有一个由 $64$ 个正方形组成的网格，网格中有 $8$ 行和 $8$ 列。让 $(i,j)$ 表示从上面 $(1\leq i\leq8)$ 起第 $i$ 行，从左边 $(1\leq j\leq8)$ 起第 $j$ 列的正方形。
每个方格要么是空的，要么有棋子放在上面。方格的状态由长度为 $8$ 的 $8$ 字符串序列 $(S_1,S_2,S_3,\ldots,S_8)$ 表示。方格 $(i,j)$ 如果 $S_i$ 的 $j$ -th 字符是 `.`，则 $(1\leq i\leq8,1\leq j\leq8)$ 为空；如果是 `#`，则有棋子。
您要将棋子放在**空位**上，使它**不能被任何现有棋子吃掉**。
放置在位置 $(i,j)$ 上的棋子可以吃掉满足以下任一条件的棋子：
- 放置在 $i$ 行的一个位置上
- 放置在 $j$ 列的一个位置上
例如，位于 $(4,4)$ 位置上的棋子可以吃掉位于下图中蓝色所示位置上的棋子：
您可以将棋子放在几个位置上？

分别记录行列。
======

Input 1
...#....
#.......
.......#
....#...
.#......
........
........
..#.....
Output 1
4

Input 2
........
........
........
........
........
........
........
........
Output 2
64

Input 3
.#......
..#..#..
....#...
........
..#....#
........
...#....
....#...
Output 3
4
 */
