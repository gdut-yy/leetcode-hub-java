package p1676;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1676H1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    private static String solve(int n, int[] a) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] >= a[j]) {
                    cnt++;
                }
            }
        }
        return String.valueOf(cnt);
    }
}
/*
H1. Maximum Crossings (Easy Version)
https://codeforces.com/contest/1676/problem/H1

题目大意：
给定整数 n 和长度为 n 的数组 a。表示从 i 到 a[i] 的一条线段。求所有线段最大交叉数。(n <= 1000)

当 i<j，比较 ai, aj
当 ai < aj 时，则不可能相交；
当 ai > aj 时，必定相交；
当 ai = aj 时，可以通过调整顺序使它们相交，因此问题转化为求 ai >= aj 的对数（逆序对问题）。

当 n <= 1000，可以直接暴力求解。
======

input
4
7
4 1 4 6 7 7 5
2
2 1
1
1
3
2 2 2

output
6
1
0
3
 */