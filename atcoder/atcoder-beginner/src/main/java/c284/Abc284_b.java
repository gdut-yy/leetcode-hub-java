package c284;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc284_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    private static String solve(int n, int[] a) {
        int cnt = 0;
        for (int x : a) {
            if (x % 2 == 1) {
                cnt++;
            }
        }
        return String.valueOf(cnt);
    }
}
/*
B - Multi Test Cases
https://atcoder.jp/contests/abc284/tasks/abc284_b

题目大意：
在这个问题中，一个输入文件包含多个测试用例。
首先给定一个整数 T，针对 T 测试用例解决以下问题。
- 我们有 N 个正整数 a1,a2,...,an 有多少是奇数?

计数。
======

Input 1
4
3
1 2 3
2
20 23
10
6 10 4 1 5 9 8 6 5 1
1
1000000000
Output 1
2
1
5
0
 */