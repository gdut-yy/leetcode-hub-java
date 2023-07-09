package c309;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc309_b {
    static int n;
    static char[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new char[n][n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next().toCharArray();
        }
        System.out.println(solve());
    }

    private static String solve() {
        char[][] b = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = a[i][j];
            }
        }
        // 上
        for (int j = 1; j < n; j++) {
            b[0][j] = a[0][j - 1];
        }
        // 下
        for (int j = 0; j < n - 1; j++) {
            b[n - 1][j] = a[n - 1][j + 1];
        }
        // 左
        for (int i = 0; i < n - 1; i++) {
            b[i][0] = a[i + 1][0];
        }
        // 右
        for (int i = 1; i < n; i++) {
            b[i][n - 1] = a[i - 1][n - 1];
        }

        return Arrays.stream(b).map(String::new).collect(Collectors.joining(System.lineSeparator()));
    }
}
/*
B - Rotate
https://atcoder.jp/contests/abc309/tasks/abc309_b

题目大意：
给你一个 N 行 N 列的网格。整数 ai,j 写在正方形上，从上到下第 i 行，从左到第 j 列。在这里，可以保证 A (i,j)等于 0 或 1。
将写在外围方格上的整数顺时针移动一个方格，然后打印得到的网格。
在这里，外围的方块是那些至少在第 1-st 行，第 n 行，第 1-st 列和第 n 列中的方块。

模拟
======

Input 1
4
0101
1101
1111
0000
Output 1
1010
1101
0111
0001

Input 2
2
11
11
Output 2
11
11

Input 3
5
01010
01001
10110
00110
01010
Output 3
00101
11000
00111
00110
10100
 */