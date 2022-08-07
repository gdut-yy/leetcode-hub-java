package p1669;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1669F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] w = new int[n];
            for (int j = 0; j < n; j++) {
                w[j] = scanner.nextInt();
            }
            System.out.println(solve(n, w));
        }
    }

    private static String solve(int n, int[] w) {
        int sum = 0;
        int[] reNums = new int[n];
        for (int i = 0; i < n; i++) {
            sum += w[i];
            reNums[n - 1 - i] = w[i];
        }

        // 前缀和
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + w[i];
        }
        int[] rePreSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            rePreSum[i + 1] = rePreSum[i] + reNums[i];
        }

        Map<Integer, Integer> preSumMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int rangSum = preSum[i + 1] - preSum[0];
            if (rangSum <= sum / 2) {
                // left candies
                preSumMap.put(rangSum, i + 1);
            } else {
                break;
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int rangSum = rePreSum[i + 1] - rePreSum[0];
            if (rangSum <= sum / 2) {
                // right candies
                if (preSumMap.containsKey(rangSum)) {
                    max = i + 1 + preSumMap.get(rangSum);
                }
            } else {
                break;
            }
        }
        return String.valueOf(max);
    }
}
/*
F. Eating Candies
https://codeforces.com/contest/1669/problem/F

题目大意：
给定从左到右 n 颗糖果，Alice 和 Bob 分别从左右取等量的糖果，问他们能取到糖果数的最大值。

显然 Alice 和 Bob 每人取到的糖果最大值不会超过总量的一半，在 n <= 2*10^5，枚举前缀和即可。
======

input
4
3
10 20 10
6
2 1 4 2 4 1
5
1 2 4 8 16
9
7 3 20 5 15 1 11 8 10

output
2
6
0
7
 */