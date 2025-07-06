package p1739;

import java.util.Scanner;

public class CF1739E {
    static int n;
    static char[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new char[2][];
        a[0] = scanner.next().toCharArray();
        a[1] = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        int[][] f = new int[n + 1][2];
        for (int j = n - 2; j >= 0; j--) {
            for (int i = 0; i < 2; i++) {
                f[j][i] = f[j + 1][i] + (a[i ^ 1][j] & 1);
                if (a[i ^ 1][j] == '1') {
                    f[j][i] = Math.min(f[j][i], f[j + 2][i ^ 1] + (a[i][j + 1] & 1));
                }
            }
        }
        int cnt1 = 0;
        for (char c : a[0]) if (c == '1') cnt1++;
        for (char c : a[1]) if (c == '1') cnt1++;
        int ans = cnt1 - f[0][0];
        return String.valueOf(ans);
    }
}
/*
E. Cleaning Robot
https://codeforces.com/contest/1739/problem/E

灵茶の试炼 2025-05-09
题目大意：
输入 n(2≤n≤2e5) 和一个 2 行 n 列的 01 矩阵。
这个矩阵表示一条长为 n，宽为 2 的走廊。走廊上某些格子有污渍，用 1 表示。没有污渍的格子用 0 表示。
有一个扫地机器人，从左上角出发。扫地机每一步可以移动到上下左右相邻的格子。
每次，扫地机会移动到（曼哈顿）距离最近的污渍，打扫干净。重复该过程，直到没有污渍。
但如果有多个污渍都离扫地机最近呢？扫地机会宕机！
为避免扫地机宕机，你需要在扫地机开始工作之前，手动清理掉一部分污渍。
输出留给扫地机清理的最大污渍数。

rating 2400
https://www.luogu.com.cn/article/gki8umo6
======

Input
2
01
11
Output
2

Input
2
01
01
Output
2

Input
4
0101
1011
Output
4

Input
4
0000
0000
Output
0

Input
5
00011
10101
Output
4

Input
6
011111
111111
Output
8

Input
10
0101001010
1010100110
Output
6
 */
