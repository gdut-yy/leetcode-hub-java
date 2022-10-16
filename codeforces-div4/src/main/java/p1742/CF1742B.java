package p1742;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1742B {
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
        Arrays.sort(a);
        for (int i = 1; i < n; i++) {
            if (a[i - 1] >= a[i]) {
                return "NO";
            }
        }
        return "YES";
    }
}
/*
B. Increasing
https://codeforces.com/contest/1742/problem/B

题目大意：
给定整数 n 和长为 n 的数组 a。判断是否可以通过重新排列元素，使数组严格递增。

模拟。
======

input
3
4
1 1 1 1
5
8 7 1 3 4
1
5

output
NO
YES
YES
 */