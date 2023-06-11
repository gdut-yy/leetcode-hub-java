package p1829;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1829B {
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
        int ans = 0;
        int cnt0 = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                cnt0++;
                ans = Math.max(ans, cnt0);
            } else {
                cnt0 = 0;
            }
        }
        return String.valueOf(ans);
    }
}
/*
B. Blank Space
https://codeforces.com/contest/1829/problem/B

题目大意：
给你一个有 n 个元素的二进制数组，一个二进制数组就是一个只包含 0 和 1 的数组。
空白是一段只有 0 的连续元素。
你的任务是找出最长的空白的长度。

贪心。
======

input
5
5
1 0 0 1 0
4
0 1 1 1
1
0
3
1 1 1
9
1 0 0 0 1 0 0 0 1
output
2
1
1
0
3
 */

