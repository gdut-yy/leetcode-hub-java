package p1828;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1828B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] p = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                p[i] = scanner.nextInt();
            }
            System.out.println(solve(n, p));
        }
    }

    private static String solve(int n, int[] p) {
        int gcd = 0;
        for (int i = 1; i <= n; i++) {
            gcd = getGCD(gcd, Math.abs(p[i] - i));
        }
        return String.valueOf(gcd);
    }

    private static int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
B. Permutation Swap
https://codeforces.com/contest/1828/problem/B

题目大意：
给你一个未排序的排列 p1,p2,...,pn。为了对排列排序，你选择一个常数 k (k≥1)，并对排列进行一些操作。在一个操作中，你可以选择两个整数 i, j(1≤j<i≤n)，使 i-j=k，然后交换 pi 和 pj。
对于给定的排列，k 的最大值是多少?
排列是由 n 个不同的整数以任意顺序从 1 到 n 组成的数组。例如，[2,3,1,5,4]是一个排列，但[1,2,2]不是一个排列(2 在数组中出现两次)，[1,3,4]也不是一个排列(n=3，但数组中有 4)。
一个未排序的排列 p 是这样一个排列，使得至少有一个位置 i 满足 pi≠i。

GCD
======

input
7
3
3 1 2
4
3 4 1 2
7
4 2 6 7 5 3 1
9
1 6 7 4 9 2 3 8 5
6
1 5 3 4 2 6
10
3 10 5 2 9 6 7 8 1 4
11
1 11 6 4 8 3 7 5 9 10 2
output
1
2
3
4
3
2
3
 */
