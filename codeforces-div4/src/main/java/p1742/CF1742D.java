package p1742;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1742D {
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
        Map<Integer, Integer> last = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            if (!last.containsKey(a[i])) {
                last.put(a[i], i + 1);
            }
        }

        int max = -1;
        for (Map.Entry<Integer, Integer> entry1 : last.entrySet()) {
            for (Map.Entry<Integer, Integer> entry2 : last.entrySet()) {
                if (getGCD(entry1.getKey(), entry2.getKey()) == 1) {
                    max = Math.max(max, entry1.getValue() + entry2.getValue());
                }
            }
        }
        return String.valueOf(max);
    }

    private static int getGCD(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }
}
/*
D. Coprime
https://codeforces.com/contest/1742/problem/D

题目大意：
给定整数 n 和长为 n 的数组 a。求 i+j 的最大值，使 ai 和 aj 为互素（即它们的最大公约数为 1）。如果没有满足的组合，输出 -1。

贪心。观察到 1 ≤ ai ≤ 1000，保存每个 ai 最后出现的索引位置。O(n^2) 暴力枚举即可。
======

input
6
3
3 2 1
7
1 3 5 2 4 7 7
5
1 2 3 4 5
3
2 2 4
6
5 4 3 15 12 16
5
1 2 2 3 6

output
6
12
9
-1
10
7
 */