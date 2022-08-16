package p1625;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1625A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int l = scanner.nextInt();
            int[] x = new int[n];
            for (int j = 0; j < n; j++) {
                x[j] = scanner.nextInt();
            }
            System.out.println(solve(n, l, x));
        }
    }

    private static String solve(int n, int l, int[] x) {
        int[] cnt = new int[l];
        for (int i = 0; i < n; i++) {
            // 转二进制
            String binaryString = Integer.toBinaryString(x[i]);
            int repeat0 = l - binaryString.length();
            binaryString = "0".repeat(repeat0) + binaryString;
            for (int j = 0; j < l; j++) {
                int num = binaryString.charAt(j) == '1' ? 1 : 0;
                cnt[j] += num;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int half = n / 2;
        for (int j = 0; j < l; j++) {
            if (cnt[j] > half) {
                stringBuilder.append("1");
            } else {
                stringBuilder.append("0");
            }
        }
        return String.valueOf(Integer.parseInt(stringBuilder.toString(), 2));
    }
}
/*
Codeforces Round #765 (Div. 2)
A. Ancient Civilization
https://codeforces.com/contest/1625/problem/A

题目大意：
给出整数 n、l 和长度为 n 的数组 x，定义 d(x,y) 为 (xi, y) 的汉明距离，求使得数组 x 距离之和最小的 y。

贪心，要使距离最少，则 y 二进制每一位应为 xi 二进制的多数位。
x1: 10010
x2: 01001
x3: 10101
y = 10001
======

input
7
3 5
18 9 21
3 5
18 18 18
1 1
1
5 30
1 2 3 4 5
6 10
99 35 85 46 78 55
2 1
0 1
8 8
5 16 42 15 83 65 78 42

output
17
18
1
1
39
0
2
 */