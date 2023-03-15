package p1760;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1760D {
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
        int min = Arrays.stream(a).min().orElseThrow();
        int low = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == min) {
                low = i;
                break;
            }
        }

        for (int i = 1; i < low; i++) {
            if (a[i - 1] < a[i]) {
                return "NO";
            }
        }

        for (int i = low + 1; i < n; i++) {
            if (a[i - 1] > a[i]) {
                return "NO";
            }
        }
        return "YES";
    }
}
/*
D. Challenging Valleys
https://codeforces.com/contest/1760/problem/D

题目大意：
给定整数 n 和长度为 n 的数组 a。判断其是否是一个 "valley"（山谷）。

一开始以为最小值连续就满足，后面发现次小值也有可能形成 "valley"（山谷）。
找到最小值后，左侧递减，右侧递增。
======

input
6
7
3 2 2 1 2 2 3
11
1 1 1 2 3 3 4 5 6 6 6
7
1 2 3 4 3 2 1
7
9 7 4 6 9 9 10
1
1000000000
8
9 4 4 5 9 4 9 10

output
YES
YES
NO
YES
YES
NO
 */