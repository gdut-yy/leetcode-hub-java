package p1359;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1359D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve(n, a));
    }

    private static String solve(int n, int[] a) {
        int ans = 0;
        for (int maxB = 1; maxB <= 30; maxB++) {
            int i = 0;
            while (true) {
                while (i < n && a[i] > maxB) {
                    i++;
                }
                if (i == n) {
                    break;
                }
                int sum = a[i];
                int maxSum = a[i];
                i++;
                while (i < n && a[i] <= maxB) {
                    sum = Math.max(sum + a[i], a[i]);
                    maxSum = Math.max(maxSum, sum);
                    i++;
                }
                ans = Math.max(ans, maxSum - maxB);
            }
        }
        return String.valueOf(ans);
    }
}
/*
D. Yet Another Yet Another Task
https://codeforces.com/contest/1359/problem/D

灵茶の试炼 2023-01-27
题目大意：
输入 n(1≤n≤1e5) 和长为 n 的数组 a(-30≤a[i]≤30)。
设 b 为 a 的一个非空连续子数组。
输出 sum(b)-max(b) 的最大值。

https://codeforces.com/contest/1359/submission/95405228
注意值域很小。
枚举 max(b)，把 > max(b) 的去掉，分裂出每个子段都求一遍最大子段和（力扣 53 题）再减去枚举的 max(b)。
所有结果的最大值即为答案。
相似题目: 53. 最大子数组和
https://leetcode.cn/problems/maximum-subarray/
======

input
5
5 -2 10 -1 4
output
6

input
8
5 2 5 3 -30 -30 6 9
output
10

input
3
-10 6 -15
output
0
 */
