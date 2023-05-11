package c300;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc300_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        char[][] a = new char[h][w];
        for (int i = 0; i < h; i++) {
            a[i] = scanner.next().toCharArray();
        }
        char[][] b = new char[h][w];
        for (int i = 0; i < h; i++) {
            b[i] = scanner.next().toCharArray();
        }
        System.out.println(solve(h, w, a, b));
    }

    private static String solve(int h, int w, char[][] a, char[][] b) {
        for (int s = 0; s < h; s++) {
            for (int t = 0; t < w; t++) {
                if (check(h, w, a, b, s, t)) {
                    return "Yes";
                }
            }
        }
        return "No";
    }

    private static boolean check(int h, int w, char[][] a, char[][] b, int s, int t) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (a[i][j] != b[(i + s) % h][(j + t) % w]) {
                    return false;
                }
            }
        }
        return true;
    }
}
/*
B - Same Map in the RPG World
https://atcoder.jp/contests/abc300/tasks/abc300_b

题目大意：
高桥正在开发一种 RPG。他决定编写一个代码来检查两个地图是否相等。
我们有网格 A 和 B，有 H 横行和 W 纵列。网格中的每个单元格都有一个符号 # or . 写在上面。
在 A 和 B 中，从上至第 i 行和从左至第 j 列的单元格上所写的符号分别用 A i,j 和 B i,j 表示。
以下两种操作称为垂直移位和水平移位。
- 对于每个 j=1,2,...,W，同时执行以下操作:
  - 同时将 a1,j, a2,j,...,A H - 1,j,A H,j 替换为 a2,j, a3,j,...,A H,j, a1,j。
- 对于每个 i=1,2,...,H，同时执行以下操作:
  - 同时将 A i,1,A i,2,...,A i,W - 1,A i,W 替换为 A i,2,A i,3,...,A i,W,A i,1。
是否存在一对非负整数(s,t)满足以下条件?如果有，打印 Yes，否则打印 No。
在施加垂直位移 s 次和水平位移 t 次后，a 等于 B。
在这里，当且仅当 A i,j =B i,j 对于所有整数对(i,j)满足 1≤i≤H 且 1≤j≤W，则 A 等于 B。
======

Input
4 3
..#
...
.#.
...
#..
...
.#.
...
Output
Yes

Input
3 2
##
##
#.
..
#.
#.
Output
No

Input
4 5
#####
.#...
.##..
..##.
...##
#...#
#####
...#.
Output
Yes

Input
10 30
..........##########..........
..........####....###.....##..
.....##....##......##...#####.
....####...##..#####...##...##
...##..##..##......##..##....#
#.##....##....##...##..##.....
..##....##.##..#####...##...##
..###..###..............##.##.
.#..####..#..............###..
#..........##.................
................#..........##.
######....................####
....###.....##............####
.....##...#####......##....##.
.#####...##...##....####...##.
.....##..##....#...##..##..##.
##...##..##.....#.##....##....
.#####...##...##..##....##.##.
..........##.##...###..###....
...........###...#..####..#...
Output
Yes
 */