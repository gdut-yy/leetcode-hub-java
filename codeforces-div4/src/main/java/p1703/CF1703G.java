package p1703;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1703G {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            System.out.println(solve(n, k, a));
        }
    }

    private static String solve(int n, int k, int[] a) {
        // 前缀和
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + a[i] - k;
        }

        long max = preSum[n];
        for (int i = -1; i < n; i++) {
            long newSum = preSum[i + 1];
            // 最多往后统计 31 个数
            for (int j = i + 1; j < Math.min(n, i + 32); j++) {
                int aj = a[j];
                aj = aj >> (j - i);
                newSum += aj;
            }
            max = Math.max(max, newSum);
        }
        return String.valueOf(max);
    }
}
/*
G. Good Key, Bad Key
https://codeforces.com/contest/1703/problem/G

题目大意：
给定整数 n、k，箱子数量和一把好钥匙的花费，长度为 n 的数组 a，代表每个箱子的价值；可以花费 k 打开箱子或者使当前和之后箱子价值 /2 打开箱子。求最大值

可以证明好钥匙前不会有坏钥匙，即序列是单调的 好好好坏坏坏坏，又因为 10^9 最多 /2 31 次，枚举每个位置，及算出其后 31 个箱子价值即可。
======

input
5
4 5
10 10 3 1
1 2
1
3 12
10 10 29
12 51
5 74 89 45 18 69 67 67 11 96 23 59
2 57
85 60

output
11
0
13
60
58
 */