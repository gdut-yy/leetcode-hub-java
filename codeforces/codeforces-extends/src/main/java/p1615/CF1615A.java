package p1615;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1615A {
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
        long sum = 0;
        for (int ai : a) {
            sum += ai;
        }
        if (sum % n == 0) {
            return "0";
        }
        return "1";
    }
}
/*
Codeforces Global Round 18
A. Closing The Gap
https://codeforces.com/contest/1615/problem/A

题目大意：
给出整数 n 和长度为 n 的数组 a。规定可以 a[i]-1, a[j]+1 任意次，求最大高度差最少值为多少。

贪心。最终结果为所有高度平均，只有 0（数组之和恰好能整除 n） 和 1（数组之和不能整除 n） 两种可能
======

input
3
3
10 10 10
4
3 2 1 2
5
1 2 3 1 5

output
0
0
1
 */