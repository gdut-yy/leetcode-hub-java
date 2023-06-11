package p1690;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1690B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            for (int j = 0; j < n; j++) {
                b[j] = scanner.nextInt();
            }
            System.out.println(solve(n, a, b));
        }
    }

    private static String solve(int n, int[] a, int[] b) {
        int maxDiff = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] < b[i]) {
                return "NO";
            }
            maxDiff = Math.max(maxDiff, a[i] - b[i]);
        }

        for (int i = 0; i < n; i++) {
            int diff = a[i] - b[i];
            if (b[i] != 0) {
                if (diff != maxDiff) {
                    return "NO";
                }
            }
        }
        return "YES";
    }
}
/*
B. Array Decrements
https://codeforces.com/contest/1690/problem/B

题目大意：
给定整数 n 和长度为 n 的数组 a，数组 b，每次操作可将每个 ai 替换为 ai-1，问能否通过若干次操作使数组 a 等于数组 b。

贪心。比较最大值。如果 bi 不为 0，ai-bi 需等于最大值，否则可以小于等于最大值。
======

input
6
4
3 5 4 1
1 3 2 0
3
1 2 1
0 1 0
4
5 3 7 2
1 1 1 1
5
1 2 3 4 5
1 2 3 4 6
1
8
0
1
4
6

output
YES
YES
NO
NO
YES
NO
 */