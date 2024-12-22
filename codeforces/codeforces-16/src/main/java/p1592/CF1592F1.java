package p1592;

import java.util.Scanner;

public class CF1592F1 {
    static int n, m;
    static char[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new char[n][m];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next().toCharArray();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int ans = 0;
        int[][] suf = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                // 二维后缀异或和
                suf[i][j] = suf[i][j + 1] ^ suf[i + 1][j] ^ suf[i + 1][j + 1];
                if (suf[i][j] == (a[i][j] & 1)) { // 需要翻转
                    ans++;
                    a[i][j] = 0; // 表示 (i,j) 处执行了操作 1
                    suf[i][j] ^= 1;
                }
            }
        }

        if (a[n - 1][m - 1] == 0) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < m - 1; j++) {
                    char x = a[i][j];
                    if (x == 0 && a[i][m - 1] == 0 && a[n - 1][j] == 0) {
                        return String.valueOf(ans - 1); // 用 1 次操作 4 代替 4 次操作 1
                    }
                }
            }
        }
        return String.valueOf(ans);
    }
}
/*
F1. Alice and Recoloring 1
https://codeforces.com/contest/1592/problem/F1

灵茶の试炼 2024-08-16
题目大意：
输入 n m(1≤n,m≤500) 和 n 行 m 列的矩阵，只包含字符 B 和 W。
你需要把所有 B 都变成 W。
有如下四种操作：
操作 1：支付 1 元，选择一个包含矩阵左上角 (1,1) 的子矩阵，将其翻转，即 W 变成 B，B 变成 W。
操作 2：支付 2 元，选择一个包含矩阵左下角 (n,1) 的子矩阵，将其翻转。
操作 3：支付 4 元，选择一个包含矩阵右上角 (1,m) 的子矩阵，将其翻转。
操作 4：支付 3 元，选择一个包含矩阵右下角 (n,m) 的子矩阵，将其翻转。
把所有 B 都变成 W，最小总花费是多少？

rating 2600
https://www.luogu.com/article/4bsc4nni
======

Input
3 3
WWW
WBB
WBB
Output
3

Input
10 15
WWWBBBWBBBBBWWW
BBBBWWWBBWWWBBB
BBBWWBWBBBWWWBB
BBWBWBBWWWBBWBW
BBBBWWWBBBWWWBB
BWBBWWBBBBBBWWW
WBWWBBBBWWBBBWW
WWBWWWWBBWWBWWW
BWBWWBWWWWWWBWB
BBBWBWBWBBBWWBW
Output
74
 */
