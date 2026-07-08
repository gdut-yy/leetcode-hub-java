package p611;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF611C {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt(), m = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) a[i] = scanner.next();
        int[][] sr = new int[n + 1][m + 1];
        int[][] sc = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sr[i + 1][j + 1] = sr[i + 1][j] + sr[i][j + 1] - sr[i][j];
                sc[i + 1][j + 1] = sc[i + 1][j] + sc[i][j + 1] - sc[i][j];
                if (a[i].charAt(j) == '.') {
                    if (j < m - 1 && a[i].charAt(j + 1) == '.') sr[i + 1][j + 1]++;
                    if (i < n - 1 && a[i + 1].charAt(j) == '.') sc[i + 1][j + 1]++;
                }
            }
        }
        int q = scanner.nextInt();
        while (q-- > 0) {
            int r1 = scanner.nextInt(), c1 = scanner.nextInt(), r2 = scanner.nextInt(), c2 = scanner.nextInt();
            out.println(query(sr, r1 - 1, c1 - 1, r2, c2 - 1) + query(sc, r1 - 1, c1 - 1, r2 - 1, c2));
        }
    }

    static int query(int[][] s, int r1, int c1, int r2, int c2) {
        return s[r2][c2] - s[r2][c1] - s[r1][c2] + s[r1][c1];
    }
}
/*
C. New Year and Domino
https://codeforces.com/contest/611/problem/C

灵茶の试炼 2026-05-06
题目大意：
输入 n m(1≤n,m≤500) 和 n 行 m 列的网格图，只包含 '.' 和 '#'，分别表示空地和障碍物。
然后输入 q(1≤q≤1e5) 和 q 个询问，每个询问输入 r1 c1 r2 c2，表示子矩阵的左上角和右下角。下标从 1 开始。
对于每个询问，计算子矩阵有多少种（在空地上）放置恰好一个多米诺骨牌的方案数（把两个相邻空地涂黑的方案数）。

rating 1500
分别计算横着放的方案数，以及竖着放的方案数。
横着放：如果 a[i][j]=a[i][j+1]='.'，那么把 a[i][j] 视作 1，否则视作 0，计算二维前缀和。回答询问时，计算子矩阵去掉最后一列后的元素和。
竖着放：如果 a[i][j]=a[i+1][j]='.'，那么把 a[i][j] 视作 1，否则视作 0，计算二维前缀和。回答询问时，计算子矩阵去掉最后一行后的元素和。
代码 https://codeforces.com/problemset/submission/611/373588059
代码备份（上面打不开的同学看这个）
======

Input
5 8
....#..#
.#......
##.#....
##..#.##
........
4
1 1 2 3
4 1 4 1
1 2 4 5
2 5 5 8
Output
4
0
10
15

Input
7 39
.......................................
.###..###..#..###.....###..###..#..###.
...#..#.#..#..#.........#..#.#..#..#...
.###..#.#..#..###.....###..#.#..#..###.
.#....#.#..#....#.....#....#.#..#..#.#.
.###..###..#..###.....###..###..#..###.
.......................................
6
1 1 3 20
2 10 6 30
2 10 7 30
2 2 7 7
1 7 7 7
1 8 7 8
Output
53
89
120
23
0
2
 */
