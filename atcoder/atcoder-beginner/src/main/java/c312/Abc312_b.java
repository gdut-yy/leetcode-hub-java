package c312;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Abc312_b {
    static int n, m;
    static char[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new char[n][m];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next().toCharArray();
        }
        System.out.println(solve());
    }

    private static String solve() {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i + 8 < n; i++) {
            for (int j = 0; j + 8 < m; j++) {
                if (check(i, j)) {
                    ans.add((i + 1) + " " + (j + 1));
                }
            }
        }
        return String.join(System.lineSeparator(), ans);
    }

    private static boolean check(int x, int y) {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (a[x + i][y + j] != '#') return false;
            }
        }
        for (int i = 6; i <= 8; i++) {
            for (int j = 6; j <= 8; j++) {
                if (a[x + i][y + j] != '#') return false;
            }
        }

        for (int i = 0; i <= 3; i++) {
            if (a[x + i][y + 3] != '.') return false;
        }
        for (int j = 0; j <= 3; j++) {
            if (a[x + 3][y + j] != '.') return false;
        }

        for (int i = 5; i <= 8; i++) {
            if (a[x + i][y + 5] != '.') return false;
        }
        for (int j = 5; j <= 8; j++) {
            if (a[x + 5][y + j] != '.') return false;
        }
        return true;
    }
}
/*
B - TaK Code
https://atcoder.jp/contests/abc312/tasks/abc312_b

题目大意：
高桥发明了“德码”，一种二维码。TaK 守则须符合下列所有条件:
- 它是一个由九行九列组成的区域。
- 左上角和右下角 3 乘 3 区域的所有 18 个单元格都是黑色的。
- 与左上角或右下角的 3 乘 3 区域相邻(水平、垂直或对角线)的所有 14 个单元格都是白色的。
不允许旋转 TaK 代码。
给定一个有 N 行水平和 M 列垂直的网格。网格的状态由 N 个字符串 s1,...,sn 来描述，每个字符串的长度为 m。如果 s1 的第 j 个字符是#，那么上面第 i 行和左边第 j 列的单元格是黑色的，如果是…
找到所有 9 乘 9 的区域，完全包含在网格中，满足 TaK 代码的条件。

暴力
======

Input 1
19 18
###......###......
###......###......
###..#...###..#...
..............#...
..................
..................
......###......###
......###......###
......###......###
.###..............
.###......##......
.###..............
............###...
...##.......###...
...##.......###...
.......###........
.......###........
.......###........
........#.........
Output 1
1 1
1 10
7 7
10 2

Input 2
9 21
###.#...........#.###
###.#...........#.###
###.#...........#.###
....#...........#....
#########...#########
....#...........#....
....#.###...###.#....
....#.###...###.#....
....#.###...###.#....
Output 2
1 1

Input 3
18 18
######............
######............
######............
######............
######............
######............
..................
..................
..................
..................
..................
..................
............######
............######
............######
............######
............######
............######
Output 3

 */