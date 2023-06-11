package p1692;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1692E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int s = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            System.out.println(solve(n, s, a));
        }
    }

    private static String solve(int n, int s, int[] a) {
        // 前缀和
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + a[i];
        }
        // 无解
        if (preSum[n] < s) {
            return "-1";
        }

        // 双指针
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < n) {
            while (right < n && preSum[right + 1] - preSum[left] <= s) {
                right++;
            }
            max = Math.max(max, right - left);
            left++;
        }
        return String.valueOf(n - max);
    }
}
/*
E. Binary Deque
https://codeforces.com/contest/1692/problem/E

题目大意：
给定整数 n,s 和长度为 n 的数组 a，每次操作可以删除数组第一个元素或最后一个元素。求使数组和等于 s 的最少操作次数，如果无法等于 s，输出 -1.

前缀和 + 双指针。
======

input
7
3 1
1 0 0
3 1
1 1 0
9 3
0 1 0 1 1 1 0 0 1
6 4
1 1 1 1 1 1
5 1
0 0 1 1 0
16 2
1 1 0 0 1 0 0 1 1 0 0 0 0 0 1 1
6 3
1 0 1 0 0 0

output
0
1
3
2
2
7
-1
 */