package p1873;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1873C {
    static int n = 10;
    static char[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            a = new char[n][n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.next().toCharArray();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 'X') {
                    int dx = Math.min(i, n - 1 - i);
                    int dy = Math.min(j, n - 1 - j);
                    int d = Math.min(dx, dy);
                    ans += d + 1;
                }
            }
        }
        return String.valueOf(ans);
    }
}
/*
C. Target Practice
https://codeforces.com/contest/1873/problem/C

题目大意：
如图所示，10×10 目标由五个“环”组成。每个环都有不同的点值:最外面的环- 1 分，下一个环- 2 分,...,中心环- 5 点。
弗拉德向目标射出了几支箭。帮他算一下他得了多少分。

数学
======

input
4
X.........
..........
.......X..
.....X....
......X...
..........
.........X
..X.......
..........
.........X
..........
..........
..........
..........
..........
..........
..........
..........
..........
..........
..........
..........
..........
..........
....X.....
..........
..........
..........
..........
..........
XXXXXXXXXX
XXXXXXXXXX
XXXXXXXXXX
XXXXXXXXXX
XXXXXXXXXX
XXXXXXXXXX
XXXXXXXXXX
XXXXXXXXXX
XXXXXXXXXX
XXXXXXXXXX
output
17
0
5
220
 */
