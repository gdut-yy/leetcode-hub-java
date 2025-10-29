package c205;

import java.io.PrintWriter;
import java.util.Scanner;

public class Arc205_a {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static int[][] ps2d;

    private static void solve() {
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        char[][] a = new char[n][];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next().toCharArray();
        }

        int[][] b = new int[n][n];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (a[i - 1][j - 1] == '.' && a[i][j - 1] == '.' && a[i - 1][j] == '.' && a[i][j] == '.') {
                    b[i][j] = 1;
                }
            }
        }
        ps2d = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                ps2d[i][j] = ps2d[i - 1][j] + ps2d[i][j - 1] - ps2d[i - 1][j - 1] + b[i - 1][j - 1];
            }
        }

        while (q-- > 0) {
            int u = scanner.nextInt() - 1;
            int d = scanner.nextInt() - 1;
            int l = scanner.nextInt() - 1;
            int r = scanner.nextInt() - 1;

//            int ans = 0;
//            for (int i = u + 1; i <= d; i++) {
//                for (int j = l + 1; j <= r; j++) {
//                    if (a[i - 1][j - 1] == '.' && a[i][j - 1] == '.' && a[i - 1][j] == '.' && a[i][j] == '.') {
//                        ans++;
//                    }
//                }
//            }
//            out.println(ans);
            int ans = sumRegion(u + 1, l + 1, d, r);
            out.println(ans);
        }
    }

    static int sumRegion(int x1, int y1, int x2, int y2) {
        return ps2d[x2 + 1][y2 + 1] - ps2d[x2 + 1][y1] - ps2d[x1][y2 + 1] + ps2d[x1][y1];
    }
}
/*
A - 2x2 Erasing
https://atcoder.jp/contests/arc205/tasks/arc205_a

题目大意：
有一个网格，网格中有 N 行和 N 列。让 (r,c) 表示从上往下数 r 行，从左往上数 c 列的单元格。每个单元格的颜色为黑色或白色。当 S_{r,c} 为 "#"时，单元格 (r,c) 显示为黑色；当 S_{r,c} 为". "时，单元格 (r,c) 显示为白色。
关于这个网格，你有 Q 个问题，请逐一回答。在 i-th 问题 (1<= i<= Q) 中，给出了整数 U_i,D_i,L_i,R_i ，请找出下面问题的答案。
- 将所有不满足 U_i <= r <= D_i 和 L_i <= c <= R_i 的单元格涂成黑色后，求进行下面操作的最大次数。
    - 选择一对整数 (r,c) ，使得单元格 (r,c),(r,c+1),(r+1,c),(r+1,c+1) 全部涂成白色，然后将这四个单元格中的一个涂成黑色。
独立解决每个问题。换句话说，每道题的每个单元格的颜色都会重置为初始状态。

二维前缀和
======

Input 1
5 4
..#.#
.....
#....
...#.
.#...
1 3 1 3
3 5 3 5
2 3 1 4
1 5 1 5
Output 1
2
0
2
5

Input 2
7 6
#.#....
.....#.
.......
.#..#.#
#....#.
.......
....##.
1 3 2 7
4 6 1 6
6 7 2 7
3 5 4 6
1 6 2 4
1 7 1 7
Output 2
4
4
2
0
6
13
 */
