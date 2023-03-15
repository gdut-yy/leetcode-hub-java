package p1582;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1582B {
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
        int cnt0 = 0;
        int cnt1 = 0;
        for (int ai : a) {
            if (ai == 0) {
                cnt0++;
            } else if (ai == 1) {
                cnt1++;
            }
        }
        if (cnt1 == 0) {
            return "0";
        }
        return String.valueOf((long) (Math.pow(2, cnt0) * cnt1));
    }
}
/*
B. Luntik and Subsequences
https://codeforces.com/contest/1582/problem/B

题目大意：
给出整数 n 和长度为 n 的数组 a。设数组元素和为 s，求和为 s-1 子序列的个数。

数学，显然只与数组中 0 和 1 的个数有关，如果不存在 1，则个数为 0，假设有 a 个 0，b 个 1，则结果为 b*2^a
======

input
5
5
1 2 3 4 5
2
1000 1000
2
1 0
5
3 0 2 1 1
5
2 1 0 3 0

output
1
0
2
4
4
 */