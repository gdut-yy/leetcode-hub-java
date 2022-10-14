package p1741;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1741D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int m = scanner.nextInt();
            int[] p = new int[m];
            for (int j = 0; j < m; j++) {
                p[j] = scanner.nextInt();
            }
            System.out.println(solve(m, p));
        }
    }

    private static String solve(int m, int[] p) {
        int cnt = 0;
        for (int step = 2; step <= m / 2; step *= 2) {
            for (int i = 0; i < m; i += step) {
                int j = i + step / 2;
                if (Math.abs(p[i] - p[j]) == j - i) {
                    if (p[i] > p[j]) {
                        cnt++;
                        int tmp = p[i];
                        p[i] = p[j];
                        p[j] = tmp;
                    }
                } else {
                    return "-1";
                }
            }
        }
        return String.valueOf(p[0] != 1 ? cnt + 1 : cnt);
    }
}
/*
D. Masha and a Beautiful Tree
https://codeforces.com/contest/1741/problem/D

题目大意：
给定整数 m 和长度为 m 的排列 p，m 为 2 次幂。在一个操作中，Masha 可以选择树的任何非叶顶点，并交换它的左右子结点(以及它们的子树)。
求树的叶子上的值从左到右按递增的顺序排列的最小操作数。如果不可能，返回 -1。

自下向上递归，如果逆序，则操作数 +1。如果差值绝对值不等，返回-1。
======

input
4
8
6 5 7 8 4 3 1 2
4
3 1 4 2
1
1
8
7 8 4 3 1 2 6 5

output
4
-1
0
-1
 */