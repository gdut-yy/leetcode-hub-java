package c290;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc290_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve(n, m, a, b));
    }

    private static String solve(int n, int m, int[] a, int[] b) {
        int sum = 0;
        for (int bi : b) {
            sum += a[bi - 1];
        }
        return String.valueOf(sum);
    }
}
/*
A - Contest Result
https://atcoder.jp/contests/abc290/tasks/abc290_a

题目大意：
有一个有 N 个问题的竞赛。第 i 个(1≤i≤N)问题值 ai 分。
Snuke 参加了这次比赛，并解决了 M 个问题:b1-th, b2-th,..,bm-th。找出他的总分。
在这里，总分被定义为他解决的问题的积分总和。

模拟。
======

Input 1
3 2
10 20 30
1 3
Output 1
40

Input 2
4 1
1 1 1 100
4
Output 2
100

Input 3
8 4
22 75 26 45 72 81 47 29
4 6 7 8
Output 3
202
 */