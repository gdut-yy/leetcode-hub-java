package p1690;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1690D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            String line = scanner.next();
            System.out.println(solve(n, k, line));
        }
    }

    private static String solve(int n, int k, String line) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            if (line.charAt(i) == 'B') {
                nums[i] = 1;
            }
        }

        // 前缀和
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int max = 0;
        for (int i = 0; i + k <= n; i++) {
            max = Math.max(max, preSum[i + k] - preSum[i]);
        }
        return String.valueOf(k - max);
    }
}
/*
D. Black and White Stripe
https://codeforces.com/contest/1690/problem/D

题目大意：
给定整数 n,k 和长度为 n 的字符串 line，每个格子不是黑色就是白色，问最少着色多少个格子才能在条纹上有一段连续 k 个黑细胞。

贪心 + 前缀和。将黑色看作 0，白色看作 1，求固定长度为 k 的最小前缀和即为答案。
======

input
4
5 3
BBWBW
5 5
BBWBW
5 1
BBWBW
1 1
W

output
1
2
0
1
 */