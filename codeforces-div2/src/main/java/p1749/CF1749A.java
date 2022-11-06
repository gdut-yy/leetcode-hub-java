package p1749;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1749A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] x = new int[m];
            int[] y = new int[m];
            for (int j = 0; j < m; j++) {
                x[j] = scanner.nextInt();
                y[j] = scanner.nextInt();
            }
            System.out.println(solve(n, m, x, y));
        }
    }

    private static String solve(int n, int m, int[] x, int[] y) {
        return n == m ? "NO" : "YES";
    }
}
/*
Educational Codeforces Round 138 (Rated for Div. 2)
A. Cowardly Rooks
https://codeforces.com/contest/1749/problem/A

题目大意：
给定整数 n,m 和 m 行 xi,yi。棋盘大小 n*n，rooki 的位置为 xi,yi，rook 会攻击它所在行或列中的所有单元格。
判断是否可以将一个车移动到不同的单元，输出 YES/NO

贪心。当 n == m 时，不能移动。
======

input
2
2 2
1 2
2 1
3 1
2 2

output
NO
YES
 */