package p1864;

import java.util.Scanner;

public class CF1864D {
    static int n;
    static char[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new char[n][n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.next().toCharArray();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int[] f = new int[n];
        int[] diag1 = new int[n * 2];
        int[] diag2 = new int[n * 2];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            char[] s = a[i];
            for (int j = 0; j < n; j++) {
                char c = s[j];
                f[j] ^= diag1[i - j + n] ^ diag2[i + j];
                if (f[j] != (c & 1)) {
                    ans++;
                    f[j] ^= 1;
                    diag1[i - j + n] ^= 1;
                    diag2[i + j] ^= 1;
                }
            }
        }
        return String.valueOf(ans);
    }
}
/*
D. Matrix Cascade
https://codeforces.com/contest/1864/problem/D

灵茶の试炼 2024-09-11
题目大意：
输入 T(≤1e5) 表示 T 组数据。所有数据的 n^2 之和 ≤9e6。
每组数据输入 n(2≤n≤3000) 和 n 行 n 列的 01 矩阵。
每次操作，你可以选择一个格子 (i,j)，然后翻转所有满足 x >= i 和 x-i >= |y-j| 的格子 (x,y)。
翻转即 0 变 1，1 变 0。
把矩阵元素全部变为 0，最少要操作多少次？

rating 1700
比官解简单 1e9+7 倍的做法。
从第一排开始思考。
考虑 (i,j) 处的格子反转了多少次，记作 f[i][j]。
看右边的图。
图一，f[i][j] 是顶点为 (i,j) 的倒三角形中的执行了反转操作的格子个数。
图二，f[i][j] 是如下三部分之和：
1. 左上方向执行了反转操作的格子个数。用数组 diag1 维护。(i,j) 所处的（主对角线方向的）斜线为 diag1[i-j+n]。
2. 右上方向执行了反转操作的格子个数。用数组 diag2 维护。(i,j) 所处的（副对角线方向的）斜线为 diag2[i+j]。
3. f[i-1][j]。
用这个转移方程计算 f[i][j]，即
f[i][j] = f[i-1][j] + diag1[i-j+n] + diag2[i+j]
由于反转偶数次等于没有反转，只需维护 f[i][j] 的奇偶性，加法运算变成异或运算。
代码实现时，f 数组的第一个维度可以优化掉，即
f[j] ^= diag1[i-j+n] ^ diag2[i+j]
代码 https://codeforces.com/problemset/submission/1864/280262309
======

Input
3
5
00100
01110
11111
11111
11111
3
100
110
110
6
010101
111101
011110
000000
111010
001110
Output
1
2
15
 */
