package p1985;

import java.util.Scanner;

public class CF1985D {
    static int n, m;
    static char[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            a = new char[n][m];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.next().toCharArray();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int mnI = n, mxI = 0, mnJ = m, mxJ = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == '#') {
                    mnI = Math.min(mnI, i);
                    mxI = Math.max(mxI, i);

                    mnJ = Math.min(mnJ, j);
                    mxJ = Math.max(mxJ, j);
                }
            }
        }
        int ans_i = (mnI + mxI) / 2 + 1;
        int ans_j = (mnJ + mxJ) / 2 + 1;
        return ans_i + " " + ans_j;
    }
}
/*
D. Manhattan Circle
https://codeforces.com/contest/1985/problem/D

题目大意：
给定一个由". "和 "#"字符组成的 $n$ 乘 $m$ 网格，网格上存在一个完整的曼哈顿圆。网格左上角的坐标为 $(1,1)$ ，右下角的坐标为 $(n, m)$ 。
点（ $a, b$ ）属于以（ $h, k$ ）为中心的曼哈顿圆，如果 $|h - a| + |k - b| &lt; r$ ，其中 $r$ 是一个正常数。
在网格上，属于曼哈顿圆的点集被标记为 "#"。求圆心坐标。

数学。
======

Input
6
5 5
.....
.....
..#..
.....
.....
5 5
..#..
.###.
#####
.###.
..#..
5 6
......
......
.#....
###...
.#....
1 1
#
5 6
...#..
..###.
.#####
..###.
...#..
2 10
..........
...#......
Output
3 3
3 3
4 2
1 1
3 4
2 4
 */
