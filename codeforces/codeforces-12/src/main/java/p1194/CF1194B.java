package p1194;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1194B {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) V2.solve();
        out.flush();
    }

    // 写法一
    static class V1 {
        private static void solve() {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] row = new int[n];
            int[] col = new int[m];
            char[][] a = new char[n][];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.next().toCharArray();
                for (int j = 0; j < a[i].length; j++) {
                    char b = a[i][j];
                    if (b == '.') {
                        row[i]++;
                        col[j]++;
                    }
                }

            }
            int ans = n + m;
            for (int i = 0; i < n; i++) {
                int r = row[i];
                for (int j = 0; j < m; j++) {
                    int c = col[j];
                    ans = Math.min(ans, r + c - (a[i][j] >> 2 & 1));
                }
            }
            out.println(ans);
        }
    }

    // 写法二
    static class V2 {
        private static void solve() {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] col = new int[m];
            char[][] a = new char[n][];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.next().toCharArray();
                for (int j = 0; j < a[i].length; j++) {
                    char b = a[i][j];
                    col[j] += b >> 2 & 1;
                }
            }
            int ans = n + m;
            for (int i = 0; i < n; i++) {
                int r = 0;
                for (int j = 0; j < m; j++) {
                    if (a[i][j] == '.') r++;
                }
                for (int j = 0; j < m; j++) {
                    int c = col[j];
                    ans = Math.min(ans, r + c - (a[i][j] >> 2 & 1));
                }
            }
            out.println(ans);
        }
    }
}
/*
B. Yet Another Crosses Problem
https://codeforces.com/contest/1194/problem/B

灵茶の试炼 2025-09-22
题目大意：
输入 T(≤5e4) 表示 T 组数据。所有数据的 n 之和 ≤5e4，n*m 之和 ≤4e5。
每组数据输入 n m(1≤n,m≤5e4 且 n*m≤4e5) 和 n 行 m 列的字符矩阵，只包含 '.' 和 '*'。
你需要把矩阵中的某些格子改成 '*'，使得矩阵中存在一个十字 '*'，即一整行和一整列都是 '*'。
输出最小修改次数。

rating 1300
对于每个十字的中心 (i,j)，我们需要知道第 i 行的 '.' 的个数，第 j 列的 '.' 的个数，二者相加。
但是，如果 (i,j) 也是 '.'，就多算了一个，要减去。
为了快速知道第 i 行的 '.' 的个数，第 j 列的 '.' 的个数，可以提前预处理两个数组，记录每一行的 '.' 的个数，以及每一列的 '.' 的个数。
写法一 https://codeforces.com/problemset/submission/1194/338057972
写法二 https://codeforces.com/problemset/submission/1194/338058352
代码备份（上面打不开的同学看这个）
======

Input
9
5 5
..*..
..*..
*****
..*..
..*..
3 4
****
.*..
.*..
4 3
***
*..
*..
*..
5 5
*****
*.*.*
*****
..*.*
..***
1 4
****
5 5
.....
..*..
.***.
..*..
.....
5 3
...
.*.
.*.
***
.*.
3 3
.*.
*.*
.*.
4 4
*.**
....
*.**
*.**
Output
0
0
0
0
0
4
1
1
2
 */
