package c277;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc277_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
        }
        System.out.println(solve(n, x, p));
    }

    private static String solve(int n, int x, int[] p) {
        for (int i = 0; i < n; i++) {
            if (p[i] == x) {
                return String.valueOf(i + 1);
            }
        }
        return "-1";
    }
}
/*
A - ^{-1}
https://atcoder.jp/contests/abc277/tasks/abc277_a

题目大意：
给定一个序列 P，它是(1,2，…，N)和一个整数 x 的排列，P 的第 i 项的值是 pi。打印 k，使 P k =X。

遍历。
======

Input 1
4 3
2 3 1 4
Output 1
2

Input 2
5 2
3 5 1 4 2
Output 2
5

Input 3
6 6
1 2 3 4 5 6
Output 3
6
 */