package p1839;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1839A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            System.out.println(solve(n, k));
        }
    }

    private static String solve(int n, int k) {
        int[] a = new int[n];
        int ones = 0;
        for (int i = 1; i <= n; i++) {
            if ((i + k - 1) / k > ones) {
                ones++;
                a[i - 1] = 1;
            }
        }
        // 末尾肯定是 1
        if (a[n - 1] == 0) {
            ones++;
        }
        return String.valueOf(ones);
    }
}
/*
Codeforces Round 876 (Div. 2) https://www.bilibili.com/video/BV1rW4y1R7z5/
A. The Good Array
https://codeforces.com/contest/1839/problem/A

题目大意：
给你两个整数 n 和 k。
一个由 0 和 1 组成的长度为 n 的数组 a1,a2,...,an 是好的，如果对于从 1 到 n 的所有整数 i 同时满足以下两个条件:
- a 的前 i 个元素中至少有 ceil(i/k) 等于 1，
- a 的后 i 个元素中至少有 ceil(i/k) 等于 1。
这里，ceil(i/k) 表示 i 除以 k 的结果，四舍五入。例如 ceil(6/3)=2, ceil(11/5)=3, ceil(7/4)=2
在一个好的数组中找到可能 1 的最小数目。

======

input
7
3 2
5 2
9 3
7 1
10 4
9 5
8 8
output
2
3
4
7
4
3
2
 */
